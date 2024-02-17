package com.min.demo.repositories;

import com.min.demo.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
//@RepositoryRestResource
public interface ModelRepository extends JpaRepository<Model,Long> {
    @RestResource(path = "/selectedModels")
    public List<Model> findBySelectedIsTrue();
    //@RestResource(path = "/modelsBykeyword")
   // public List<Model> findByNameContains(@Param("cn") String cn);



}
