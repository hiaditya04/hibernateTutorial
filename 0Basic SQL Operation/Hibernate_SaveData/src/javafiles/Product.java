package javafiles;

import java.util.Date;

public class Product{

	private int productId;
	private String proName;
	private Integer price;
	private Date date;	
	
	public void setProductId(int productId)
	{
	    this.productId = productId;
	}
	public int getProductId()
	{
	    return productId;
	}
	 
	public void setProName(String proName)
	{
	    this.proName = proName;
	}
	public String getProName()
	{
	    return proName;
	}
	 
	public void setPrice(Integer price)
	{
	    this.price = price;
	}
	public Integer getPrice()
	{
	    return price;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
}