"use strict";

var path = require('path');

var express = require('express');

var router = express.Router();
router.get("/", function (req, res) {
  var title = 'Home';
  res.render("index", {
    title: title
  });
});
router.get("/layout", function (req, res) {
  res.render('layout');
});
module.exports = router;