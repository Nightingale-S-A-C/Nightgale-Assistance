package com.nightingale.entity;


import com.nightingale.utils.enumCategory;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 60)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private enumCategory category;
    // FK modelo producto
    @ManyToOne
    private Model modelo;

    
    // lista de imagenes
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> imageList;


    // Lista de comentarios
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Comment> commentList;

    @Column(name = "stock")
    private Long stock;

    // lista de valores (TO DO tabla atributos)



}
