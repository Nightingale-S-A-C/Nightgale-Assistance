package com.nightingale.validators;
import com.nightingale.entity.Order;
import com.nightingale.entity.Product;
import com.nightingale.exceptions.ValidateServiceException;
public class OrderValidator {
    public static void save(Order order) {

        if(order.getProductList()==null || order.getProductList().isEmpty()){
            throw new ValidateServiceException("La lista de productos es requerida");
        }

        for(Product productsList: order.getProductList()) {
            if(productsList.getId() == null) {
                throw new ValidateServiceException("El producto es requerido");
            }
            if(productsList.getPrice() == null){
                throw new ValidateServiceException("El precio es requerido");
            }
            if(productsList.getPrice() < 0) {
                throw new ValidateServiceException("El precio es incorrecto");
            }

            if(productsList.getStock() == null){
                throw new ValidateServiceException("La cantidad es requerido");
            }
            if(productsList.getStock() < 0) {
                throw new ValidateServiceException("La cantidad es incorrecto");
            }
        }



    }
}
