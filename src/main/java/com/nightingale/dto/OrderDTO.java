package com.nightingale.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderDTO {
    private Long id;
    private String regDate;
    private List<ProductDTO> productDTOList;
    private Double total;
}
