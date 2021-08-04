package com.humanbooster.picom.controller;

import com.humanbooster.picom.exception.EmailExistsException;
import com.humanbooster.picom.model.*;
import com.humanbooster.picom.service.model.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApplicationController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final CommercialServiceImpl commercialService;
    private final TimeSlotServiceImpl timeSlotService;
    private final AreaServiceImpl areaService;
    private final StopServiceImpl stopService;
    private final TariffServiceImpl tariffService;

    public ApplicationController(UserServiceImpl userService, RoleServiceImpl roleService, CommercialServiceImpl commercialService, TimeSlotServiceImpl timeSlotService, AreaServiceImpl areaService, StopServiceImpl stopService, TariffServiceImpl tariffService) {
        this.userService = userService;
        this.roleService = roleService;
        this.commercialService = commercialService;
        this.timeSlotService = timeSlotService;
        this.areaService = areaService;
        this.stopService = stopService;
        this.tariffService = tariffService;
    }

    //Définition de la vue de la page d'accueuil qui est aussi la page de login de l'application
    @GetMapping({"/", "index"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping({"/public/access-denied"})
    public ModelAndView accessDenied() {
        System.out.println("Page acces refusé!!!");
        ModelAndView mav = new ModelAndView("/public/access-denied");
        return mav;
    }

    @GetMapping("/public/registration")
    public ModelAndView registration() {
        ModelAndView mav = new ModelAndView("/public/registration");
        return mav;
    }

/*    @GetMapping("/error")
    public ModelAndView erreur(){
        ModelAndView mav = new ModelAndView("/public/error");
        return mav;
    }*/

    @PostMapping("/logout")
    public ModelAndView logout() {
        return new ModelAndView("redirect:/");
    }

    @GetMapping({"/successauth"})
    public ModelAndView successfullAuthManager() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : auth.getAuthorities()) {
            if (authority.toString().equals("administrator")) {
                return new ModelAndView("redirect:/admin/dashboard");
            } else if (authority.toString().equals("client")) {
                return new ModelAndView("redirect:/app/annonces");
            } else {
                return new ModelAndView("redirect:/error?notvaliduser");
            }
        }
        return new ModelAndView("redirect:/error?userhasnorights");
    }

    @PostConstruct
    public void init() throws EmailExistsException {
        if (roleService.getRoles().isEmpty()) {
            roleService.saveRole(new Role("administrator"));
            roleService.saveRole(new Role("client"));
        }
        if (userService.getAdministrators().isEmpty()) {
            userService.registerNewAdministratorAccount(new Administrator("Administrateur", "Administrateur", "admin@root.com", "administrateur", true));
            userService.registerNewAdministratorAccount(new Administrator("Romuald", "Caplier", "a@a.com", "aaaaaaaa", true));
        }
        if (userService.getClients().isEmpty()) {
            userService.registerNewClientAccount(new Client("John", "Doe", "johndoe@hotmail.com", "password", "06.06.06.06.06", true));
            userService.registerNewClientAccount(new Client("Jane", "Birkin", "janebirkin@yahoo.com", "password", "06.06.06.06.06", true));
            userService.registerNewClientAccount(new Client("John", "Doe", "b@b.com", "bbbbbbbb", "06.06.06.06.06", true));
        }

        if (timeSlotService.getTimeSlots().isEmpty()){
            timeSlotService.saveTimeSlot(new TimeSlot(0,1));
            timeSlotService.saveTimeSlot(new TimeSlot(1,2));
            timeSlotService.saveTimeSlot(new TimeSlot(2,2));
            timeSlotService.saveTimeSlot(new TimeSlot(3,4));
            timeSlotService.saveTimeSlot(new TimeSlot(4,5));
            timeSlotService.saveTimeSlot(new TimeSlot(5,6));
            timeSlotService.saveTimeSlot(new TimeSlot(6,7));
            timeSlotService.saveTimeSlot(new TimeSlot(7,8));
            timeSlotService.saveTimeSlot(new TimeSlot(8,9));
            timeSlotService.saveTimeSlot(new TimeSlot(9,10));
            timeSlotService.saveTimeSlot(new TimeSlot(10,11));
            timeSlotService.saveTimeSlot(new TimeSlot(11,12));
            timeSlotService.saveTimeSlot(new TimeSlot(12,13));
            timeSlotService.saveTimeSlot(new TimeSlot(13,14));
            timeSlotService.saveTimeSlot(new TimeSlot(14,15));
            timeSlotService.saveTimeSlot(new TimeSlot(15,16));
            timeSlotService.saveTimeSlot(new TimeSlot(16,17));
            timeSlotService.saveTimeSlot(new TimeSlot(17,18));
            timeSlotService.saveTimeSlot(new TimeSlot(18,19));
            timeSlotService.saveTimeSlot(new TimeSlot(19,20));
            timeSlotService.saveTimeSlot(new TimeSlot(20,21));
            timeSlotService.saveTimeSlot(new TimeSlot(21,22));
            timeSlotService.saveTimeSlot(new TimeSlot(22,23));
            timeSlotService.saveTimeSlot(new TimeSlot(23,0));
        }

        if (areaService.getAreas().isEmpty()){
            areaService.saveArea(new Area("Hyper-centre"));
        }

        if (stopService.getStops().isEmpty()){
            stopService.saveStop(new Stop("Salins", areaService.getAreaByName("Hyper-centre")));
            stopService.saveStop(new Stop("Place de jaude", areaService.getAreaByName("Hyper-centre")));
        }

        if (tariffService.getTariffs().isEmpty()){
            List<TimeSlot> timeSlots = timeSlotService.getTimeSlots();
            for (TimeSlot timeSlot : timeSlots) {
                Double randomPrice = Math.random() * 100;
                tariffService.saveTariff(new Tariff(randomPrice,areaService.getAreaByName("Hyper-centre"), timeSlot));
            }
        }

        if (commercialService.getCommercials().isEmpty()){
            List<Area> areas = new ArrayList<>();
            areas.add(areaService.getAreaByName("Hyper-centre"));
            commercialService.saveHTMLCommercial(new HTMLCommercial("Promo IKEA Août",LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),userService.getClientByMail("b@b.com"),areas,"test"));
        }

    }

}
