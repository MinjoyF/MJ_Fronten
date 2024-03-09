package com.min.demo.config;

import com.min.demo.entities.Document;
import com.min.demo.entities.Model;
import com.min.demo.entities.Stylist;
import com.min.demo.repositories.DocumentRepository;
import com.min.demo.repositories.ModelRepository;
import com.min.demo.repositories.StylistRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;


@Configuration
public class StylistConfig {

    @Bean
    CommandLineRunner start(ModelRepository modelRepository, StylistRepository stylistRepository,
                            DocumentRepository documentRepository, RepositoryRestConfiguration restConfiguration) {

        return args -> {
            restConfiguration.exposeIdsFor(Model.class, Stylist.class);
            stylistRepository.save(new Stylist(null, "Ornella", null, null, null));
            stylistRepository.save(new Stylist(null, "Kevine", null, null, null));
            stylistRepository.save(new Stylist(null, "Megane", null, null, null));
            Random rnd = new Random();
            stylistRepository.findAll().forEach(c -> {
                for (int i = 0; i < 15; i++) {
                    Model m = new Model();
                    Document d = new Document();
                    m.setName(RandomString.make(18));
                    m.setPrix(100 + rnd.nextInt(10000));
                    m.setDateProduction(new Date());
                    m.setSelected(rnd.nextBoolean());
                    m.setPhotoName("photo.png");
                    m.setStylist(c);
                    d.setDocName("doc");
                    modelRepository.save(m);
                    documentRepository.save(d);
                }
            });

        };
    }
}
