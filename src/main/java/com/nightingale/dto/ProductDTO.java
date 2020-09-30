package com.nightingale.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    @Length(min = 3, max = 20)
    private String name;
    private Double price;
}
