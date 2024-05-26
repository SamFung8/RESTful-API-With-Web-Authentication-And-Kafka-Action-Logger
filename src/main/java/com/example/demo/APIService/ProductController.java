package com.example.demo.APIService;

import com.example.demo.APIService.Product;
import com.example.demo.APIService.ProductService;
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
	@GetMapping("/getProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

        //GetById
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

        //UpdateById
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		return ResponseEntity.ok(updatedProduct);
	}

        //DeleteById
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("Product deleted successfully");
	}
}
