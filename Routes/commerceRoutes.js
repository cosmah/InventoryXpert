const express = require('express');
const router = express.Router();
const Reciept = require("../Models/recieptModel");
const SR = require("../Models/salesmanModel");
const Customer = require("../Models/customerModel");
const Product = require("../Models/productModel");

// add receipt page
router.get('/commerce/addreciept', async (req, res) => {
  try {
    const customers = await Customer.find(); // Retrieve customers from the database
    res.render('commerce/addreciept', { customers });
  } catch (error) {
    console.log(error);
    res.status(500).send('Failed to fetch data from the database.');
  }
});


// payback page
router.get('/commerce/payback', async (req, res) => {

    res.render('commerce/payback');

});

// Handle add receipt form submission
router.post("/commerce/addreciept", async (req, res) => {
  try {
    const receipt = new Reciept(req.body);
    await receipt.save();
    res.redirect('/commerce/addreciept');
    console.log(req.body);
  } catch (error) {
    res.status(400).send("Failed to add receipt. Please try again.");
    console.log(error);
  }
});

// NEW: Endpoint for fetching customer name suggestions
router.get('/customers/search', async (req, res) => {
  try {
    const searchQuery = req.query.q;
    const customers = await Customer.find({ fname: new RegExp(searchQuery, 'i') });
    res.json(customers);
  } catch (error) {
    console.log(error);
    res.status(500).send('Failed to fetch data from the database.');
  }
});

//PRODUCT
router.get('/products/all', async (req, res) => {
  try {
    const products = await Product.find();
    res.json(products.map(product => ({ name: product.productName })));
  } catch (error) {
    console.log(error);
    res.status(500).send('Failed to fetch data from the database.');
  }
});

function escapeRegExp(string) {
  return string.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
}

// Check if a receipt number already exists in the database
router.post('/receipts/check-number', async (req, res) => {
  try {
    const receiptNumber = req.body.receiptNumber;
    const receipt = await Receipt.findOne({ invoiceNumber: receiptNumber });
    res.json({ exists: !!receipt });
  } catch (error) {
    console.log(error);
    res.status(500).send('Failed to fetch data from the database.');
  }
});
//==========================================================================//


//payments query
router.get('/getCustomers', function(req, res) {
  let input = req.query.input;
  Customer.find({$or: [{fname: new RegExp(input, 'i')}, {lname: new RegExp(input, 'i')}]}, function(err, customers) {
    if(err) {
      console.log(err);
    } else {
      res.json(customers);
    }
  });
});

module.exports = router;