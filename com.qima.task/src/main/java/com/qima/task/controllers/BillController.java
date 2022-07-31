package com.qima.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;
import com.qima.task.services.BillService;
import com.qima.task.services.OrdersService;
import com.qima.task.services.ProductService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrdersService ordersService;
 private BillService billService;
	@PostMapping("/add/{oid}/{pid}/{quntity}")			
public Orders addprodtoorder(@PathVariable(name = "oid") Integer oid,@PathVariable(name = "pid") Integer pid ,@PathVariable(name = "quntity")Integer quntity) {
			 Orders order=ordersService.Findorder(oid);
			Product product=	productService.findproduct(pid);
			;
			Integer pactualQuantity=product.getQuantity();
			order.setOrderquantity(quntity);
			Integer descount_product=pactualQuantity-quntity;
			product.setQuantity(descount_product);
			productService.addproduct(product);
			order.getProducts().add(product);	

return order;
	}
}

