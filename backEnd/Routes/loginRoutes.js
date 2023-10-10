
const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
const passport = require("passport")
const bcrypt = require('bcrypt');
//imported model
const User = require("../Models/userModel")

router.get("/login",(req,res)=>{
    res.render("login")
  });


// we redirect to a path and render a page


router.post('/login', passport.authenticate('local', { failureRedirect: '/login' }), async (req, res) => {
  try {
    const { email, password } = req.body;

    // Find the user by email
    const user = await User.findOne({ email });

    // Validate the password
    if (!user || !(await bcrypt.compare(password, user.password))) {
      return res.send('Invalid email or password');
    }

    // User authentication successful
    res.redirect('/');
  } catch (error) {
    // Handle any errors that occur during authentication
    console.error(error);
    res.status(500).send('An error occurred during login');
  }
});


module.exports  = router