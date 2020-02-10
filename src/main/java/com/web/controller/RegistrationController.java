package com.web.controller;

import com.persitence.entity.User;
import com.services.UserService;
import com.web.data.AjaxResponse;
import com.web.data.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;
import static com.web.constants.PathConstants.SLASH_REGISTRATION;

@Controller
public class RegistrationController {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    @Resource
    private UserService userService;

    @GetMapping(value = SLASH_REGISTRATION)
    public String getRegistrationPage(){

        return "registration";
    }

    @PostMapping(value = {SLASH_REGISTRATION, "registration"}, consumes = "application/json")
    @ResponseBody
    public AjaxResponse performRegistration(@Valid @RequestBody UserDTO user, Errors errors){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if (errors.hasErrors()){
            ajaxResponse.setMessage("Invalid credential! Please, try again.");
            return ajaxResponse;
        }

        LOG.info("Try to register user : {}, password : {} ", user.getLogin(), user.getPassword());

        Optional<User> optionalUser = userService.findByLogin(user.getLogin());
        if(optionalUser.isPresent()){
            ajaxResponse.setMessage("User is already registered! Please, try again.");
            return ajaxResponse;

        }


        ajaxResponse.setUrl("");
        ajaxResponse.setSuccess(true);
        return ajaxResponse;
    }

    @PostMapping(value = {"/reg", "reg"}, consumes = "application/json")
    public String returnRegPage(){
        return "registration";
    }
}
