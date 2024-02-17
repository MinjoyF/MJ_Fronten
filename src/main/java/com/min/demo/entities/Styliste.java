package com.min.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Styliste {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String beschreibung;
    @OneToMany(mappedBy = "styliste")
    private Collection<Model> models;
    @OneToMany(mappedBy = "styliste")
    private Collection<Document> documents;
}
