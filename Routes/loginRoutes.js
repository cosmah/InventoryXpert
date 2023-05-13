
const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
const passport = require("passport")
//imported model
const User = require("../Models/userModel")

router.get("/login",(req,res)=>{
    res.render("login")
  });


// we redirect to a path and render a page
router.post("/login", passport.authenticate("local", {failureRedirect: "/login"}), async(req,res)=>{
    req.session.user = req.user 
    let userExist = await User.findOne({email: req.user.email,password: req.user.password});
    console.log("this user exists", userExist)
    console.log("this is the user session:", req.session)
    // res.redirect("/students")
    if(req.user.email == userExist){
      res.redirect("/employees")
    }else{
      res.send("you are not registered")}

        })

router.post("/Routes", (req,res)=>{
  if(req.session){
    req.session.destroy((error)=>{
      if (error){
      res.status(400).send("unable to logout user")
    }else{
      return res.redirect("/login")
    }
  })
}
})


module.exports  = router