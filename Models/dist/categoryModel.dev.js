"use strict";

//to be used to modal our data
var mongoose = require("mongoose"); //give our schema a name


var categorySchema = new mongoose.Schema({
  //tell schema what kind of data to expect
  categoryName: {
    type: String,
    trim: true,
    requred: true
  }
});
module.exports = mongoose.model("Category", categorySchema);