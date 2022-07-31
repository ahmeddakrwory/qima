package com.qima.task.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
	

}
