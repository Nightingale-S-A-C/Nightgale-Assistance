package com.nightingale.service;

import com.nightingale.converters.UserConverter;
import com.nightingale.dto.LoginRequestDTO;
import com.nightingale.dto.LoginResponseDTO;
import com.nightingale.entity.User;
import com.nightingale.exceptions.GeneralServiceException;
import com.nightingale.exceptions.NoDataFoundException;
import com.nightingale.exceptions.ValidateServiceException;
import com.nightingale.repository.UserRepository;
import com.nightingale.validators.UserValidator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {

    @Value("myScretKey")
    private String jwtSecret;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Transactional
    public User createUser(User user) {
        try {
            UserValidator.validate(user);
            User existUser=userRepository.findByName(user.getName())
                    .orElse(null);
            if(existUser!=null)
                throw new ValidateServiceException("El nombre usuario ya existe");
            return userRepository.save(user);
        } catch (ValidateServiceException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public LoginResponseDTO login(LoginRequestDTO request){
        try {
            User user=userRepository.findByName(request.getName())
                    .orElseThrow(()->new ValidateServiceException("Usuario o password incorrecto"));

            if(!user.getPassword().equals(request.getPassword()))
                throw new ValidateServiceException("Usuario o password incorrectos");

            String token =createToken(user);

            return new LoginResponseDTO(userConverter.fromEntity(user),token);

        } catch (ValidateServiceException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public String createToken(User user){
        Date now =new Date();
        Date expiryDate=new Date(now.getTime()+ (1000*60*60));

        return Jwts.builder()
                .setSubject(user.getName())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
    }



}
