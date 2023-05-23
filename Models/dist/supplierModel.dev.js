"use strict";

//to be used to modal our data
var mongoose = require("mongoose"); //give our schema a name


var supplierSchema = new mongoose.Schema({
  //tell schema what kind of data to expect
  supplierName: {
    type: String,
    trim: true,
    requred: true
  },
  supplierContact: {
    type: String,
    trim: true,
    requred: true
  },
  supplierEmail: {
    type: String,
    trim: true,
    requred: true
  },
  supplierPhone: {
    type: String,
    trim: true,
    requred: true
  },
  supplierAddress: {
    type: String,
    trim: true,
    requred: true
  }
});
module.exports = mongoose.model("Supplier", supplierSchema);