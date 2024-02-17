package com.min.demo.repositories;

import com.min.demo.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface DocumentRepository extends JpaRepository<Document, Long> {
//    @RestResource(path = "/selectedDocuments")
//    public List<Document> findBySelectedIsTrue();
}
