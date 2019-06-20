package com.suadhCodeFellowship.codeFellowship.AppUser;
import com.suadhCodeFellowship.codeFellowship.UserPost;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class AppUser implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String username;
    String password;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String bio;

    @OneToMany(mappedBy = "postWriter")
        List<UserPost> userPostList;

    @ManyToMany(mappedBy = "followees")
    public Set<AppUser> followers;



    //Referenced from reading
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "followers_and_followees_combined",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "followees_id")})
    public Set<AppUser> followees;



    public AppUser() {}

    public AppUser(String username, String password, String firstName, String lastName, Date dateOfBirth, String bio) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }

    public List <UserPost> getUserPostList(){
        return this.userPostList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }


    public String getFirstName() {
        return this.firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getBio() {
        return this.bio;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}