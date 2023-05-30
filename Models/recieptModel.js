// To be used to model our data
const mongoose = require("mongoose");

// Give our schema a name
const receiptSchema = new mongoose.Schema({
  customer: {
    type: String,
    trim: true,
    required: true
  },
  address: {
    type: String,
    trim: true
  },
  date: {
    type: Date,
    required: true
  },
  due: {
    type: Date,
    required: true
  },
  terms: {
    type: String,
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
  },
  invoiceNumber: {
    type: Number,
    unique: true,
    required: true
  }
});

// Create the Receipt model using the receipt schema
const Receipt = mongoose.model("Receipt", receiptSchema);

// Export the Receipt model
module.exports = Receipt;
