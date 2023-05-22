"use strict";

var mongoose = require('mongoose'); //design schema


var customerSchema = new mongoose.Schema({
  fname: {
    type: String,
    trim: true,
    required: true,
    unique: true
  },
  lname: {
    type: String,
    trim: true
  },
  shop: {
    type: String,
    trim: true
  },
  phone: {
    type: String,
    required: true
  },
  tin: {
    type: String,
    trim: true
  },
  sr: {
    type: String,
    trim: true
  }
});
module.exports = mongoose.model('Customer', customerSchema);