package com.example.registration.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;

    public String register(RegistrationRequest request){

        boolean isEmailValid = emailValidator.test(request.getEmail());

        if (!isEmailValid){
            throw new IllegalStateException("email not valid");
        }
        return "it works";
    }
}
