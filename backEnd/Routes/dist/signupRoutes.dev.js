"use strict";

var express = require('express');

var _require = require('mongoose'),
    Model = _require.Model;

var router = express.Router(); //imported model

var User = require("../Models/userModel"); //genral call


router.get("/signup", function (req, res) {
  res.render("signup");
});
router.post("/signup", function _callee(req, res) {
  var user, userName;
  return regeneratorRuntime.async(function _callee$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          console.log(req.body);
          _context.prev = 1;
          user = new User(req.body);
          _context.next = 5;
          return regeneratorRuntime.awrap(User.findOne({
            username: req.body.username
          }));

        case 5:
          userName = _context.sent;

          if (!userName) {
            _context.next = 10;
            break;
          }

          return _context.abrupt("return", res.send("this unique id already exists"));

        case 10:
          _context.next = 12;
          return regeneratorRuntime.awrap(User.register(user, req.body.password, function (error) {
            if (error) {
              throw error;
            }

            res.redirect("/login");
          }));

        case 12:
          _context.next = 18;
          break;

        case 14:
          _context.prev = 14;
          _context.t0 = _context["catch"](1);
          res.status(400).send("sorry it seems there is trouble accesing this page");
          console.log(_context.t0);

        case 18:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[1, 14]]);
});
module.exports = router;