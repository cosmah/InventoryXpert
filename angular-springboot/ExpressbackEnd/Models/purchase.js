//to be used to modal our data
const mongoose = require("mongoose");

const purchaseSchema = new mongoose.Schema({
  //tell schema what kind of data to expect
  purchaseDate: {
      type: Date,
      trim: true,
      required: true
    },
  product: {
      type: String,
      trim: true,
      required: true
    },
  quantity: {
      type: Number,
      trim: true,
      required: true
    },
  unitPrice: {
      type: Number,
      trim: true,
      required: true
    },
  totalCost: {
      type: Number,
      trim: true,
      required: true
    }
})

module.exports = mongoose.model("Purchase", purchaseSchema)