package com.humanbooster.picom.controller.admin;

import com.humanbooster.picom.service.model.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrationController {

    private final UserServiceImpl userService;

    public AdministrationController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/dashboard")
    public ModelAndView getAdminDashBoard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("/admin/dashboard");
        mav.addObject("user", userService.getUserByMail(auth.getName()));
        return mav;
    }
}
