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

//   //---SALES REPORTS----//

//   //sales summary
//   router.get("/reports/sales/sales_by_customer_summary", (req,res)=>{
//       res.render('reports/sales/sales_by_customer_summary');
//   })

//   //sales details
//   router.get("/reports/sales/sales_by_customer_details", (req,res)=>{
//       res.render('reports/sales/sales_by_customer_details');
//   })

//   //sales product
//   router.get("/reports/sales/sales_by_product", (req,res)=>{
//       res.render('reports/sales/sales_by_product');
//   })

//   //sales product
//   router.get("/reports/sales/sales_by_sales_rep", (req,res)=>{
//       res.render('reports/sales/sales_by_sales_rep');
//   })
// //-----END-----//

  //---BALANCE REPORTS----//

  //balance details
  router.get("/reports/balances/balance_details", (req,res)=>{
      res.render('reports/balances/balance_details');
  })

  //balance sheet
  router.get("/reports/balances/balance_sheet", (req,res)=>{
      res.render('reports/balances/balance_sheet');
  })

  //balance summary
  router.get("/reports/balances/balance_summary", (req,res)=>{
      res.render('reports/balances/balance_summary');
  })

  // //sales product
  // router.get("/reports/sales/sales_by_sales_rep", (req,res)=>{
  //     res.render('reports/sales/sales_by_sales_rep');
  // })
//-----END-----//

  //---PAYMENTS REPORTS----//

  //inventory summary
  // router.get("/reports/inventory/inventory_summary", (req,res)=>{
  //     res.render('reports/inventory/inventory_summary');
  // })
 //invemtory valuation
  router.get("/reports/inventory/inventory_valuation", (req,res)=>{
      res.render('reports/inventory/inventory_valuation');
  })

  //payment by rep
  router.get("/reports/inventory/out_of_stock", (req,res)=>{
      res.render('reports/inventory/out_of_stock');
  })

  //purchase history
  router.get("/reports/inventory/purchase_history", (req,res)=>{
      res.render('reports/inventory/purchase_history');
  })

  //refund analysis
  router.get("/reports/inventory/return_refund_analysis", (req,res)=>{
      res.render('reports/inventory/return_refund_analysis');
  })

  //---PAYMENTS REPORTS----//

  //payment by date
  router.get("/reports/payments/payment_by_date", (req,res)=>{
      res.render('reports/payments/payment_by_date');
  })
 //payment by customer
  router.get("/reports/payments/payments_by_customer", (req,res)=>{
      res.render('reports/payments/payments_by_customer');
  })

  //payment by rep
  router.get("/reports/payments/payment_by_rep", (req,res)=>{
      res.render('reports/payments/payment_by_rep');
  })

  // //sales product
  // router.get("/reports/sales/sales_by_sales_rep", (req,res)=>{
  //     res.render('reports/sales/sales_by_sales_rep');
  // })
//-----END-----//

  module.exports = router