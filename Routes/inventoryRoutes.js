const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
//import product model
const Product = require("../Models/productModel")
const Category = require("../Models/categoryModel")
const Supplier = require("../Models/supplierModel");
const async = require('hbs/lib/async');



//products SUMMARY page
router.get("/reports/inventory/inventory_summary",async (req,res)=>{
  try {
    const items = await Product.find();
    res.render('reports/inventory/inventory_summary', {products: items });
  } catch (err) {
    console.log(err);
    res.send('Failed');
  }
  
})

//PRODUCT DELETE 
router.delete('/products/:productId', async (req, res) => {
  try {
    const productId = req.params.productId;
    const deletedProduct = await Product.findByIdAndDelete(productId);
    if (!deletedProduct) {
      console.log(`No product found with id: ${productId}`);
      res.status(404).send({ error: 'Product not found' });
    } else {
      console.log(`Deleted product with id: ${productId}`);
      res.status(200).send({ message: 'Product deleted successfully' });
    }
  } catch (error) {
    console.error(error);
    res.status(500).send({ error: 'Failed to delete product' });
  }
});

  module.exports=router