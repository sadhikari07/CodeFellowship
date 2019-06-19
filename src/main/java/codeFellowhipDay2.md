## Overview
Today, you’ll add login to the CodeFellowship app, and allow users to create posts.

## Feature Tasks
Allow users to log in to CodeFellowship and create posts.

Using the above cheat sheet, add the ability for users to log in to your app.

Upon logging in, users should be taken to a /myprofile route that displays their information.

Ensure that your homepage, login, and registration routes are accessible to non-logged in users. 
All other routes should be limited to logged-in users.

Ensure that user registration also logs users into your app automatically.

Add a Post entity to your app.

A Post has a body and a createdAt timestamp.

A logged-in user should be able to create a Post, and a post should belong to the user that created it.
hint: this is a relationship between two pieces of data

A user’s posts should be visible on their profile page.

When a user is logged in, the app should display the user’s username on every page (probably in the heading).

## Testing
The following tests were performed to test the functionality of the app:

  contextLoads: EAnsures that context loads
  
  testAppControllerIsAutowired: Ensures that AppController is operational
  
  testCodeControllerIsAutowired: Ensures that CodeFellowshipController is operational
  
  testRequestToRootGivesWelcome: Ensure that "/" route is functional
  
  testRequestToSignUpGivesSignUP: Ensures that "/signup" route is functional


## Instructions on running the app:
  On the browser, enter localhost:8080, which will take to the home page.
  
  From home page, user can login or sign up.
  
  If there is no accounts setup for user yet, they can fill out the information and sign up, whcih will redirect user to their profile page. User can access signup page by entering localhost:8080/signup also.
  
  If account is set up, user can login and go to their profile page, or to access the login page, user can enter localhost:8080/login, or click the login link.
  
  Once logged in, the user can view someone else's profile by entering localhost:8080/user/{name}.
  
  While logged in, user can click create new post to create a new post which will show up in user's profile only when same user is looking at their own profile.
  
  If the user is logged in, they can click logout in order to logout.
  
  At any point, if error occurs, user is redirected to an error page with information about the error.
  
 
[Link to AppUser.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUser.java)

[Link to App user controller.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUserController.java)

[Link to CodeFellowshipController.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/CodeFellowshipController.java)

[Link to createPost.java]()

[Link to HTML files](https://github.com/sadhikari07/CodeFellowship/tree/master/src/main/resources/templates)



//This assignment was heavily referenced from Michelle's lecture: https://github.com/codefellows/seattle-java-401d4/tree/master/class-16/demo

//Prison Mike: https://theoffice.fandom.com/wiki/Prison_Mike
