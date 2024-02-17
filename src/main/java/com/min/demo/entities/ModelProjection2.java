package com.min.demo.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("*")
@Projection(name = "mobile", types = Model.class)
public interface ModelProjection2 {
    public double getSolde();

    public TypeModel getType();
}
