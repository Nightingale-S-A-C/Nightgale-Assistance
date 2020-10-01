package com.nightingale.validators;

import com.nightingale.entity.Product;
import com.nightingale.exceptions.ValidateServiceException;
public class ProductValidator {
    public static void save(Product product) {

        if(product.getName() == null || product.getName().trim().isEmpty()) {
            throw new ValidateServiceException("El nombre es requerido");
        }

        if(product.getName().length() > 100) {
            throw new ValidateServiceException("El nombre es muy largo (max 100)");
        }

        if(product.getDescription() == null || product.getDescription().trim().isEmpty()) {
            throw new ValidateServiceException("La descripcion es requerida");
        }

        if(product.getDescription().length() > 200) {
            throw new ValidateServiceException("La descripcion es muy larga (max 200)");
        }

        if(product.getPrice() == null) {
            throw new ValidateServiceException("El precio es requerido");
        }

        if(product.getPrice() < 0) {
            throw new ValidateServiceException("El precio es incorrecto");
        }
    }
}
