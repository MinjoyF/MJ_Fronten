package com.min.demo.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("*")
@Projection(name ="solde",types = Model.class)
public interface ModelProjection1 {
    public double getSolde();

}

