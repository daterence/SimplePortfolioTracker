package com.example.simpleportfoliotracker.controllers;

import com.example.simpleportfoliotracker.models.RegistrationModel;
import com.example.simpleportfoliotracker.models.RegistrationMsg;
import com.example.simpleportfoliotracker.services.EmailSenderService;
import com.example.simpleportfoliotracker.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class RegistrationRestController {

    Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;


    // api/register
    @PostMapping("/api/v1/register")
//    public ResponseEntity<String> registerUser(@RequestBody RegistrationModel registrationModel) {
    public RegistrationMsg registerUser(@RequestBody RegistrationModel registrationModel) {
        System.out.println("EMAIL > " + registrationModel.getRegisterEmail());
        String message = userService.registerUser(registrationModel);

        // add email service here¡
        if (Objects.equals(message, "Success!")) {
            String status = emailSenderService.sendEmail(registrationModel.getRegisterEmail(), registrationModel.getRegisterUsername());
            System.out.println(status);
//            return ResponseEntity.ok("successful");
//            String result = gson.toJson("success");
//            return ResponseEntity.ok(result);
            return new RegistrationMsg("successful");
        } else {
//            return ResponseEntity.ok("unsuccessful");
//            String result = gson.toJson("unsuccessful");

            return new RegistrationMsg("unsuccessful");
        }
    }
}
