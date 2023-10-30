"use strict";

var express = require('express');

var _require = require('mongoose'),
    Model = _require.Model;

var router = express.Router();

var passport = require("passport");

var bcrypt = require('bcrypt'); //imported model


var User = require("../Models/userModel");

router.get("/login", function (req, res) {
  res.render("login");
}); // we redirect to a path and render a page

router.post('/login', passport.authenticate('local', {
  failureRedirect: '/login'
}), function _callee(req, res) {
  var _req$body, email, password, user;

  return regeneratorRuntime.async(function _callee$(_context) {
    while (1) {
      switch (_context.prev = _context.next) {
        case 0:
          _context.prev = 0;
          _req$body = req.body, email = _req$body.email, password = _req$body.password; // Find the user by email

          _context.next = 4;
          return regeneratorRuntime.awrap(User.findOne({
            email: email
          }));

        case 4:
          user = _context.sent;
          _context.t0 = !user;

          if (_context.t0) {
            _context.next = 10;
            break;
          }

          _context.next = 9;
          return regeneratorRuntime.awrap(bcrypt.compare(password, user.password));

        case 9:
          _context.t0 = !_context.sent;

        case 10:
          if (!_context.t0) {
            _context.next = 12;
            break;
          }

          return _context.abrupt("return", res.send('Invalid email or password'));

        case 12:
          // User authentication successful
          res.redirect('/');
          _context.next = 19;
          break;

        case 15:
          _context.prev = 15;
          _context.t1 = _context["catch"](0);
          // Handle any errors that occur during authentication
          console.error(_context.t1);
          res.status(500).send('An error occurred during login');

        case 19:
        case "end":
          return _context.stop();
      }
    }
  }, null, null, [[0, 15]]);
});
module.exports = router;