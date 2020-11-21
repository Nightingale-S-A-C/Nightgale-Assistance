package com.nightingale.dto;

import com.nightingale.utils.enumCategory;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private enumCategory category;
    private Long stock;

}
