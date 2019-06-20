## Feature Tasks

Ensure that users can’t perform SQL injection or HTML injection with their posts.

Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.

Ensure there is some way (like a users index page) that a user can discover other users on the service.

On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. 

When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.

note: this will require a self-join on ApplicationUsers.

A user can visit a url (like /feed) to view all of the posts from the users that they follow.

Each post should have a link to the user profile of the user who wrote the post.

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