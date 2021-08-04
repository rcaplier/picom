package com.humanbooster.picom.controller;

import com.humanbooster.picom.exception.EmailExistsException;
import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.service.model.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping({"/public/newusercreation"})
    public ModelAndView newUserCreationPost(@RequestParam("firstname") String firstName,
                                            @RequestParam("lastname") String lastName,
                                            @RequestParam("email") String email,
                                            @RequestParam("password") String password,
                                            @RequestParam("phonenumber") String phoneNumber) throws EmailExistsException {
        Client client = new Client(firstName, lastName, email, password, phoneNumber, true);
        if (userService.emailAlreadyExist(email)){
            return new ModelAndView("redirect:/registration?emailalreadyexist=1");
        }
        else{
            userService.registerNewClientAccount(client);
            return new ModelAndView("redirect:/index?accountsuccesfullycreated=1");
        }
    }
}
