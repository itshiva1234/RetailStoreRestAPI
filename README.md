# Introduction: 
This project consists of RESTful services impemented using SpringBoot that implement a checkout counter for an online retail store that scans products and generates itemized bill.

It provides services for managing products and orders.  Products can be configured with rate and category (A,B or C). Sales tax is applied based on the category of the product:
* Category A - 30%
* Category B - 10%
* Category C- 5%

# REST endpoints
Client can add/update/modify products and orders using the REST endpoints.Below is overview of REST end points:

## Products
*  GET /products - fetches list of all product data
*  GET /products/{id} - fetch a specific product
*  POST /products - Creates a new product based on request JSON
*  PUT /products/{id} - Updates product data based on request JSON
*  DELETE /products/{id} - Delete an existing product if it is not associated with a bill.


## Bills
*  GET /bills - fetches all bill data
*  GET /bills/{id} - fetches bill of a particular id
*  POST /bills - creates a bill Id. Client has to use this bill Id while adding and removing products
*  PUT /bills/{id} - Updates bill data. Client can add or remove products to bill sending a JSON request.
*  DELETE /bills/{id} - Delete bill from the system.

 These REST end points are secured using basic authentication mechanism. Code uses in-memory repository with 'bob' as single user.

# About Implementation

This application has been using SpringBoot as it provides a wide variety of features that aid development and maintainence. Some features that were utilised were: Spring Security, Spring Data/JPA and starters.

This program and instructions have been tested on following versions on Windows laptop.
*  Apache Maven 3.5.0 
*  Java version: 1.8.0_131
*  git version 2.9.0.windows.1
