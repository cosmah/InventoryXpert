const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
//import product model
const Product = require("../Models/productModel")
const Category = require("../Models/categoryModel")
const Supplier = require("../Models/supplierModel")

// Render the add product page with dynamic data
router.get("/inventory/addproduct", async (req, res) => {
  try {
    const categories = await Category.find(); // Fetch categories from MongoDB
    const suppliers = await Supplier.find(); // Fetch suppliers from MongoDB
    res.render("inventory/addproduct", { categories, suppliers });
  } catch (error) {
    console.log(error);
    res.status(500).send("Failed to fetch data from the database.");
  }
});

//add category page
router.get("/inventory/category",(req,res)=>{
    res.render("inventory/category")
  });


 
  // Handle add product form submission
  router.post("/inventory/addproduct", async (req, res) => {
    try {
      const product = new Product(req.body);
      await product.save();
      res.redirect('/inventory/addproduct'); // Redirect to the add product page after successful submission
      console.log(req.body);
    } catch (error) {
      res.status(400).send("Failed to add product. Please try again.");
      console.log(error);
    }
  });
  
  // Handle add category form submission
  router.post("/inventory/category", async (req, res) => {
    try {
      const category = new Category(req.body);
      await category.save();
      res.redirect('/inventory/category'); // Redirect to the add product page after successful submission
      console.log(req.body);
    } catch (error) {
      res.status(400).send("Failed to add product category. Please try again.");
      console.log(error);
    }
  });
  
  //...
  
// //SR
// router.post("/people/salesman" ,async(req,res)=>{
//     try{
//         const customers = new SR(req.body);
//         await customers.save()
//         res.redirect('/people/salesman')//redirect to a path, render a file
//         console.log(req.body)
//     }
//     catch(error){
//     res.status(400).send("Failed to add salesman. Please try again.")
//     console.log(error)
//     }
// })




  module.exports=router