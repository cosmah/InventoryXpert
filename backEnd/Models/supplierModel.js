//to be used to modal our data
const mongoose = require("mongoose");

//give our schema a name
const supplierSchema = new mongoose.Schema({
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
})

module.exports = mongoose.model("Supplier", supplierSchema)