package com.min.demo.web;

import com.min.demo.entities.Model;
import com.min.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/couture")
public class ModelJaxRSAPI {
    @Autowired
    private ModelRepository modelRepository;

    @Path("/model")
    @GET
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON, javax.ws.rs.core.MediaType.APPLICATION_XML})
    public List<Model> modelListList() {
        return modelRepository.findAll();
    }

    @Path("/model/{id}")
    @GET
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Model getOne(@PathParam(value = "id") Long id) {
        return modelRepository.findById(id).get();
    }

    @Path("/model")
    @POST
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Path("/model")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Model update(Model model, @PathParam("id") Long id) {
        model.setId(id);
        return modelRepository.save(model);
    }
}
