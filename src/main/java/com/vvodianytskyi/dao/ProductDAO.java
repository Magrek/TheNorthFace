package com.vvodianytskyi.dao;

import com.vvodianytskyi.model.Product;

import java.util.List;

public interface ProductDAO {

    boolean addProduct(Product product);

    Product getProduct(int id);

    List<Product> getProductList(String type, String gender);

    boolean updateProduct(Product product);

    boolean deleteProduct(Product product);
}
