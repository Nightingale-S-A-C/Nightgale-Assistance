package com.nightingale.entity;

import com.nightingale.utils.enumMetodoPago;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reg_date", nullable = false, updatable = false )// fecha
    private LocalDateTime regDate;
    
    @Column(name = "total", nullable = false)
    private Double total;

    @Column(name = "payment",nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private enumMetodoPago metodo;

    @Column(name = "status", nullable = true)
    private Boolean estado;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderLine> lines;

    @ManyToOne
    @JoinColumn(name="user_id", updatable = false)
    private User user;
}
