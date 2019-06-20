package com.suadhCodeFellowship.codeFellowship;


import com.suadhCodeFellowship.codeFellowship.AppUser.AppUser;
import com.suadhCodeFellowship.codeFellowship.AppUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;




@Controller
public class CodeFellowshipController {

    @Autowired
    AppUserRepository appUserRepository;

     @GetMapping("/user")

        public String getCodeFellowship(Principal p, Model m) {

         isUserLoggedIn(p, m);
         AppUser currentUser = appUserRepository.findByUsername(p.getName());
         m.addAttribute("user", currentUser);

         return "code";
     }


     @GetMapping("/")
    public String getHome(Principal p, Model m) {
         isUserLoggedIn(p, m);
         return "home";
    }


    public void isUserLoggedIn(Principal p, Model m){
        if(p!=null){
            m.addAttribute("loggedInName", p.getName());
        }
        else {
            m.addAttribute("loggedInName", false);
        }
    }

}


