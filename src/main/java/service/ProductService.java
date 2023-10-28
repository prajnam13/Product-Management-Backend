package service;

import model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getAllProduct();
    public Product getProductById(Integer id);
    public void deleteProduct(Integer id);
}
