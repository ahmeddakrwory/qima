package com.qima.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qima.task.entitys.*;
import com.qima.task.repos.ProductRepo;
@Service
@Transactional
public class BillService {
@Autowired
private ProductService productService;
@Autowired
private OrdersService ordersService;
public Orders addprodtoorder(Integer oid,Integer pid ,Integer quntity) {
	 Orders order=ordersService.Findorder(oid);
		Product product=	productService.findproduct(pid);
		;
		product.setBought(quntity);
		Integer pactualQuantity=product.getQuantity();
		order.setOrderquantity(quntity);
		
		Integer descount_product=pactualQuantity-quntity;
		product.setQuantity(descount_product);
		
		productService.addproduct(product);
		order.getProducts().add(product);	

	return order;
}


}