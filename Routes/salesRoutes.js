// routes/purchase.js
const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
const Receipt = require('../Models/recieptModel');

  //---SALES REPORTS----//

//   //sales summary
//   router.get("/reports/sales/sales_by_customer_summary", (req,res)=>{
//     res.render('reports/sales/sales_by_customer_summary');
// })

// //sales details
// router.get("/reports/sales/sales_by_customer_details", (req,res)=>{
//     res.render('reports/sales/sales_by_customer_details');
// })

// //sales product
// router.get("/reports/sales/sales_by_product", (req,res)=>{
//     res.render('reports/sales/sales_by_product');
// })

// //sales product
// router.get("/reports/sales/sales_by_sales_rep", (req,res)=>{
//     res.render('reports/sales/sales_by_sales_rep');
// })
// //-----END-----//

// // POST route to add a new purchase
// router.post('/report/purchases/purchases', async (req, res) => {
//   try{
//     const purchase = new Purchase(req.body);
//     await purchase.save()
//     res.redirect("/reportS/purchases/purchases");
//     console.log(req.body);
//   }
//   catch(error){
//     res.status(400).send("Failed to add purchase, Please try again");
//     console.log(error);
//   }
// });



//SALES DETAILS
router.get("/reports/sales/sales_by_customer_details", async (req, res) => {
  try {
    const receipts = await Receipt.find(); // Fetch purchases from MongoDB
    res.render("reports/sales/sales_by_customer_details", { receipts});
  } catch (error) {
    console.log(error);
    res.status(500).send("Failed to fetch data from the database.");
  }
});


// product details
router.get("/reports/purchases/purchase_details", async (req, res) => {
  try {
    const purchases = await Purchase.find(); // Fetch purchases from MongoDB
    res.render("reports/purchases/purchase_details", { purchases});
  } catch (error) {
    console.log(error);
    res.status(500).send("Failed to fetch data from the database.");
  }
});



module.exports = router;
