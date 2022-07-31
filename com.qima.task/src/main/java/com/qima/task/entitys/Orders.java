package com.qima.task.entitys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.attribute.HashAttributeSet;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@Column(name = "oid")
private Integer Id;
@Column (name = "customername" )
@NotBlank

private String customername;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "order_product"
,joinColumns = @JoinColumn(name="order_id")
,
inverseJoinColumns = @JoinColumn(name="product_id"))




Set<Product>products=new HashSet<Product>();
@JsonIgnore
private Integer orderquantity;

public Orders(String customername) {
	
	this.customername = customername;
}
public Orders(String customername, Set<Product> products) {
	
	this.customername = customername;
	this.products = products;
}



}
