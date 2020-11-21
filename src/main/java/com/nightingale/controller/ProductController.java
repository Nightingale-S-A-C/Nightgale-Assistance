package com.nightingale.controller;

import com.nightingale.converters.ProductConverter;
import com.nightingale.dto.ProductDTO;
import com.nightingale.entity.Product;
import com.nightingale.service.ProductService;
import com.nightingale.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductConverter converter;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("productId") Long productId) {
        Product product = productService.findById(productId);
        ProductDTO productDTO = converter.fromEntity(product);
        return new WrapperResponse(true, "success", productDTO).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> delete(@PathVariable("productId") Long productId) {
        productService.delete(productId);
        return new WrapperResponse(true, "success", null)
                .createResponse(HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<Product> products = productService.findAll();
        List<ProductDTO> dtoProducts = converter.fromEntity(products);

        return new WrapperResponse(true, "success", dtoProducts)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
        Product newProduct = productService.save(converter.fromDTO(product));
        ProductDTO productDTO = converter.fromEntity(newProduct);

        return new WrapperResponse(true, "success", productDTO)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product) {
        Product updateProduct = productService.save(converter.fromDTO(product));
        ProductDTO productDTO = converter.fromEntity(updateProduct);

        return new WrapperResponse(true, "success", productDTO)
                .createResponse(HttpStatus.OK);
    }
}