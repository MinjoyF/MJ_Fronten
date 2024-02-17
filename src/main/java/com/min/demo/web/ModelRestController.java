package com.min.demo.web;

import com.min.demo.entities.Document;
import com.min.demo.entities.Model;
import com.min.demo.repositories.DocumentRepository;
import com.min.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/api")
public class ModelRestController {
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @GetMapping(path = "/models",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Model> modelList(){
        return modelRepository.findAll();
    }
    @GetMapping("/models/{id}")
    public Model getOne(@PathVariable(value = "id") Long id ){
        return modelRepository.findById(id).get();
    }
    @PostMapping("/models")
    public Model save (@RequestBody Model model){
        return  modelRepository.save(model);
    }
    @PutMapping("/models/{id}")
    public Model update (@RequestBody Model model , @PathVariable(value = "id")Long id) {
        model.setId(id);
        return modelRepository.save(model);
    }
    @DeleteMapping("/models/{id}")
    public void delete ( @PathVariable(value = "id")Long id) {
         modelRepository.deleteById(id);
    }

    @GetMapping(path = "photoModel/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable(value = "id") Long id) throws Exception{
        Model m =modelRepository.findById(id).get();
      return Files.readAllBytes(Paths
              .get("Ordner/Ghis.png"));

    }

    @GetMapping("download/{fileName}")
    public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
        URI fileBasePath = null;
        Path path = Paths.get(fileBasePath + fileName);
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String contentType = null;
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload/db")
    public ResponseEntity uploadToDB(@RequestParam("file") MultipartFile file) {
        Document doc = new Document();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        doc.setDocName(fileName);
        try {
            doc.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentRepository.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).path("/db")
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }

}
