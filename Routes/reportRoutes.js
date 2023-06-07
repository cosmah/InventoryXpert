const path = require('path');
const express = require('express');
const router = express.Router();


// sales reports
  router.get("/reports/sales", (req,res)=>{
    const title = 'Sales Reports';
    res.render("reports/sales", {title});
  })
// inventory reports
  router.get("/reports/inventory", (req,res)=>{
    const title = 'Sales Reports';
    res.render("reports/inventory", {title});
  })
// purchases reports
  router.get("/reports/purchases", (req,res)=>{
    const title = 'purchases Reports';
    res.render("reports/purchases", {title});
  })

// balances reports
  router.get("/reports/balances", (req,res)=>{
    const title = 'Sales Reports';
    res.render("reports/balances", {title});
  })


//reports
  router.get("/reports/reports", (req,res)=>{
      res.render('reports/reports');
  })
//return and refund reports
  router.get("/reports/refund", (req,res)=>{
      res.render('reports/refund');
  })
//stock reports
  router.get("/reports/stocks", (req,res)=>{
      res.render('reports/stocks');
  })

//balance details
  router.get("/reports/balance_details", (req,res)=>{
      res.render('reports/balance_details');
  })

//people details
  router.get("/reports/people", (req,res)=>{
      res.render('reports/people');
  })

//customer sales saummary
  router.get("/reports/customers_sales", (req,res)=>{
      res.render('reports/customers_sales');
  })

//customers list
  router.get("/reports/customers", (req,res)=>{
      res.render('reports/customers');
  })

  //payments reports
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