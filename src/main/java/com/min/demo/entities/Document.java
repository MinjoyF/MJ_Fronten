package com.min.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Document {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String docName;

        @Column
        @Lob
        private byte[] file;

        @ManyToOne
        @JoinColumn(name = "stylist_id")
        private Stylist stylist;

}