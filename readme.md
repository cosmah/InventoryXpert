uses express to route and it was installed using `npm install express`
using nodemon to auto restart my server, intsalled using `npm install nodemon`

// //step1;We’re setting a variable express that refers to the Express package and then instantiating it in another variable called app
// const express = require("express");
// const app = express();
// const port = 3000;
// const path = require('path');
// const router = express.Router() ;//use inbuilt routing function to create routes

// /*step3; We’re using Express’s get method to create our route.
//  We specify that when a visitor hits the homepage at the route /,
//   accept both a request and a response which by convention are shortened to req and res.
//    Note that these are positional arguments so you could call them x and y if you want and
//  whichever one was first would represent the request object and the second one the response object.*/

/



#PUG(makes a website dynamic)
*npm install pug
*we use pug to process data instead of html.
*no tags are used.
*acknowlede indentation to catter for tags.
*use dot to create a class e.g <p class="home"></p> is same as p.home 
for a div we a hash(#) instaed of a dot(.)
*a class or id that does not start with anything is recognised as a div.
* p.home#child This is pug   has class home, id child.

*when using parameters, ids, attributes, etc, dont leave whitespaces in between, pug is sensitive to them.
*we use the - symbol to start a line of JavaScript code(buffering code)

MVC
+this is the pattern we build apps with.
+consists of views folder, models, and controller.
+views habours templates, routes act as the linker/contoller.
+node see files as modules.

ASYNC-WAIT
*synchronous means one after another
*asynchronous means can happen simultaneously.
*a function passed as an arg in another function is called a callback.

*******MONGODB********
`npm install mongoose`
-we use mongose for database connection, its a middleware.
-`npm install dotenv` to install environment for managing the application.
-when data is sent from frontend to backend, its not recognised, we install a package called 'body-parser' which gets data from from end and formats it in a way that backend can handle.`npm install body-parser`
-since database doesn't act synchronously, we use 'async-await' such that we can wait for the operation as our applicationnis doing something else.
