const path = require('path');
const express = require('express');
const router = express.Router();

  router.get("/", (req,res)=>{
    const title = 'Home';
    res.render("index", {title});
  })

//dashboard
  router.get("/welcome", (req,res)=>{
      res.render('welcome');
  })

  router.get("/layout", (req,res)=>{
      res.render('layout');
  })


  module.exports = router