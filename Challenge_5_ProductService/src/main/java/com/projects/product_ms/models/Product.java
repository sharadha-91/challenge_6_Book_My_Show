package com.projects.product_ms.models;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity(name = "products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String image;
    private int availableQuantity;
    @ManyToOne
    private Category category;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
    
    
    
    
}
