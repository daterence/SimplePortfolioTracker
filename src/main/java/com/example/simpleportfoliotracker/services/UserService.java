package com.example.simpleportfoliotracker.services;

import com.example.simpleportfoliotracker.models.RegistrationModel;
import com.example.simpleportfoliotracker.models.entity.User;
import com.example.simpleportfoliotracker.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public String registerUser(RegistrationModel registrationModel) {
        if (!userRepo.findByEmail(registrationModel.getRegisterEmail()).isPresent()
                && !userRepo.findByUsername(registrationModel.getRegisterUsername()).isPresent()) {

            createUser(registrationModel);
            return "Success!";
        }
        return "Email address used";
    }

    public void createUser(RegistrationModel registrationModel) {
        User user = new User(
                registrationModel.getRegisterUsername(),
                registrationModel.getRegisterPassword(),
                registrationModel.getRegisterEmail(),
                "ROLE_USER"
        );
//        user.setEmail(registrationModel.getRegisterEmail());
//        user.setUsername(registrationModel.getRegisterUsername());
//        user.setPassword(registrationModel.getRegisterPassword());
//        user.setRoles("ROLE_USER");
        userRepo.save(user);
    }

}
