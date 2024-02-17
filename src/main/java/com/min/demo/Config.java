package com.min.demo;

import com.min.demo.web.ModelJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
   // @Bean
    public ResourceConfig resourceConfig(){
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(ModelJaxRSAPI.class);
        return jerseyServlet;
    }
}
