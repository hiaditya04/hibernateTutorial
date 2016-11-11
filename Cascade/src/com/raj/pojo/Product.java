package com.raj.pojo;

public class Product {
	private int id;
	private String name;
	private int price;
	private ProductDetail detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
	/**
	 * @return the detail
	 */
	public ProductDetail getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}
	
}
