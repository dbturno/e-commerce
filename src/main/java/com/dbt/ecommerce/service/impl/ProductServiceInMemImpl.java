package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.model.Product;
import com.dbt.ecommerce.service.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceInMemImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
