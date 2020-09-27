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

    // FK product

    @Column(name = "description")
    private String description;
    @Column(name = "puntuacion")
    private Integer puntuacion;
}
