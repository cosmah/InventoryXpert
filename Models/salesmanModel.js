const mongoose = require('mongoose')

//design schema
const salesmanSchema = new mongoose.Schema({
   fname:{
        type:String,
        trim:true,
        required:true,
    },
    lname:{
        type:String,
        trim:true,
        required:true
        },
    phone:{
        type:String,
        required:true 
    },
    address:{
        type:String,
        required:true 
    },

    nin:{
        type:String,
        trim:true,
        unique: true,
        required:true 
    },
    enroll:{
        type:Date,
        trim:true,
        required:true 
    },

})


module.exports = mongoose.model('SR', salesmanSchema)