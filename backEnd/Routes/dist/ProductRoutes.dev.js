"use strict";

var express = require('express');

var _require = require('mongoose'),
    Model = _require.Model;

var router = express.Router(); //import product model

var Product = require("../Models/productModel");

var Category = require("../Models/categoryModel");

var Supplier = require("../Models/supplierModel"); // Render the add product page with dynamic data


router.get("/inventory/addproduct", function _callee(req, res) {
  var categories, suppliers;
  return regeneratorRuntime.async(function _callee$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.prev = 0;
          _context.next = 3;
          return regeneratorRuntime.awrap(Category.find());

        case 3:
          categories = _context.sent;
          _context.next = 6;
          return regeneratorRuntime.awrap(Supplier.find());

        case 6:
          suppliers = _context.sent;
          // Fetch suppliers from MongoDB
          res.render("inventory/addproduct", {
            categories: categories,
            suppliers: suppliers
          });
          _context.next = 14;
          break;

        case 10:
          _context.prev = 10;
          _context.t0 = _context["catch"](0);
          console.log(_context.t0);
          res.status(500).send("Failed to fetch data from the database.");

        case 14:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[0, 10]]);
}); //add category page

router.get("/inventory/category", function (req, res) {
  res.render("inventory/category");
}); // Handle add product form submission

router.post("/inventory/addproduct", function _callee2(req, res) {
  var product;
  return regeneratorRuntime.async(function _callee2$(_context2) {
    while (1) {
      switch (_context2.prev = _context2.next) {
        case 0:
          _context2.prev = 0;
          product = new Product(req.body);
          _context2.next = 4;
          return regeneratorRuntime.awrap(product.save());

        case 4:
          res.redirect('/inventory/addproduct'); // Redirect to the add product page after successful submission

          console.log(req.body);
          _context2.next = 12;
          break;

        case 8:
          _context2.prev = 8;
          _context2.t0 = _context2["catch"](0);
          res.status(400).send("Failed to add product. Please try again.");
          console.log(_context2.t0);

        case 12:
        case "end":
          return _context2.stop();
      }
    }
  }, null, null, [[0, 8]]);
}); // Handle add category form submission

router.post("/inventory/category", function _callee3(req, res) {
  var category;
  return regeneratorRuntime.async(function _callee3$(_context3) {
    while (1) {
      switch (_context3.prev = _context3.next) {
        case 0:
          _context3.prev = 0;
          category = new Category(req.body);
          _context3.next = 4;
          return regeneratorRuntime.awrap(category.save());

        case 4:
          res.redirect('/inventory/category'); // Redirect to the add product page after successful submission

          console.log(req.body);
          _context3.next = 12;
          break;

        case 8:
          _context3.prev = 8;
          _context3.t0 = _context3["catch"](0);
          res.status(400).send("Failed to add product category. Please try again.");
          console.log(_context3.t0);

        case 12:
        case "end":
          return _context3.stop();
      }
    }
  }, null, null, [[0, 8]]);
}); //...
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

module.exports = router;