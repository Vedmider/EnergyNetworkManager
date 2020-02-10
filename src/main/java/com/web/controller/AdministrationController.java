package com.web.controller;

import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdministrationController {
    private NetworkService networkService;
    private SubstationService substationService;
    private TransformerService transformerService;
    private FeederService feederService;
    private ResourceService resourceService;


    @Autowired
    public AdministrationController(NetworkService networkService,
                                    SubstationService substationService,
                                    TransformerService transformerService,
                                    FeederService feederService,
                                    ResourceService resourceService) {
        this.networkService = networkService;
        this.substationService = substationService;
        this.transformerService = transformerService;
        this.feederService = feederService;
        this.resourceService = resourceService;
    }

    @GetMapping(value = {"/administration"})
    public String getAdministrationPage(ModelMap model, HttpSession session) {

        if (session.getAttribute("user") != null) {
            model.addAttribute("networks", networkService.getAll());
            return "administration";
        }
        return "redirect:/";
    }
}
