package com.ecom.product;

public class Product {
  
private int prodId;
private String prodName;
private String prodDesc;
private int quantity;
private int price;
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
@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", quantity=" + quantity
			+ ", price=" + price + "]";
}



}
