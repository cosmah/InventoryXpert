"use strict";

var mongoose = require('mongoose');

var passportLocalMongoose = require('passport-local-mongoose'); //design schema


var userSchema = new mongoose.Schema({
  company: {
    type: String,
    trim: true,
    required: true
  },
  email: {
    type: String,
    trim: true,
    required: true,
    unique: true
  },
  username: {
    type: String,
    trim: true,
    required: true,
    unique: true
  },
  // uniqueid:{
  //     type:String,
  //     trim:true,
  //     required:true 
  // },
  //for development purpose uncomment but before releasing please comment the password
  password: {
    type: String,
    required: true
  },
  contact: {
    type: String,
    trim: true,
    required: true,
    unique: true
  },
  city: {
    type: String,
    trim: true,
    required: true
  },
  address: {
    type: String,
    trim: true,
    required: true
  },
  country: {
    type: String,
    trim: true,
    required: true
  }
});
userSchema.plugin(passportLocalMongoose);
module.exports = mongoose.model('User', userSchema);