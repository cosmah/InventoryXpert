const customerSelect = document.querySelector('#customer');
const addressInput = document.querySelector('#address');
const salesmanInput = document.querySelector('#salesman');

// Initialize Select2 input field
$(customerSelect).select2({
  placeholder: 'Select a customer...',
  ajax: {
    url: '/customers/search',
    dataType: 'json',
    delay: 250,
    data: params => ({ q: params.term }),
    processResults: data => ({
      results: data.map(customer => ({
        id: customer._id,
        text: `${customer.fname} ${customer.lname}`,
        shop: customer.shop,
        sr: customer.sr
      }))
    }),
    cache: true
  }
});

// Handle changes to Select2 input field value
$(customerSelect).on('change', () => {
  const selectedOption = $(customerSelect).select2('data')[0];

  if (selectedOption) {
    addressInput.value = selectedOption.shop;
    salesmanInput.value = selectedOption.sr;
  }
});

const productInput = document.querySelector('input[name="product"]');
const suggestionsList = document.querySelector('#suggestions');
productInput.addEventListener('focus', async () => {
const response = await fetch('/products/all');
const suggestions = await response.json();
suggestionsList.innerHTML = '';
for (const suggestion of suggestions) {
  const option = document.createElement('option');
  option.value = suggestion.name;
  suggestionsList.appendChild(option);
}
});

//RECIEPT NUMBER
let currentMonth = null;
let sequenceNumber = 1;

function generateReceiptNumber() {
  const date = new Date();
  const year = date.getFullYear();
  const month = date.getMonth() + 1;
  if (month !== currentMonth) {
    currentMonth = month;
    sequenceNumber = 1;
  }
  let receiptNumber;
  do {
    receiptNumber = `${year}${month.toString().padStart(2, '0')}${sequenceNumber.toString().padStart(4, '0')}`;
    sequenceNumber += 1;
  } while (receiptExists(receiptNumber)); // Check if receiptNumber exists in the database
  return receiptNumber;
}

// Simulating receiptExists function to check if receiptNumber exists in the database
function receiptExists(receiptNumber) {
  // Simulated logic: Check if receiptNumber exists in the database (e.g., by making an AJAX request to the server)
  // Replace this with your actual logic to check the database
  const database = ["2023010001", "2023010002"]; // Simulated database
  return database.includes(receiptNumber);
}

window.addEventListener('load', () => {
  const invoiceNumberInput = document.querySelector('#invoiceNumber');
  invoiceNumberInput.value = generateReceiptNumber();
});
