package com.inventoryxpert.application.backend.service;

import com.inventoryxpert.application.backend.entity.Product;
import com.inventoryxpert.application.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public List<Product> findAll(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return productRepository.findAll();
        } else {
            return productRepository.search(stringFilter);
        }
    }

    public Product save(Long id, String productName, String productCode,
                        String productDescription, String price,String resalePrice, String quantity, Date startingDate, String supplier){
        Product product = new Product();
        product.setId(id);
        product.setProductCode(productCode);
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPrice(Double.valueOf(price)); // convert string to double
        product.setResalePrice(Double.valueOf(resalePrice)); // corrected here
        product.setStartingDate(startingDate);
        product.setQuantity(Integer.valueOf(quantity)); // convert string to integer
        product.setSupplier(supplier);

        return productRepository.save(product);
    }


}
