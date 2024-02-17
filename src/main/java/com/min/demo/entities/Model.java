package com.min.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Model {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer prix;
    @Temporal(TemporalType.DATE)
    private Date dateProduction;
    @Column(length = 20)
    private TypeColor couleur;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TypeModel typeModel;
    private boolean selected;
    private boolean verfuegbar;
    private String photoName;
    @ManyToOne
    private Styliste styliste;
}

