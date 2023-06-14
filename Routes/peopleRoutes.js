const express = require('express');
const { Model } = require('mongoose');
const router = express.Router();
//imported model
const Customer = require("../Models/customerModel")
const SR = require("../Models/salesmanModel")
const Supplier = require("../Models/supplierModel")

//people
router.get("/people/people",(req,res)=>{
    res.render("people/people")
  });
//add customer
router.get("/people/customers",(req,res)=>{
    res.render("people/customers")
  });

//add salesman
router.get("/people/salesman",(req,res)=>{
    res.render("people/salesman")
  });

//add supplier
router.get("/people/supplier",(req,res)=>{
    res.render("people/supplier")
  });


//CUSTOMER
router.post("/people/customers" ,async(req,res)=>{
    try{
        const customers = new Customer(req.body);
        await customers.save()
        res.redirect('/people/customers')//redirect to a path, render a file
        console.log(req.body)
    }
    catch(error){
    res.status(400).send("Failed to add customer. Please try again.")
    console.log(error)
    }
})

//SR
router.post("/people/salesman" ,async(req,res)=>{
    try{
        const customers = new SR(req.body);
        await customers.save()
        res.redirect('/people/salesman')//redirect to a path, render a file
        console.log(req.body)
    }
    catch(error){
    res.status(400).send("Failed to add salesman. Please try again.")
    console.log(error)
    }
})

//SR
router.post("/people/supplier" ,async(req,res)=>{
    try{
        const supplier = new Supplier(req.body);
        await supplier.save()
        res.redirect('/people/supplier')//redirect to a path, render a file
        console.log(req.body)
    }
    catch(error){
    res.status(400).send("Failed to add supplier. Please try again.")
    console.log(error)
    }
})




  module.exports=router