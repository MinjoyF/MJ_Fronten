package com.min.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Stylist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String beschreibung;
    @OneToMany(mappedBy = "stylist")
    private Collection<Model> models;
    @OneToMany(mappedBy = "stylist")
    private Collection<Document> documents;
}
