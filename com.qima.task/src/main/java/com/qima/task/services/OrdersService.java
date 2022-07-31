package com.qima.task.services;

import javax.management.ReflectionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;
import com.qima.task.exeptions.servicelayer.ProductNotFound;
import com.qima.task.exeptions.servicelayer.ReFundExc;
import com.qima.task.repos.OrderRepo;
import com.qima.task.repos.ProductRepo;

import lombok.Data;

@Service
@Data
@Transactional
public class OrdersService {
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepo productRepo;
public Orders addOrdes(Orders orders) {
	return orderRepo.save(orders);
}
public Orders Findorder(Integer id) {
	Orders orders=orderRepo.findById(id).orElseThrow(()->new ProductNotFound("This id is not existed"));
	return orders;
}
public Orders delete(Integer id) {
	Orders orders=Findorder(id);
	// refund error
	if(!orders.getProducts().isEmpty()) {
		throw new ReFundExc("pelease refund all products");
	}
	orderRepo.delete(orders);
	return orders;
}
public Orders update(Integer id,Orders orders) {
	Orders uporders=Findorder(id);
	uporders.setCustomername(orders.getCustomername());
	uporders.setId(id);
	orderRepo.save(orders);
	return orders;
}
public Page<Orders> Allorders(int num,int size) {
	Pageable pageable=PageRequest.of(num,size);
	return orderRepo.findAll(pageable);
}
}
