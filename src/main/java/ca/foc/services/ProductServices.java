package ca.foc.services;

import ca.foc.dao.ProductRepository;
import ca.foc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/**
 * ProductServices - ca.foc.services.ProductServices
 */
@Service
public class ProductServices {

    @Autowired
    static ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductInfo(@PathVariable int id) {
        return productRepository.findById(id);
    }

    public Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
    }


}
