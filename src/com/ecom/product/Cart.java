package com.ecom.product;

public class Cart extends Product {

private int cartId;
private int prodId;
private String productName;	
private int quantity;
private int price;

public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
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
	return "Cart [cartId=" + cartId + ", prodId=" + prodId + ", productName=" + productName + ", quantity=" + quantity
			+ ", price=" + price + "]";
}
 

 


}
