package com.example.registration.registration;

import com.example.registration.appuser.AppUser;
import com.example.registration.appuser.AppUserRole;
import com.example.registration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request){

        boolean isEmailValid = emailValidator.test(request.getEmail());

        if (!isEmailValid){
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
