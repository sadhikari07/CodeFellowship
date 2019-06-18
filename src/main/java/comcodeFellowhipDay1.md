## Overview
For your remaining labs before the midterm project, you’ll create an app called CodeFellowship that allows people learning to code to connect with each other and support each other on their coding journeys.

## Feature Tasks
Build an app that allows users to create their profile on CodeFellowship.

The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.

An ApplicationUser should have a username, password ( hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.

The site should allow users to create an ApplicationUser on the “sign up” page.

Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.

The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.

This should include a default profile picture, which is the same for every user, and their basic information.

Using the above cheat sheet, add the ability for users to log in to your app.

Upon logging in, users should be taken to a /myprofile route that displays their information.

Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.

Ensure that user registration also logs users into your app automatically.

The site should be reasonably styled. (This can be using CSS that you did not create yourself.)

The site should contain integration testing. At a minimum, there should be tests to ensure basic functionality for the splash page and the sign up page.

## Testing
The following tests were performed to test the functionality of the app:

  contextLoads: EAnsures that context loads
  
  testAppControllerIsAutowired: Ensures that AppController is operational
  
  testCodeControllerIsAutowired: Ensures that CodeFellowshipController is operational


## Instructions on running the app:
  On the browser, enter localhost:8080, which will take to the home page.
  From home page, user can login or sign up.
  
  If there is no accounts setup for user yet, they can fill out the information and sign up, whcih will redirect user to their profile page. User can access signup page by entering localhost:8080/signup also.
  
  If account is set up, user can login and go to their profile page, or to access the login page, user can enter localhost:8080/login.
  
  Once logged in, the user can view someone else's profile by entering localhost:8080/user/{name}
  
  The user has to enter localhost:8080/logout in order to logout.



[Link to AppUser.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUser.java)

[Link to App user controller.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUserController.java)

[Link to CodeFellowshipController.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/CodeFellowshipController.java)

[Link to HTML files](https://github.com/sadhikari07/CodeFellowship/tree/master/src/main/resources/templates)



//This assignment was heavily referenced from Michelle's lecture: https://github.com/codefellows/seattle-java-401d4/tree/master/class-16/demo

//Prison Mike: https://theoffice.fandom.com/wiki/Prison_Mike
