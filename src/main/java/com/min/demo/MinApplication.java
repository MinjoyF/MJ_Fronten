package com.min.demo;

import com.min.demo.entities.*;
import com.min.demo.repositories.DocumentRepository;
import com.min.demo.repositories.StylisteRepository;
import com.min.demo.repositories.ModelRepository;
import com.min.demo.web.ModelRestController;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class MinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ModelRepository modelRepository, StylisteRepository stylisteRepository,
							DocumentRepository documentRepository, RepositoryRestConfiguration restConfiguration){

		return args -> {
			restConfiguration.exposeIdsFor(Model.class,Styliste.class);
			stylisteRepository.save(new Styliste(null,"Ornella",null,null,null));
			stylisteRepository.save(new Styliste(null,"Kevine",null,null,null));
		    stylisteRepository.save(new Styliste(null,"Megane",null,null,null));
			Random rnd =new Random();
			stylisteRepository.findAll().forEach(c ->{
				for (int i = 0; i < 15 ; i++) {
					Model m = new Model();
					Document d = new Document();
					m.setName(RandomString.make(18));
					m.setPrix(100 +rnd.nextInt(10000));
					m.setDateProduction(new Date());
					m.setSelected(rnd.nextBoolean());
					m.setPhotoName("photo.png");
					m.setStyliste(c);
					d.setDocName("doc");
					modelRepository.save(m);
					documentRepository.save(d);
				}
			});

			};
		};
	}


