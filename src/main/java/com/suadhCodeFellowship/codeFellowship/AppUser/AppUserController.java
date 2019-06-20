package com.suadhCodeFellowship.codeFellowship.AppUser;
import com.suadhCodeFellowship.codeFellowship.UserPost;
import com.suadhCodeFellowship.codeFellowship.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    UserPostRepository userPostRepository;

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
    public String getThatUser(@PathVariable String username, Model m, Principal p) {
        isUserLoggedIn(p, m);
        AppUser a = appUserRepository.findByUsername(username);
        m.addAttribute("userInfo", a);
        return "userProfile";
    }

    @GetMapping("/logout")
    public String logoutUser(){
        return "/logout";
    }

    @GetMapping("/post")

    public String getsUserPost(Principal p, Model m){
        isUserLoggedIn(p, m);
        return "createUserPost";
    }

    @PostMapping("/createUserPost")
    public RedirectView addPost(String post, Principal p, Model m) {

        isUserLoggedIn(p, m);

        // getting the user from the DB
        AppUser writer = appUserRepository.findByUsername(p.getName());

        Calendar calendar = Calendar.getInstance();
        Timestamp createdAt = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        // creating a new post, and assigning the post a user
        UserPost newUserPost = new UserPost(post, writer, createdAt);

        // saving the new post (with the user assigned to it) to the DB
        userPostRepository.save(newUserPost);

        return new RedirectView("/user");
    }

    @GetMapping("/userPost/{id}")
    public String showUserPost(@PathVariable long id, Model m, Principal p) {

        isUserLoggedIn(p, m);

        UserPost userPost = userPostRepository.findById(id).get();
        if (userPost.getPostWriter().username.equals(p.getName())) {
            // if so, do the nice things
            m.addAttribute("userPost", userPost);
            return "onePost";
        } else {
            // otherwise, tell them no
            throw new NotYourPostException("Nice try Toby, but you didn't write that post.");
        }
    }


    @GetMapping("/user/allusers")
    public String getAllUsers(Model m, Principal p) {
        isUserLoggedIn(p, m);
        AppUser loggedInUser = appUserRepository.findByUsername(p.getName());
        List<AppUser> possibleFollowees = (List)appUserRepository.findAll();
        possibleFollowees.removeAll(loggedInUser.followees);
        m.addAttribute("userInfo", possibleFollowees);
        return "possibleToFollow";
    }





    @PostMapping("/user/follow")
        public RedirectView follow(long follow, Model m, Principal p){
        isUserLoggedIn(p, m);
        AppUser currentUser = appUserRepository.findByUsername(p.getName());
        currentUser.followees.add(appUserRepository.findById(follow).get());
        appUserRepository.save(currentUser);
        return new RedirectView("/user");
    }


    @GetMapping("/feed")
    public String getAllFeed(Model m, Principal p) {
        isUserLoggedIn(p, m);
        AppUser loggedInUser = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", loggedInUser);
        return "feed";
    }


    //https://stackoverflow.com/questions/2066946/trigger-404-in-spring-mvc-controller
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    class NotYourPostException extends RuntimeException {
        public NotYourPostException(String s) {
            super(s);
        }
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


