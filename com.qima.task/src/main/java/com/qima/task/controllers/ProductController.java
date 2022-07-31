package com.qima.task.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;
import com.qima.task.repos.ProductRepo;
import com.qima.task.services.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
private ProductService productService;
@Autowired
private ProductRepo productRepo;
@PostMapping("/add")
public ResponseEntity<Product>add( @RequestBody Product p){
	Product product=productService.addproduct(p);
	return new ResponseEntity<Product>(p, HttpStatus.OK);
}
@GetMapping("/find/{id}")
public ResponseEntity<Product>find( @PathVariable(name = "id") Integer id){
	Product product=productService.findproduct(id);
	return new ResponseEntity<Product>(product, HttpStatus.OK);
}
@PostMapping("/update/{id}")
public ResponseEntity<Product>update(@PathVariable(name =  "id") Integer id, @RequestBody Product p){
	Product product=productService.updateProduct(id,p);
	return new ResponseEntity<Product>(p, HttpStatus.OK);
}
@PostMapping("dinc/{id}/{q}")
public Product dinc(@PathVariable(name = "id")Integer id,@PathVariable(name = "q")Integer q) {
	Product product=productService.findproduct(id);
	Integer newq=product.getQuantity()+q;
	product.setQuantity(newq);
	return productRepo.save(product);
}
@GetMapping("all/{num}/{size}")
public Page<Product>findall(@PathVariable(name = "num")Integer num,@PathVariable(name="size")Integer size){
	return productService.Allproducts(num, size);
}
}
