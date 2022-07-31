package com.qima.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qima.task.entitys.Orders;
import com.qima.task.repos.OrderRepo;
import com.qima.task.services.OrdersService;

@SpringBootTest
class ApplicationTests {
@Autowired
private OrdersService orderRepo;
	@Test
	void contextLoads() {
	}
	@Test
	void testreposetry() {
		Orders orders=orderRepo.Findorder(1);
		Assertions.assertEquals("ahmed", orders.getCustomername());
	}

}
