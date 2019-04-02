package com.vvodianytskyi.service.impl;

import com.vvodianytskyi.dao.DriverFactory;
import com.vvodianytskyi.dao.ProductDAO;
import com.vvodianytskyi.dao.impl.ProductDAOPostgres;
import com.vvodianytskyi.model.Product;
import com.vvodianytskyi.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    private final ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAOPostgres(DriverFactory.getConnection());
    }

    @Override
    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    @Override
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Override
    public List<Product> getProductList(String type, String gender) {
        return productDAO.getProductList(type, gender);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productDAO.deleteProduct(product);
    }

    @Override
    public boolean decreaseProductQuantity(Product product) {
        int quantity = product.getQuantity();
        product.setQuantity(--quantity);
        return productDAO.updateProduct(product);
    }
}
