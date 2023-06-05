const path = require('path');
const express = require('express');
const router = express.Router();

//   router.get("/", (req,res)=>{
//     const title = 'Home';
//     res.render("index", {title});
//   })


//reports
  router.get("/reports/reports", (req,res)=>{
      res.render('reports/reports');
  })

//balance details
  router.get("/reports/balance_details", (req,res)=>{
      res.render('reports/balance_details');
  })

//customer sales saummary
  router.get("/reports/customers_sales", (req,res)=>{
      res.render('reports/customers_sales');
  })

//customers list
  router.get("/reports/customers", (req,res)=>{
      res.render('reports/customers');
  })

  //payments recieved
  router.get("/reports/payments", (req,res)=>{
      res.render('reports/payments');
  })

  //employees list
  router.get("/reports/employeeList", (req,res)=>{
      res.render('reports/employeeList');
  })

  //profits and losses 
  router.get("/reports/profit_and_loss", (req,res)=>{
      res.render('reports/profit_and_loss');
  })

  //sales details
  router.get("/reports/salesDetails", (req,res)=>{
      res.render('reports/salesDetails');
  })


  module.exports = router