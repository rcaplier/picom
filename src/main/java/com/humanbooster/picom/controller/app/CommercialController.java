package com.humanbooster.picom.controller.app;

import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import com.humanbooster.picom.service.model.CommercialServiceImpl;
import com.humanbooster.picom.service.model.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommercialController {

    private final UserServiceImpl userService;
    private final CommercialServiceImpl commercialService;

    public CommercialController(UserServiceImpl userService, CommercialServiceImpl commercialService) {
        this.userService = userService;
        this.commercialService = commercialService;
    }

    @GetMapping("/app/annonces")
    public ModelAndView getCommercialsDashBoard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("/app/annonces");
        mav.addObject("user", userService.getUserByMail(auth.getName()));
        Client client = userService.getClientByMail(auth.getName());
        System.out.println();
        System.out.println(client);
        System.out.println();
        List<Commercial> commercials = commercialService.getCommercialsByClient(client);
        System.out.println();
        System.out.println(commercials);
        System.out.println();
        mav.addObject("campagnes", commercials);
        return mav;
    }

}
