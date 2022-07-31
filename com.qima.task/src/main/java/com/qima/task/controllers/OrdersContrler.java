package com.qima.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;
import com.qima.task.repos.OrderRepo;
import com.qima.task.services.OrdersService;
import com.qima.task.services.ProductService;
@CrossOrigin(maxAge = 3600)
@RestController

@RequestMapping("/order")
public class OrdersContrler {
@Autowired
private OrdersService ordersService;


 
@PostMapping("/add")
public ResponseEntity<Orders>add(@RequestBody Orders o){
	Orders orders=ordersService.addOrdes(o);
	return new ResponseEntity<Orders>(o, HttpStatus.OK);
}
@PostMapping("/delete/{id}")
public ResponseEntity<Orders>delete(@PathVariable(name = "id")Integer id){
	Orders o= ordersService.delete(id);
	return new ResponseEntity<Orders>(o, HttpStatus.OK);
}
@PostMapping("/update/{id}")
public ResponseEntity<Orders>update(@PathVariable(name = "id")Integer id,@RequestBody Orders orders){
	Orders o= ordersService.update(id,orders);
	return new ResponseEntity<Orders>(o, HttpStatus.OK);
}
@GetMapping("all/{num}/{size}")
public Page<Orders>findall(@PathVariable(name = "num")Integer num,@PathVariable(name="size")Integer size){
	return ordersService.Allorders(num, size);
}
@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("allorders")
public List<Orders>findall(){
	return ordersService.getOrderRepo().findAll();
}
}
