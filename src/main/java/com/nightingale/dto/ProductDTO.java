package com.nightingale.dto;

import com.nightingale.entity.Comment;
import com.nightingale.entity.Image;
import com.nightingale.entity.Model;
import com.nightingale.utils.enumCategory;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    private String description;
    private enumCategory category;
    private Model modelo;
    private Long stock;

}
