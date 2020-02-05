package com.web.controller;

import com.persitence.entity.User;
import com.services.UserService;
import com.web.data.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @PostMapping(value = SLASH_REGISTRATION)
    @ResponseBody
    public AjaxResponse performRegistration(@Valid @RequestBody User user, Errors errors){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if (errors.hasErrors()){
            ajaxResponse.setMessage("Invalid credential! Please, try again.");
            return ajaxResponse;
        }

        LOG.info("Try to login : {}, password : {} ", user.getLogin(), user.getPassword());

        Optional<User> optionalUser = userService.validateUser(user.getLogin() , user.getPassword());
        if(optionalUser.isPresent()){
            ajaxResponse.setUrl("");
            ajaxResponse.setSuccess(true);
            return ajaxResponse;
        }

        ajaxResponse.setMessage("Invalid credential! Please, try again.");
        return ajaxResponse;
    }
}
