const express = require('express');
const router = express.Router();
const Customer = require('../Models/indexModel')//import mod3l

router.get("/", (req,res)=>{
    res.render("index")
  })




//create a post route to send data to backend
//the action name in the form is the one we use in the post route
router.post('/index', async(req,res)=>{
    try{
        const register = new Customer(req.body);
        await register.save()
        res.redirect('/')//redirect to a path, render a file
        console.log(req.body)
    }
    catch(err){
        console.log(err)
        //res.status(400).render("/")
    }
})

module.exports = router
