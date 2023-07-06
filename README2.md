THIS IS THE STRUCTURE OF THE SYSTEM
======FOLDERS======
1.Config; its is for storing database file.
2.Models; Its is for storing data models.
3.Views; its is for storing templates for displaying to the user.
4.Routes; its for storing Routes.

======SUB-FOLDERS======
In views we have multiple subfolders;
1.commerce; this has the following files
    addreciept.pug is for generating reciepts.
    layout.pug is for extending layout.
    payback.pug is for entering payments recieved from client.
    terms.pug is for enrolling terms of paymnets.

2.inventory; this is for stock management; it has the following files
    addproduct.pug for adding products to stock.
    category.pug for adding product category.
    products.pug for displaying products in the database.

3.people; this has the following files
    customer_list.pug for displaying customers in database.
    customers.pug for adding new customers.
    people.pug is the entry point for all personells.
    salesman_list.pug is for displaying all sales reps in database.
    salesman.pug is for adding salemen.
    supplier_list.pug is for displaying suppliers.
    suppliers.pug is for adding suppliers to database.