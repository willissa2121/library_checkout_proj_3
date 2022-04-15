package library.wslibrarycheckout.library.controller;


import io.swagger.annotations.ApiOperation;
import library.wslibrarycheckout.library.entity.Book;
import library.wslibrarycheckout.library.entity.Registration;
import library.wslibrarycheckout.library.model.LogInDTO;
import library.wslibrarycheckout.library.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    @ApiOperation(value = "Register user")
    public ResponseEntity<Object> registerUser(@RequestBody @Valid Registration registration){

        return  registrationService.register(registration);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Log in user api")
    public ResponseEntity<Object> getRegisteredUser(@RequestBody  LogInDTO logInDTO){

        return  registrationService.login(logInDTO);
    }
}
