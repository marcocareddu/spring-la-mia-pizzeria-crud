package org.java.spring;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "Devi inserire almeno 3 caratteri.")
	private String description;
	
	@Length(min = 3, message = "Devi inserire almeno 3 caratteri.")
	@Length(max = 20, message = "Il nome deve essere lungo massimo 20 caratteri.")
	private String name;
	
//	@Pattern(regexp = "((http|https)://)?([a-zA-Z0-9]+[.])?[a-zA-Z0-9-]+[.][a-zA-Z]{2,}(/[a-zA-Z0-9-._~:/?#[\\]@!$&'()*+,;=]*)?$", message = "Devi inserire un URL valido.")
	private String img;
	
	@Range(min = 3, max = 30, message = "Il prezzo deve essere compreso tra €3.00 e €30.00.")
	private double price;

//	Constructors
	public Pizza() {}
	public Pizza(String name, String description, String img, double price){
		setId(id);
		setName(name);
		setDescription(description);
		setImg(img);
		setPrice(price);
	}
	
//	Getters & Setters
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}	
}
