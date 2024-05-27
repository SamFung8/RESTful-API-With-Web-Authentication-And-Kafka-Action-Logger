package com.example.demo.APIService;

import com.example.demo.KafkaConfig.Producer;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final Producer kafkaProducer;
    private final ProductRepository productRepository;
    private String username;
    private Authentication authentication;

    public ProductService(ProductRepository productRepository, Producer kafkaProducer) {
        this.productRepository = productRepository;
        this.kafkaProducer = kafkaProducer;

    }

    public void updateUser() {
        // Get the current authenticated user
        authentication = SecurityContextHolder.getContext().getAuthentication();
        username = authentication.getName();
    }

    //Save a product.
    public Product saveProduct(Product product) {
        updateUser();
        kafkaProducer.sendMessage(username, "Createing A Product ID" + product.getId().toString());
        return productRepository.save(product);
    }

    //Get all the products.
    public List<Product> getAllProducts() {
        updateUser();
        kafkaProducer.sendMessage(username, "Getting All Product");
        return productRepository.findAll();
    }


    //Get one product by ID.
    public Optional<Product> getProductById(Long id) {
        updateUser();
        kafkaProducer.sendMessage(username, "Getting Product ID " + id.toString());
        return productRepository.findById(id);
    }

    //Update a product.
    public Product updateProduct(Long id, Product updatedProduct) {
        updateUser();
        kafkaProducer.sendMessage(username, "Updateing Product ID " + id.toString());
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    //Delete the product by ID.
    public void deleteProduct(Long id) {
        updateUser();
        kafkaProducer.sendMessage(username, "Deleteing Product ID " + id.toString());
        productRepository.deleteById(id);
    }

}
