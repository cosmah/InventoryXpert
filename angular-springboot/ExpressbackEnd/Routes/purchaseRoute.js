// routes/purchase.js
const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
const Purchase = require('../Models/purchase');

router.get("/reports/purchases/purchases",(req,res)=>{
    res.render("reports/purchases/purchases")
  });

// router.get("/reports/purchases/purchase_summary",(req,res)=>{
//     res.render("reports/purchases/purchase_summary")
//   });


// POST route to add a new purchase
router.post('/report/purchases/purchases', async (req, res) => {
  try{
    const purchase = new Purchase(req.body);
    await purchase.save()
    res.redirect("/reportS/purchases/purchases");
    console.log(req.body);
  }
  catch(error){
    res.status(400).send("Failed to add purchase, Please try again");
    console.log(error);
  }
});



//expense SUMMARY page
router.get("/reports/purchases/purchase_summary", async (req, res) => {
  try {
    const purchases = await Purchase.find(); // Fetch purchases from MongoDB
    res.render("reports/purchases/purchase_summary", { purchases});
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
