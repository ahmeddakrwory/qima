package com.qima.task.entitys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
@Id
@GeneratedValue(strategy =  GenerationType.SEQUENCE)
private Integer id;
//@NotEmpty(message = "this is mandatory field")

@NotBlank (message = "name must not blank")
private String name;
//@NotEmpty (message = "this is mandotry field")

private Integer bought;
private Double price;

//@NotBlank (message =  "quantity must be enterd as number")
private Integer quantity;
@ManyToMany(mappedBy = "products" ,cascade = CascadeType.ALL)
@JsonBackReference
@JsonIgnore
private Set< Orders> orders;
public Product( String name,Double price,Integer quantity) {
	
	this.name = name;
	this.price = price;
	this.quantity=quantity;
}

}
