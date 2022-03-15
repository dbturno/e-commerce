package com.dbt.ecommerce.service;

import com.dbt.ecommerce.exception.ProductNotFoundException;
import com.dbt.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product getProductById(Long id);

    public Product saveProduct(Product product);

    /**
     * Updates product by getting the product by id first, then persist the updated product in database,
     * throws {@link ProductNotFoundException} if product id trying to update does not exist.
     * @param newProduct
     * @param id
     * @return
     */
    public Product updateProduct(Product newProduct, Long id);

    /**
     * Deletes product from database by id,
     * throws {@link ProductNotFoundException} if product id trying to delete does not exist.
     * @param id
     */
    public void deleteProduct(Long id);
}
