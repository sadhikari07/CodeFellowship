## Feature Tasks

Your actual feature task: deploy to AWS! Submit the URL of your deployed application. 
(Feel free to also polish look & feel of your app before you deploy.)

[Deployed app](http://codefellowship-dev-cname.us-west-2.elasticbeanstalk.com)
Link: http://codefellowship-dev-cname.us-west-2.elasticbeanstalk.com

## Testing
The following tests were performed to test the functionality of the app:

  contextLoads: EAnsures that context loads
  
  testAppControllerIsAutowired: Ensures that AppController is operational
  
  testCodeControllerIsAutowired: Ensures that CodeFellowshipController is operational


## Instructions on running the app:

On the code: The user can run the tests from codeFellowshipApplicationTest.java to verify the functionality of the app.
The user can run the app from CodeFellowshipAppication to start the server.
 
 On the browser, enter localhost:8080, which will take to the home page.
  From home page, user can login or sign up.
  
  If there is no accounts setup for user yet, they can fill out the information and sign up, whcih will redirect user to their profile page. User can access signup page by entering localhost:8080/signup also.
  
  If account is set up, user can login and go to their profile page, or to access the login page, user can enter localhost:8080/login.
  
  Once logged in, the user can view someone else's profile by entering localhost:8080/user/{name}
  
  The user can see the list of the people they follow and the feed on their profile page.
  
  The user can type localhost:8080/user/allUsers to see poosible followees to see the possible list of people they can follow.
  
  The user can type localhost:8080/feed to go to the recent feed page.
  
  The user can click logout order to logout.



[Link to AppUser.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUser.java)

[Link to App user controller.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/AppUser/AppUserController.java)

[Link to CodeFellowshipController.java](https://github.com/sadhikari07/CodeFellowship/blob/master/src/main/java/com/suadhCodeFellowship/codeFellowship/CodeFellowshipController.java)

[Link to HTML files](https://github.com/sadhikari07/CodeFellowship/tree/master/src/main/resources/templates)



//This assignment was heavily referenced from Michelle's lecture: https://github.com/codefellows/seattle-java-401d4/tree/master/class-16/demo

//Prison Mike: https://theoffice.fandom.com/wiki/Prison_Mike

//CSS reference:  https://envato.com/blog/css-snippets-responsive-menus/
