package com.suadhCodeFellowship.codeFellowship;


import com.suadhCodeFellowship.codeFellowship.AppUser.AppUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@Controller
public class CodeFellowshipController {

     @GetMapping("/user")

        public String getCodeFellowship(Principal p, Model m) {
         AppUser currentUser = (AppUser) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
         System.out.println(p.getName());
         m.addAttribute("principal", p);
         m.addAttribute("user", currentUser);
         return "code";
     }


     @GetMapping("/")
    public String getHome() {
        return "home";
    }
}


