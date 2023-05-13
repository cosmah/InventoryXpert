const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
//imported model
const User = require("../Models/userModel")

//genral call
router.get("/signup",(req,res)=>{
    res.render("signup")
  });



router.post("/signup" ,async(req,res)=>{
  console.log(req.body)
  try{
    const user = new User(req.body);
    let userName = await User.findOne({username: req.body.username})
    if(userName){
      return res.send("this unique id already exists") 
    }
    else{
      await User.register(user,req.body.password,(error)=>{
        if(error){
          throw error
        }
        res.redirect("/login")
      })
    }

  }
catch(error){
  res.status(400).send("sorry it seems there is trouble accesing this page")
  console.log(error)
}
})




  module.exports=router