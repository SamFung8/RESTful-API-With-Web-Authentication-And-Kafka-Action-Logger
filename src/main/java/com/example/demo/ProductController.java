package com.example.demo;

import com.example.demo.Product;
import com.example.demo.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	private final ProductService productService;

	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

        //Create
	@PostMapping("/addProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		return ResponseEntity.ok(newProduct);
	}

        //GetAll
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

        //GetById
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

        //UpdateById
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		return ResponseEntity.ok(updatedProduct);
	}

        //DeleteById
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted successfully");
	}
}
