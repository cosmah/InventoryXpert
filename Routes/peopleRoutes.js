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

//saleman_list page
router.get("/people/salesman_list",async (req,res)=>{
  try {
    const items = await SR.find();
    res.render('people/salesman_list', {srs: items });
  } catch (err) {
    console.log(err);
    res.send('Failed');
  }
  
})

//customers_list page
router.get("/people/customer_list",async (req,res)=>{
  try {
    const items = await Customer.find();
    res.render('people/customer_list', {customers: items });
  } catch (err) {
    console.log(err);
    res.send('Failed');
  }
  
})

//supplier_list page
router.get("/people/supplier_list",async (req,res)=>{
  try {
    const items = await Supplier.find();
    res.render('people/supplier_list', {suppliers: items });
  } catch (err) {
    console.log(err);
    res.send('Failed');
  }
  
})


  module.exports=router