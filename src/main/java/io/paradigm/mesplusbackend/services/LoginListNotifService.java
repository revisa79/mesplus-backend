package io.paradigm.mesplusbackend.services;

import io.paradigm.mesplusbackend.models.LoginParamType;
import io.paradigm.mesplusbackend.repo.LoginListAndNotif;
import org.springframework.stereotype.Service;

@Service
public class LoginListNotifService {

    private final LoginListAndNotif loginListAndNotif;

    public LoginListNotifService(LoginListAndNotif loginListAndNotif) {
        this.loginListAndNotif = loginListAndNotif;
    }

    public LoginParamType saveLogin(LoginParamType loginParam){
        if(loginParam.getName().isEmpty()){
            throw new IllegalArgumentException("Login name cannot be empty");
        }
        return loginListAndNotif.save(loginParam);
    }
}
