// routes/purchase.js
const express = require('express');
const router = express.Router();
const Purchase = require('../Models/purchase');

router.get("/commerce/purchases",(req,res)=>{
    res.render("commerce/purchases")
  });


// POST route to add a new purchase
router.post('/purchase', async (req, res) => {
  try {
    const { purchaseDate, product, quantity, unitPrice, totalCost } = req.body;
    const purchase = await Purchase.create({
      purchaseDate,
      product,
      quantity,
      unitPrice,
      totalCost,
    });
    res.status(201).json(purchase);
  } catch (err) {
    res.status(500).json({ error: 'Failed to add purchase history.' });
  }
});

module.exports = router;
