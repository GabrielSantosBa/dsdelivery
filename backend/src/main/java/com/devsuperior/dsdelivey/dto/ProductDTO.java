package com.devsuperior.dsdelivey.dto;

import java.io.Serializable;

import com.devsuperior.dsdelivey.entities.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String image_Uri;
	
	
	public ProductDTO() {}
	
	public ProductDTO(Long id, String name, Double price, String description, String image_Uri) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image_Uri = image_Uri;
	}
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		description = entity.getDescription();
		image_Uri = entity.getImage_Uri();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_Uri() {
		return image_Uri;
	}

	public void setImage_Uri(String image_Uri) {
		this.image_Uri = image_Uri;
	}
	
	
	
}
