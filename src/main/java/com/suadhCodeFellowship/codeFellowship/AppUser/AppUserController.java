package com.suadhCodeFellowship.codeFellowship.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = "/login")
    public RedirectView loginUsers(@RequestParam String username, String password) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/user");
    }


    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }


    @PostMapping(value = "/signup")
    public RedirectView signUpUsers(@RequestParam String username, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        AppUser newAppUser = new AppUser(username, passwordEncoder.encode(password), firstName, lastName, dateOfBirth, bio);

        appUserRepository.save(newAppUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newAppUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/user");

    }

    @GetMapping("/user/{username}")
    public String getThatUser(@PathVariable String username, Model m) {
        AppUser a = appUserRepository.findByUsername(username);
        m.addAttribute("userInfo", a);
        return "userProfile";
    }
}


