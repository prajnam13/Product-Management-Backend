package service;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{
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
    public void deleteProduct(Integer id) {
        Product p=productRepo.findById(id).get();
        productRepo.delete(p);
    }
}
