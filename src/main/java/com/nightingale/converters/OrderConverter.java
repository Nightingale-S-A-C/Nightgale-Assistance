package com.nightingale.converters;


import com.nightingale.dto.OrderDTO;
import com.nightingale.dto.ProductDTO;
import com.nightingale.entity.Order;
import com.nightingale.entity.Product;
import lombok.AllArgsConstructor;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderConverter extends AbstractConverter<Order, OrderDTO> {

    private DateTimeFormatter formatoTiempo;
    private ProductConverter productConverter;

    //De entity a DTO
    @Override
    public OrderDTO fromEntity(Order entity) {
        if (entity == null)
            return null;

        List<ProductDTO> products = fromOrderProductsEntity(entity.getProductList());

        return OrderDTO.builder()
                .id(entity.getId())
                .regDate(entity.getRegDate().format(formatoTiempo))
                .productDTOList(products)
                .total(entity.getTotal())
                .build();
    }

    private List<ProductDTO> fromOrderProductsEntity(List<Product> productos) {
        if(productos == null) return null;

        return productos.stream().map(producto -> {
            return ProductDTO.builder()
                    .id(producto.getId())
                    .name(producto.getName())
                    .price(producto.getPrice())
                    .build();
        })
                .collect(Collectors.toList());
    }

    //De DTO a Entity
    @Override
    public Order fromDTO(OrderDTO dto) {
        if (dto == null) return null;

        List<Product> products = fromProductDTO(dto.getProductDTOList());

        return Order.builder()
                .id(dto.getId())
                .regDate(LocalDateTime.parse(dto.getRegDate()))
                .total(dto.getTotal())
                .build();
    }

    private List<Product> fromProductDTO(List<ProductDTO> productos) {
        if(productos == null) return null;

        return productos.stream().map(producto -> {
            return Product.builder()
                    .id(producto.getId())
                    .name(producto.getName())
                    .price(producto.getPrice())
                    .build();
        })
                .collect(Collectors.toList());
    }
}
