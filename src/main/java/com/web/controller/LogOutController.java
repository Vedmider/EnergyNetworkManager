package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import static com.web.constants.PathConstants.SLASH_LOGOUT;

@Controller
public class LogOutController {

    @GetMapping(value = SLASH_LOGOUT)
    public String performLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
