package com.ecom.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.db.resource.myDbConnection;
import com.ecom.product.Product;

public class UserInfoImpl implements UserInfo {
  Connection con=null;
  int id=0;
 int quantity=0;
 int total=0;
 String contents=" ";
 
  public String getRoleOfUser(String userId,String password) {
	  String userRole=null;
	  String query="select userRole from user where userName=? and UserPassword=?";
	  try {
		   con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement(query);
			 ps.setString(1, userId);
			 ps.setString(2, password); 
			 
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()) {
				 userRole=rs.getString("userRole");
			 }
		ps.close();
		rs.close();
		con.close();
	  }catch (Exception e) {
		 e.printStackTrace();
	}
 
	  return userRole;
 }

  public User getUserInput() {
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the First Name");
		 String firstName=sc.nextLine();
		 
		  System.out.println("Enter the Last Name");
		 String lastName=sc.nextLine();
		 
		   System.out.println("Enter the UserName");
		 String userName=sc.nextLine();
		  
		  System.out.println("Enter the UserPassword");
		 String userPass=sc.nextLine();
		  
		 System.out.println("Enter the City");
		 String city=sc.nextLine();
		 
		 System.out.println("Enter the Email-Id");
		 String emailId=sc.nextLine();
		 
		  System.out.println("Enter the Mobile Number");
		 long mobNumber=sc.nextLong();
		 
		  User user=new User(firstName, lastName, userName, userPass, city, emailId,mobNumber);
		 System.out.println(user);
		return user;
		  
  }
@Override
public void getUserDetails(User user) {
	try {
		  
		 con= myDbConnection.getConnectionDetails();
		 PreparedStatement ps = con.prepareStatement("insert into user(firstName,lastName,userName,userPassword,city,mailId,mobileNumber,userRole)values(?,?,?,?,?,?,?,?)");
		  
		  ps.setString(1, user.getFirstName());
		  ps.setString(2, user.getLastName());
	      ps.setString(3, user.getUserName());
		  ps.setString(4, user.getUserPassword());
		  ps.setString(5, user.getCity());
		  ps.setString(6,user.getMailId());
		  ps.setLong(7, user.getMobileNumber());
		  ps.setString(8, user.getUserRole());
		  
		 int i = ps.executeUpdate();
		 System.out.println("Your Registration done successfully!!!" +i);
		 //close resources
	 
		 ps.close();
		 con.close();
	 } catch (Exception e) {
		 e.printStackTrace();
	}
	
}

@Override
public void userLogin() {
	    Scanner sc=new Scanner(System.in);
	try {
		con= myDbConnection.getConnectionDetails();
 	   String query="select * from user";
		PreparedStatement ps = con.prepareStatement(query);
		 ResultSet rs = ps.executeQuery();
		  
		 
		 while(rs.next()) {
			 System.out.println("Enter the UserName");
			 String name=sc.nextLine();
			 System.out.println("Enter the UserPassword");
			 String password=sc.nextLine();
			 String uname=rs.getString("userName");
			 String upass=rs.getString("UserPassword");
			  if(name.equals(uname) && password.equals(upass)) {
				 System.out.println("You are login successfully");
			 }
			  else{
				  System.out.println("You entered Invalid Username and Password");
			 }
		 }
			  rs.close();
			  ps.close();
			  con.close();
	 }catch(Exception e) {
          e.printStackTrace();
      }
	
}

@Override
public void displayUser() {
     try {
    	 con= myDbConnection.getConnectionDetails();
		PreparedStatement ps = con.prepareStatement("select * from user");
	
		ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			  System.out.println("ID: "+rs.getInt(1));
			  System.out.println("First Name: "+rs.getString(2));
			  System.out.println("Last Name: "+rs.getString(3));
			  System.out.println("UserName:"+rs.getString(4));
			  System.out.println("City: "+rs.getString(5));
			  System.out.println("MailId: "+rs.getString(6));
			  System.out.println("MobileNumber: "+rs.getString(7));
		  }
     
		     rs.close();
			 ps.close();
			 con.close();
     
     } catch (Exception e) {
	 
		e.printStackTrace();
	}
      
	  
	
}

@Override
public void addProductOrder() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Product id you want to buy");
	int prodid=sc.nextInt();
	 try {
		 
		 con= myDbConnection.getConnectionDetails();
		 PreparedStatement ps = con.prepareStatement(" ");
		 ps.setInt(1, prodid);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 
		 }
		 rs.close();
		 ps.close();
		 con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
 
