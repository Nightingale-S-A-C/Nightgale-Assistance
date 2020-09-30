package com.nightingale.entity;


import lombok.*;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FK user
    @ManyToOne
    private User usuario;

    // FK product
    @ManyToOne
    private Product producto;

    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "rating")
    private Integer puntuacion;
}
