"use strict";

var express = require('express');

var router = express.Router();

var Reciept = require("../Models/recieptModel");

var SR = require("../Models/salesmanModel");

var Customer = require("../Models/customerModel");

var Product = require("../Models/productModel"); // add receipt page


router.get('/commerce/addreciept', function _callee(req, res) {
  var customers;
  return regeneratorRuntime.async(function _callee$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.prev = 0;
          _context.next = 3;
          return regeneratorRuntime.awrap(Customer.find());

        case 3:
          customers = _context.sent;
          // Retrieve customers from the database
          res.render('commerce/addreciept', {
            customers: customers
          });
          _context.next = 11;
          break;

        case 7:
          _context.prev = 7;
          _context.t0 = _context["catch"](0);
          console.log(_context.t0);
          res.status(500).send('Failed to fetch data from the database.');

        case 11:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[0, 7]]);
}); // Handle add receipt form submission

router.post("/commerce/addreciept", function _callee2(req, res) {
  var receipt;
  return regeneratorRuntime.async(function _callee2$(_context2) {
    while (1) {
      switch (_context2.prev = _context2.next) {
        case 0:
          _context2.prev = 0;
          receipt = new Reciept(req.body);
          _context2.next = 4;
          return regeneratorRuntime.awrap(receipt.save());

        case 4:
          res.redirect('/commerce/addreciept');
          console.log(req.body);
          _context2.next = 12;
          break;

        case 8:
          _context2.prev = 8;
          _context2.t0 = _context2["catch"](0);
          res.status(400).send("Failed to add receipt. Please try again.");
          console.log(_context2.t0);

        case 12:
        case "end":
          return _context2.stop();
      }
    }
  }, null, null, [[0, 8]]);
}); // NEW: Endpoint for fetching customer name suggestions

router.get('/customers/search', function _callee3(req, res) {
  var searchQuery, customers;
  return regeneratorRuntime.async(function _callee3$(_context3) {
    while (1) {
      switch (_context3.prev = _context3.next) {
        case 0:
          _context3.prev = 0;
          searchQuery = req.query.q;
          _context3.next = 4;
          return regeneratorRuntime.awrap(Customer.find({
            fname: new RegExp(searchQuery, 'i')
          }));

        case 4:
          customers = _context3.sent;
          res.json(customers);
          _context3.next = 12;
          break;

        case 8:
          _context3.prev = 8;
          _context3.t0 = _context3["catch"](0);
          console.log(_context3.t0);
          res.status(500).send('Failed to fetch data from the database.');

        case 12:
        case "end":
          return _context3.stop();
      }
    }
  }, null, null, [[0, 8]]);
});
module.exports = router;