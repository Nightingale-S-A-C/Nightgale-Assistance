package com.nightingale.dto;

import com.nightingale.utils.enumMetodoPago;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String regDate;
    private List<OrderLineDTO> lines;
    private Double total;
    private enumMetodoPago metodo;
    private Boolean estado;
    private UserDTO user;
}
