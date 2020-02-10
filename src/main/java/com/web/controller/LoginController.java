package com.web.controller;

import com.persitence.entity.User;
import com.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

import static com.web.constants.ContentConstants.REQUEST_ALERT;
import static com.web.constants.ContentConstants.USER;
import static com.web.constants.PathConstants.SLASH_LOGIN;

@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = SLASH_LOGIN)
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = SLASH_LOGIN)
    public String performLogin(@RequestParam Map<String, String> params, HttpSession session, ModelMap modelMap){
        String login = params.get("login");
        String password = params.get("password");
        Optional<User> user = userService.validateUser(login, password);

        if (user.isPresent()) {
            LOG.info("User ID: {} successfully logged in.", user.get().getId());
            session.setAttribute(USER, user.get());
            return "redirect:/";
        }

        modelMap.addAttribute(REQUEST_ALERT, "Wrong login or password. Please try again");
        return SLASH_LOGIN;
    }
}
