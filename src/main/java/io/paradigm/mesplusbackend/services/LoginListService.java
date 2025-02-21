package io.paradigm.mesplusbackend.services;

import io.paradigm.mesplusbackend.models.LoginParamType;
import io.paradigm.mesplusbackend.repo.LoginList;
import org.springframework.stereotype.Service;

@Service
public class LoginListService {

    private final LoginList loginList;

    public LoginListService(LoginList loginList) {
        this.loginList = loginList;
    }

    public LoginParamType saveLogin(LoginParamType loginParam){
        if(loginParam.getName().isEmpty()){
            throw new IllegalArgumentException("Login name cannot be empty");
        }
        return loginList.save(loginParam);
    }
}
