// models/purchase.js
const mongoose = require('mongoose');

const purchaseSchema = new mongoose.Schema({
  purchaseDate: { type: Date, default: Date.now },
  product: { type: mongoose.Schema.Types.ObjectId, ref: 'Product' },
  quantity: { type: Number, required: true },
  unitPrice: { type: Number, required: true },
  totalCost: { type: Number, required: true },
  // Add any other relevant fields here (e.g., supplier, invoice number, etc.)
});

const Purchase = mongoose.model('Purchase', purchaseSchema);

module.exports = Purchase;
