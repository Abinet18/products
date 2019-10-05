package com.products.sales.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.products.sales.model.Product;
import com.products.sales.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class SalesController {

		@Autowired
		ProductService productService;
		
//		@Autowired
//		private Logger logger;

		@GetMapping("/test")
		public String getTestHello()
		{
			return "Hello Tester";
		}
		
		@GetMapping("/products")
		List<Product> getProducts() {
			return productService.getProducts();
		}
		
		@GetMapping("/product/{id}")
		Optional<Product> getProduct(@PathVariable Long id)
		{
			return productService.getProduct(id);
		}
		
		@PostMapping("/product/add")
		public Product addProduct(@RequestBody Product product) {
			return productService.createProduct(product);
		}
		
		@PutMapping("/product/update")
		public Product updateProduct(@RequestBody Product product) {
			return productService.updateProduct(product);
		}
		
		@DeleteMapping("/product/delete/{id}")
		public Long deleteProduct(@PathVariable Long id) {

			return productService.deleteProduct(id);
		}
		@PostMapping("/product/file") 
		public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException{
	        String path="C:\\Users\\Abinet\\Desktop\\Spring\\test\\src\\main\\resources\\static\\";
	        //String path="/tmp/";  
//	        Storage storage = StorageOptions.getDefaultInstance().getService();
//	        String fileName=file.getOriginalFilename();
			File fileToSave = new File(path + file.getOriginalFilename());
	           // copy file content from received file to new local file
	            file.transferTo(fileToSave);        
	        //everything was OK, return HTTP OK status (200) to the client
	        return file.getOriginalFilename();	      
	    }
	}
