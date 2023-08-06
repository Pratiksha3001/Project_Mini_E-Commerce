package com.ecom.product;

public class Cart{

private int cartid;
private int pId;
private int quantity;
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Cart [cartid=" + cartid + ", pId=" + pId + ", quantity=" + quantity + "]";
}
 



 


}
