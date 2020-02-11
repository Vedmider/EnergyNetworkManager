package com.web.controller;

import com.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdministrationController {
    private static final Logger LOG = LoggerFactory.getLogger(AdministrationController.class);
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
        LOG.info("getting administration page");
        if (session.getAttribute("user") != null) {
            model.addAttribute("networks", networkService.getAll());
            return "administration";
        }
        LOG.warn("There is no user in session. Sending redirect...");
        return "redirect:/";
    }
}
