package com.nightingale.validators;
import com.nightingale.entity.User;
import com.nightingale.exceptions.ValidateServiceException;
public class UserValidator {
    public static void save(User user) {
        if(user.getName() == null || user.getName().trim().isEmpty()){
            throw new ValidateServiceException("El nombres es requerido");
        }

        if(user.getName().length()>20){
            throw new ValidateServiceException("El nombres es muy largo (max 20 caracteres)");
        }

        if(user.getPassword() == null || user.getPassword().trim().isEmpty()){
            throw new ValidateServiceException("La contrasena es requerida");
        }

        if(user.getPassword().length()>20){
            throw new ValidateServiceException("La contrasena es muy larga (max 20 caracteres)");
        }
        if(user.getPassword().length()<7){
            throw new ValidateServiceException("La contrasena es muy corta (max 20 caracteres)");
        }

        if(user.getEmail() == null || user.getEmail().trim().isEmpty()){
            throw new ValidateServiceException("El email es requerido");
        }


    }
}
