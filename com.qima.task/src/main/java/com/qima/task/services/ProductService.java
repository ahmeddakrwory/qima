package com.qima.task.services;

import java.util.Optional;

import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.qima.task.entitys.Orders;
import com.qima.task.entitys.Product;
import com.qima.task.exeptions.servicelayer.ProductNotFound;
import com.qima.task.exeptions.servicelayer.Quntityex;
import com.qima.task.repos.ProductRepo;

@Service
@Transactional
public class ProductService {
@Autowired
private ProductRepo productRepo;

public Product addproduct(Product product) {
	if(product.getPrice()<1.0 || product.getQuantity()<1) {
		throw new Quntityex("plese fill numric number with more then 0");
	}
	return productRepo.save(product);
	
}
public Product findproduct(Integer pid) {
	Product product=productRepo.findById(pid).orElseThrow(()->new ProductNotFound("product not fond"));
	return product;
}
public Product delProduct(Integer pid) {
	Product product=findproduct(pid);
	productRepo.delete(product);
	return product;
	}
public Product updateProduct(Integer pid,Product p) {
	if(p.getPrice()<1.0 || p.getQuantity()<1) {
		throw new QueryException("plese fill numric number with more then 0");
	}
	Product product=findproduct(pid);
	product.setName(p.getName());
	product.setPrice(p.getPrice());
	product.setQuantity(p.getQuantity());
	productRepo.save(product);
	return product;
	}


public Product sellproduct(Integer prodId,Integer q) {
	if(q<1 ) {
		throw new QueryException("plese fill numric number with more then 0");
	}
Product product=findproduct(prodId); 
	Integer nq=product.getQuantity()-q;
	product.setQuantity(nq);
	product.setQuantity(nq);
	addproduct(product);
	return product;
	
}
public Product update (Integer id,Product p) {
Product	 product=findproduct(id);
	product.setName(p.getName());
	product.setPrice(p.getPrice());
	product.setQuantity(p.getId());
	return productRepo.save(product);
}
public Page<Product> Allproducts(int num,int size) {
	Pageable pageable=PageRequest.of(num,size);
	return productRepo.findAll(pageable);
	

}


}