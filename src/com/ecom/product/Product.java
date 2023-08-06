package com.ecom.product;

public class Product {
  
private int prodId;
private String prodName;
private String prodDesc;
private int quantity;
private int price;
private int totalPrice;

public Product() {
 	 
}


public Product(int prodId, String prodName, String prodDesc, int quantity, int price, int totalPrice) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.prodDesc = prodDesc;
	this.quantity = quantity;
	this.price = price;
	this.totalPrice = totalPrice;
}


public Product(int prodId, String prodName, int quantity, int price, int totalPrice) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.quantity = quantity;
	this.price = price;
	this.totalPrice = totalPrice;
}


public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public String getProdDesc() {
	return prodDesc;
}
public void setProdDesc(String prodDesc) {
	this.prodDesc = prodDesc;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
 
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", quantity=" + quantity
			+ ", price=" + price + ", totalPrice=" + totalPrice + "]";
}
 



}
