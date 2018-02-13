Answer 1: .gitignore tells git not to consider the files specified within
          it when doing stuff with Version Control.

Answer 2: Gradle is building the project automatically in its own way, getting
          all the dependencies. build.gradle is specifying the required dependencies
          as well as the build order.

Answer 3: Travis-CI allows us to continuously test new builds, and see where
          things went wrong in the past.

***Answer 4: A _route_ is ....

Answer 5: The `umm3601.Server` class acts as a middle man between 
          the client and the DB. It loads up and stages all the parts 
          necessary for the client to interact with the DB. It directs 
          access to the HTML, defines the DB, creates the controllers.
          
The `umm3601.user.UserController` class directly interacts with the DB 
and builds the array of users.

- They are sent to users.html, the UI for accessing the DB
- They are shown the full list if users, in all its Json glory
- They are shown the list of users whose age tag is valued `25`
- They are shown the user with the id tag valued `588935f5de613130e931ffd5`. 
Valerie Erickson

Answer 6: The `public` folder contains all the HTML, CSS, and 
          JS that is to be used by the client. Each of the 
          HTML files there allow the user to access a different 
          page on the site.

Answer 7: When the age filter button is hit, the JS reads 
          the value of the text box with id "age" and places it 
          in the URL, after "age=". Then the database gets 
          the request containing "age=*value*" and creates an 
          array of users with that value as their age. Finally, 
          the DB sends back the array of users to the JS which 
          passes it to the HTML to display for the user.

Answer 8: The JS is defined in todos.js and users.js .
          The JS is used in todos.html and users.html respectively.
