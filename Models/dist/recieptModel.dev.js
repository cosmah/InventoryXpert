"use strict";

//to be used to modal our data
var mongoose = require("mongoose"); //give our schema a name


var recieptSchema = new mongoose.Schema({
  //tell schema what kind of data to expect
  customer: {
    type: String,
    trim: true,
    requred: true
  },
  address: {
    type: String,
    trim: true
  },
  date: {
    type: Date,
    trim: true,
    requred: true
  },
  due: {
    type: Date,
    trim: true,
    requred: true
  },
  terms: {
    type: String,
    trim: true
  },
  reciept: {
    type: Number,
    trim: true
  },
  sr: {
    type: String,
    trim: true
  },
  product: {
    type: String,
    trim: true
  },
  description: {
    type: String,
    trim: true
  },
  quantity: {
    type: Number,
    trim: true
  },
  rate: {
    type: Number,
    trim: true
  },
  amount: {
    type: Number,
    trim: true
  },
  total: {
    type: Number,
    trim: true
  }
});
module.exports = mongoose.model("Reciept", recieptSchema);