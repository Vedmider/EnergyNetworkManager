package com.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

import static com.web.constants.PathConstants.SLASH_LOGOUT;

@Controller
public class LogOutController {
    private static final Logger LOG = LoggerFactory.getLogger(LogOutController.class);
    @GetMapping(value = SLASH_LOGOUT)
    public String performLogout(HttpSession session){
        LOG.info("User with session ID {} log out.", session.getId());
        session.invalidate();
        LOG.debug("Sending redirect after logout");
        return "redirect:/";
    }
}
