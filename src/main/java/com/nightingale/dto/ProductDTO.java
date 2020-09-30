package com.nightingale.dto;

import org.hibernate.validator.constraints.Length;

public class ProductDTO {
    private Long id;
    @Length(min = 3, max = 20)
    private String name;
    private Double price;
}
