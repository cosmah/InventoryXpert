//to be used to modal our data
const mongoose = require("mongoose");

//give our schema a name
const productSchema = new mongoose.Schema({
    //tell schema what kind of data to expect
    productType: {
        type: String,
        trim: true,
        requred: true
      },      
    productName:{
        type:String,
        trim:true,
        requred: true
    },
    invoiceNumber:{
        type:Number,
        trim:true,
        requred: true
    },
    category:{
        type:String,
        trim:true,
        requred: true
    },
    quantity:{
        type:Number,
        trim:true,
        requred: true
    },
    beginDate:{
        type:Date,
        trim:true,
        requred: true
    },
    description:{
        type:String,
        trim:true,
        requred: true
    },
    costPrice:{
        type:Number,
        trim:true
    },
    sellingPrice:{
        type:Number,
        trim:true
    },
    memo:{
        type:String,
        trim:true
    },
    supplier:{
        type:String,
        trim:true
    }
})

module.exports = mongoose.model("Product", productSchema)