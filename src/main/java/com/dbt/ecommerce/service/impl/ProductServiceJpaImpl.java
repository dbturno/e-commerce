package com.dbt.ecommerce.service.impl;

import com.dbt.ecommerce.exception.ProductNotFoundException;
import com.dbt.ecommerce.model.Product;
import com.dbt.ecommerce.repository.ProductRepository;
import com.dbt.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service class responsible for the business logic of all {@link Product} related API.
 */
@Service
@Primary
public class ProductServiceJpaImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: "+ id + " not found."));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates product by getting the product by id first, then persist the updated product in database,
     * throws {@link ProductNotFoundException} if product id trying to update does not exist.
     * @param newProduct
     * @param id
     * @return
     */
    public Product updateProduct(Product newProduct, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: "+ id + " not found."));
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        return productRepository.save(product);
    }

    private ProductNotFoundException newEx(){
        return new ProductNotFoundException("");
    }

    /**
     * Deletes product from database by id,
     * throws {@link ProductNotFoundException} if product id trying to delete does not exist.
     * @param id
     */
    public void deleteProduct(Long id) {
        productRepository.delete(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " not found.")));
    }
}
