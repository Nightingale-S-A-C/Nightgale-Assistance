package com.nightingale.entity;


import com.nightingale.utils.enumRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private enumRole role;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> ordenes;
}
