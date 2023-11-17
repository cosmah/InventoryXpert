"use strict";

var express = require('express');

var _require = require('mongoose'),
    Model = _require.Model;

var router = express.Router(); //imported model

var Customer = require("../Models/customerModel");

var SR = require("../Models/salesmanModel");

var Supplier = require("../Models/supplierModel"); //add customer


router.get("/people/customers", function (req, res) {
  res.render("people/customers");
}); //add salesman

router.get("/people/salesman", function (req, res) {
  res.render("people/salesman");
}); //add supplier

router.get("/people/supplier", function (req, res) {
  res.render("people/supplier");
}); //CUSTOMER

router.post("/people/customers", function _callee(req, res) {
  var customers;
  return regeneratorRuntime.async(function _callee$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.prev = 0;
          customers = new Customer(req.body);
          _context.next = 4;
          return regeneratorRuntime.awrap(customers.save());

        case 4:
          res.redirect('/people/customers'); //redirect to a path, render a file

          console.log(req.body);
          _context.next = 12;
          break;

        case 8:
          _context.prev = 8;
          _context.t0 = _context["catch"](0);
          res.status(400).send("Failed to add customer. Please try again.");
          console.log(_context.t0);

        case 12:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[0, 8]]);
}); //SR

router.post("/people/salesman", function _callee2(req, res) {
  var customers;
  return regeneratorRuntime.async(function _callee2$(_context2) {
    while (1) {
      switch (_context2.prev = _context2.next) {
        case 0:
          _context2.prev = 0;
          customers = new SR(req.body);
          _context2.next = 4;
          return regeneratorRuntime.awrap(customers.save());

        case 4:
          res.redirect('/people/salesman'); //redirect to a path, render a file

          console.log(req.body);
          _context2.next = 12;
          break;

        case 8:
          _context2.prev = 8;
          _context2.t0 = _context2["catch"](0);
          res.status(400).send("Failed to add salesman. Please try again.");
          console.log(_context2.t0);

        case 12:
        case "end":
          return _context2.stop();
      }
    }
  }, null, null, [[0, 8]]);
}); //SR

router.post("/people/supplier", function _callee3(req, res) {
  var supplier;
  return regeneratorRuntime.async(function _callee3$(_context3) {
    while (1) {
      switch (_context3.prev = _context3.next) {
        case 0:
          _context3.prev = 0;
          supplier = new Supplier(req.body);
          _context3.next = 4;
          return regeneratorRuntime.awrap(supplier.save());

        case 4:
          res.redirect('/people/supplier'); //redirect to a path, render a file

          console.log(req.body);
          _context3.next = 12;
          break;

        case 8:
          _context3.prev = 8;
          _context3.t0 = _context3["catch"](0);
          res.status(400).send("Failed to add supplier. Please try again.");
          console.log(_context3.t0);

        case 12:
        case "end":
          return _context3.stop();
      }
    }
  }, null, null, [[0, 8]]);
});
module.exports = router;