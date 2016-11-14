package javafiles;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBLM_PRODUCT")
public class Product{

	private int productId;
	private String proName;
	private Integer price;
	private Date date;	
	
	public void setProductId(int productId)
	{
	    this.productId = productId;
	}
	@Id
	@Column(name="ID")
	public int getProductId()
	{
	    return productId;
	}
	 
	public void setProName(String proName)
	{
	    this.proName = proName;
	}
	@Column(name="NAME")
	public String getProName()
	{
	    return proName;
	}
	 
	public void setPrice(Integer price)
	{
	    this.price = price;
	}
	@Column(name="PRICE")
	public Integer getPrice()
	{
	    return price;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Column(name="CREATED_DATE")
	public Date getDate() {
		return date;
	}
}