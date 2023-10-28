package com.example.Product_Management_Backend.service;

import com.example.Product_Management_Backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Product_Management_Backend.repository.ProductRepository;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product saveProduct(Product product) {

        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        Product p = productRepo.findById(id).get();
        if (p != null) {
            productRepo.delete(p);
            return "Product Deleted successfully";
        }
        return "Product not found";
    }

    @Override
    public Product editProduct(Product p, Integer id) {
        Product oldProduct = productRepo.findById(id).get();
        oldProduct.setProductname(p.getProductname());
        oldProduct.setDescription(p.getDescription());
        oldProduct.setPrice(p.getPrice());
        oldProduct.setStatus(p.getStatus());

        return productRepo.save(oldProduct);
    }
}