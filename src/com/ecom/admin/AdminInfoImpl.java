package com.ecom.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db.resource.myDbConnection;
import com.ecom.product.Product;
import com.ecom.product.buyOrder;
import com.ecom.user.UserInfoImpl;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class AdminInfoImpl implements AdminInfo{
	Connection con=null;
	int total=0;
	int quantity=0;
	String contents="";
	int id=0;
	 int price=0;
	@Override
	public void addProduct() {
		   Scanner sc=new Scanner(System.in);
		   
		 try {
			 con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement("insert into product( prodName,prodDesc, quantity,price)values(?,?,?,?)");
			  
			 System.out.println("Enter the Product Name");
				 String  prodName=sc.nextLine();
				 ps.setString(1, prodName);
				 
				 System.out.println("Enter the Product Description");
				 String prodDesc=sc.nextLine();
				 ps.setString(2, prodDesc);
				 
				 System.out.println("Enter the Quantity");
				 int quantity=sc.nextInt();
				 ps.setInt(3, quantity);
				 
				 System.out.println("Enter the Price");
				 int price=sc.nextInt();
				 ps.setInt(4, price);
				 
				 int i = ps.executeUpdate();
				 System.out.println("Product Item has been added successfully!!!" +i);
				 
				 //close resources
				 sc.close();
				 ps.close();
				 con.close();
		 } catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void totalBill() {
		try { 
			 
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter the UserName");
		 String username=sc.nextLine();
		 
		 con= myDbConnection.getConnectionDetails();
		 PreparedStatement ps = con.prepareStatement("Select * from product where prodId=?");
		 System.out.println("Enter the product Id>>");
		    int id = sc.nextInt();
			 ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	
			  System.out.println("Enter the quantity>> ");
				this.quantity = sc.nextInt();
				this.total += this.quantity * rs.getInt("price");
				contents += rs.getString("prodName") + "\t\t\t" + this.quantity + "\t\t\t" + rs.getFloat("price") + "\n";
		     }
	
		    System.out.println(contents);
			System.out.println("Your total amount is : " + this.total + " rs.");   
		   
			ps.close();
			rs.close();
		   con.close();    
	 }
		catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void displayAmount() {
		buyOrder order=new buyOrder();
		order.getBill();
			 
		}
	@Override
	public void checkQuantity() {
		System.out.println("Enter the Product Id>>");
		Scanner sc=new Scanner(System.in);
		int productid=sc.nextInt();
		 try {
		    con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement("Select quantity from product where prodId=?");
			  ps.setInt(1, productid);
			 ResultSet rs = ps.executeQuery();
			   
			    while(rs.next()) {
			    	  
				 	 System.out.println("Product quantity:: "+rs.getInt("quantity"));
				  }
			   ps.close();
				rs.close();
			    con.close();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void checkRegisterUser() {
		 try {
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter the Username");
			 String username=sc.nextLine();
			 con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement("Select firstName,lastName,userName,city,mailId,mobileNumber from user where userName=?");
			   ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					if(username.equals(rs.getString("userName"))) {
						System.out.println("User is already registered details are as shown below!!! ");
					  System.out.println("First Name: "+rs.getString(1));
					  System.out.println("Last Name: "+rs.getString(2));
					  System.out.println("UserName:"+rs.getString(3));
					  System.out.println("City: "+rs.getString(4));
					  System.out.println("MailId: "+rs.getString(5));
					  System.out.println("MobileNumber: "+rs.getString(6));
					}
				  }
			 
			 
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void checkUserHistory() {
		 try {
			 Scanner sc=new Scanner(System.in);
		     System.out.println("Enter the UserName");
			 String username=sc.nextLine();
			 
			 con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement("Select prodId,prodDesc,quantity from product where user_id=?");
			 System.out.println("Enter the User Id>>");
			    int id = sc.nextInt();
				 ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					 System.out.println("ProductId: "+rs.getInt(1));
					  System.out.println("Product Desc: "+rs.getString(2));
					  System.out.println("quantity: "+rs.getInt(3));
					
				}
			 
		        ps.close();
				rs.close();
			    con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
 
}