@Override
public void viewProduct() {
	 try {
	con= myDbConnection.getConnectionDetails();
	 PreparedStatement ps = con.prepareStatement("Select * from product order by prodId");
	  ResultSet rs = ps.executeQuery();
	   
	 while(rs.next()) {
		 System.out.println("Product Id:: "+rs.getInt(1));
		 System.out.println("Product Name:: "+rs.getString(2));
		 System.out.println("Product Desc:: "+rs.getString(3));
		 System.out.println("Product quantity:: "+rs.getInt(4));
		 System.out.println("Product price:: "+rs.getInt(5));
	 }
	 ps.close();
	 rs.close();
	 con.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
}
 
@Override
public void buyProduct() {
	 
	try {
		  
		Scanner sc=new Scanner(System.in);
		con= myDbConnection.getConnectionDetails();
		 PreparedStatement ps = con.prepareStatement("Select * from product where prodId=?");
		   
		    String keepShopping = "y";
			String viewCart = "y";
			do {
				System.out.println("Enter the product Id to buy the product>> ");

				this.id = sc.nextInt();
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					System.out.println("Enter the quantity>> ");
					this.quantity = sc.nextInt();
					this.total += this.quantity * rs.getInt("price");
                    System.out.print("Continue shopping (y/n)? ");
					keepShopping = sc.next();
					contents += rs.getString("prodName") + "\t\t\t" + this.quantity + "\t\t\t" + rs.getFloat("price") + "\n";
				}
			} while (keepShopping.equals("y"));
			
			System.out.println(contents);
			System.out.println("Your cart total is : " + this.total + " rs.");
			
			System.out.println("Do you want to view cart (y/n)?");
			viewCart = sc.next();
			if (viewCart.equals("y")) {
				viewCart();
			} 
			con.close();
			ps.close();
		
 } catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void viewCart() {
	
    System.out.println("Product added into the cart successfully!!!");
	System.out.println("Cart details >> ");
	System.out.println("\nItem\t\t\tQuantity\tPrice\t\n");
	System.out.println(contents);
	System.out.println("======================================");
	System.out.println("Your cart total is : " + this.total + " rs.");
}

@Override
public void addToCart(){
	
	Scanner input = new Scanner(System.in);
	System.out.println("Please Confirm User Name : ");
	String uname = input.next();

	System.out.println("Enter number of product you want to add to Cart : ");
	int count = input.nextInt();
 try {
		 con= myDbConnection.getConnectionDetails();
		 PreparedStatement ps = con.prepareStatement("insert into cart (uname,pid,quantity) values(?,?,?)");
		  
		  
		  for (int i = 1; i <= count; i++) {
				System.out.println("Enter Product Id :");
				int pid = input.nextInt();
				System.out.println("Enter Product Quantity :");
				int quantity = input.nextInt();

				ps.setString(1, uname);
				ps.setInt(2, pid);
				ps.setInt(3, quantity);

				int add = ps.executeUpdate();

				System.out.println(add + " Product added to cart Successfully...");
				System.out.println("------------------------------------");
				
			}

		  ps.close();
		  con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
 }

@Override
public void viewCartItem() {
	Scanner sc=new Scanner(System.in);
	 try {
		 con= myDbConnection.getConnectionDetails();
		PreparedStatement ps = con.prepareStatement("select * from cart where uname=?");
		System.out.println("Please Enter your User Name to View Cart :");
		String userName=sc.nextLine();
		ps.setString(1, userName);
		ResultSet result = ps.executeQuery();
		System.out.println("product Id"+"\t\t"+"Quantity");

			ResultSet rs = ps.executeQuery();
			  while(rs.next()) {
				  System.out.println(rs.getInt(1)+"\t\t\t"+rs.getInt(2));
				   
			 }
	 } catch (Exception e) {
		e.printStackTrace();
	}
	
}

@Override
public void checkPurchaseHistory() {
       Scanner sc=new Scanner(System.in);
	try {
		
		con= myDbConnection.getConnectionDetails();
		PreparedStatement ps = con.prepareStatement("select * from buyorder where userName=?");
		System.out.println("Please Enter your UserName to check your order details :");
		String userName=sc.nextLine();
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("Order Id      >> " + rs.getInt("orderid"));
			System.out.println("User Name     >> " + rs.getString("userName"));
			System.out.println("Product Id    >> " + rs.getString("productId"));
			System.out.println("Quantity      >> " + rs.getString("quantity"));
			System.out.println("Product price >> " + rs.getString("pricePerUnit"));
			System.out.println("Total Bill    >> " + rs.getString("total_price"));
			System.out.println("------------------------------------------------------------------");
			System.out.println();
		}
       
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
}
}  