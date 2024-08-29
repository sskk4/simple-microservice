package com.seba.image.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String fileName;

    @Lob
    @Column(name = "imagedata", length = 10000)
    private byte[] data;

    private Long userId;
}
