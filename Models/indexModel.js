// //to be used to modal our data
// const mongoose = require("mongoose");

// //give our schema a name
// const customerSchema = new mongoose.Schema({
//     //tell schema what kind of data to expect
//     fname:{
//         type:String,
//         trim:true
//     },
//     lname:{
//         type:String,
//         trim:true
//     },
//     dob:{
//         type:Date,
//         trim:true
//     },
//     gender:{
//         type:String,
//         trim:true
//     },
//     country:{
//         type:String,
//         trim:true
//     },
//     state:{
//         type:String,
//         trim:true
//     },
//     town:{
//         type:String,
//         trim:true
//     },
//     zip:{
//         type:Number,
//         trim:true
//     },
//     phone1:{
//         type:String,
//         trim:true
//     },
//     phone2:{
//         type:String,
//         trim:true
//     },
//     email:{
//         type:String,
//         trim:true
//     }
// })

// module.exports = mongoose.model("Customer", customerSchema)