package com.ecom.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.db.resource.myDbConnection;
import com.ecom.admin.AdminInfo;
import com.ecom.admin.AdminInfoImpl;
import com.ecom.guest.GuestInfo;
import com.ecom.guest.GuestInfoImpl;
import com.ecom.user.User;
import com.ecom.user.UserInfo;
import com.ecom.user.UserInfoImpl;

 

public class Test {
	Connection con=null;
	UserInfo userinfo=null;
	public void getEcomOperation() { 
		 
		System.out.println("****Welcome to E-Commerce Application****");
		
		  
		 
		 System.out.println("1.New user");
		 System.out.println("2.Already Registered User/Admin/Guest");
		  System.out.println("Enter Your Choice here!!!");
		 Scanner scan=new Scanner(System.in);
		  int select=scan.nextInt();
		   
		  if(select==1) {
			  System.out.println("You are New User !!!");
			   System.out.println("Register here first!!!");
			   UserInfoImpl input=new UserInfoImpl();
			    User user= input.getUserInput();
			    System.out.println(user);
			     
		       
		  }else if(select==2) {
			  Scanner scanner=new Scanner(System.in); 
		 System.out.println("Enter the UserName");
		 String name=scanner.nextLine();
		 System.out.println("Enter the UserPassword");
		 String password=scanner.nextLine();
	    String query="select userName,UserPassword,userRole from user";
		  try {
			   con= myDbConnection.getConnectionDetails();
				 PreparedStatement ps = con.prepareStatement(query);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
					  String nameDb=rs.getString("userName");
					 String passDb=rs.getString("UserPassword");
					 String roleDb=rs.getString("userRole");
			 
					  if(name.equals(nameDb)&& password.equals(passDb)&&roleDb.equals("User")) {
						 System.out.println("You are User!!!");
						 
						  
						 System.out.println("        1. If you are already registed then login from here       ");
						 System.out.println("        2. If you want to View all Product Details    ");
						 System.out.println("        3. Buy Product          ");
						 System.out.println("        4. Product Item Add to Cart           ");
						 System.out.println("        5. Do you want to view cart           ");
						 System.out.println("        6. Display All User Details           ");
						 System.out.println("        7.  Check Purchase Items Details          ");
							System.out.println("Enter your choice::");
							int choice=scanner.nextInt();
							 
							
							switch(choice){
							 case 1: System.out.println("Checking User Login");
							      userinfo=new UserInfoImpl();
							       userinfo.userLogin();
						           break;
						           
							case 2: System.out.println("Display all Products in Sorting order");
							       userinfo=new UserInfoImpl(); 
							       userinfo.viewProduct();
					               break;
					               
							case 3: System.out.println("Do you want to buy product");
						             userinfo=new UserInfoImpl(); 
						             userinfo.buyProduct();
						              break;
						              
							case 4:System.out.println("Add to Cart");
			                       userinfo=new UserInfoImpl();
			                       userinfo.addToCart();
			                       break;
					          
							case 5: System.out.println("view cart Item");
				                      userinfo=new UserInfoImpl(); 
				                      userinfo.viewCartItem();
				                      break;
				                      
							case 6:System.out.println("Display User Details");
						            userinfo=new UserInfoImpl();
						            userinfo.displayUser();
						            break;
						            
							case 7:System.out.println("Displaying purchase History Details");
				                  userinfo=new UserInfoImpl();
				                   userinfo.checkPurchaseHistory();
				                  break;
							 
							}
					 }
					 else if(name.equals(nameDb)&& password.equals(passDb)&&roleDb.equals("Admin")){
						  System.out.println("You are Admin!!!");
						  
						     System.out.println("        1.  Add product                 ");
							 System.out.println("        2.  Display totalbill amount                  ");
							 System.out.println("        3.  Check User history               ");
							 System.out.println("        4.   Check product quantity             ");
							 System.out.println("        5.  Checking user registered     ");
							 System.out.println("        6.  Display all Amount    ");
							 
							 int choice=scanner.nextInt();
							AdminInfo admininfo=null;
							
                          switch(choice) {
							  
                          case 1: System.out.println("Adding Product");
          	                      admininfo=new AdminInfoImpl(); 
          	                      admininfo.addProduct();
                                  break;
                                  
                          case 2: System.out.println("Displaying totalbill amount");
   	                           admininfo=new AdminInfoImpl(); 
   	                           admininfo.totalBill();
                                   break;
							   
                          case 3: System.out.println("Checking user History");
                                  admininfo=new AdminInfoImpl(); 
                                  admininfo.checkUserHistory();
                                  break;
                                  
                          case 4: System.out.println("Checking Product quantity");
                                  admininfo=new AdminInfoImpl(); 
                                  admininfo.checkQuantity();
                                  break;
                                  
                          case 5: System.out.println("Checking user is already registered");
                                  admininfo=new AdminInfoImpl(); 
                                  admininfo.checkRegisterUser();
                                  break;
                          case 6: System.out.println("Display all Amount");
                                    admininfo=new AdminInfoImpl(); 
                                    admininfo.displayAmount();
                                     break;
							 
							}
					 }
					 
					 else if(name.equals(nameDb)&& password.equals(passDb)&&roleDb.equals("Guest")){
							  System.out.println("You are Guest!!!");
							   System.out.println("You can only View Product Details");
	          	                     GuestInfo guestinfo=null;
	          	                    guestinfo=new GuestInfoImpl(); 
	          	                    guestinfo.viewProductItem();
	               }
					 
				 }
			ps.close();
			rs.close();
			con.close();
		  }catch (Exception e) {
			 e.printStackTrace();
		}
		  }
 		
}	
		
  public static void main(String[] args) {	
			Test test=new Test();
			test.getEcomOperation();
		 
		}

	 
}