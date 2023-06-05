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


  module.exports = router