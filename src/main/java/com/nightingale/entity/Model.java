package com.nightingale.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "models")
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id",nullable = false)
    private Brand marca;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "models", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productos;
}
