package com.min.demo.repositories;

import com.min.demo.entities.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
//@RepositoryRestResource
public interface StylistRepository extends JpaRepository<Stylist,Long> {
}
