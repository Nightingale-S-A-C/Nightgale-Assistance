package com.nightingale.service;


import com.nightingale.entity.Product;
import com.nightingale.exceptions.GeneralServiceException;
import com.nightingale.exceptions.NoDataFoundException;
import com.nightingale.exceptions.ValidateServiceException;
import com.nightingale.repository.ProductRepository;
import com.nightingale.validators.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long productId) {
        try {
            log.debug("findById => " + productId);
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));
            return product;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void delete(Long productId) {
        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));
            productRepository.delete(product);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }

    public List<Product> findAll(){
        try {
            List<Product> products = productRepository.findAll();
            return products;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Product save(Product product) {
        try {
            ProductValidator.save(product);

            if(product.getId() == null) {
                Product newProduct = productRepository.save(product);
                return newProduct;
            }

            Product exitProduct = productRepository.findById(product.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));

            exitProduct.setName(product.getName());
            exitProduct.setPrice(product.getPrice());
            exitProduct.setCategory(product.getCategory());
            exitProduct.setDescription(product.getDescription());
            exitProduct.setStock(product.getStock());

            productRepository.save(exitProduct);

            return exitProduct;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }
}
