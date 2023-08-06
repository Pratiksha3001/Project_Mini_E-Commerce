package com.ecom.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db.resource.myDbConnection;
import com.ecom.user.UserInfoImpl;

public class buyOrder {

	Connection con=null;
	 

		public int getPrice(int productId) {
			 int price = 0;
			try {
				con= myDbConnection.getConnectionDetails();
				 PreparedStatement ps = con.prepareStatement("select price from product where prodId=?");
				ps.setInt(1, productId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					price = rs.getInt("price");
					 System.out.println("------------------------------------------------------------------");
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}  
			 return price;

}
		
		public String getProductName(int productId) {
			 
			String productName = null;
			try {
				con= myDbConnection.getConnectionDetails();
				 PreparedStatement ps = con.prepareStatement("select prodName from product where prodId=?");
				ps.setInt(1, productId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					productName = rs.getString("prodName");
					System.out.println();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return productName;
		}	
		
		public List<Product> getBill() {
			 
			Scanner sc = new Scanner(System.in);
			ArrayList<Product> list = new ArrayList<>();
			System.out.println("Enter User Name :");
			String userName = sc.next();
			System.out.println("Enter number of Product's you want to buy :");
			int count = sc.nextInt();
			for (int i = 1; i <= count; i++) {
				System.out.println("Enter Product Id : ");
				int productId = sc.nextInt();
				String productName = this.getProductName(productId);
				System.out.println("Enter Quantity:");
				int quantity = sc.nextInt();
				int price = this.getPrice(productId);
				int totalPrice = quantity * price;
				list.add(new Product(productId, productName, quantity, price, totalPrice));
				try {
					con= myDbConnection.getConnectionDetails();
					 PreparedStatement ps = con.prepareStatement("insert into buyorder(userName,productId,quantity,pricePerUnit,total_Price) "
					 		+ "values(?,?,?,?,?)");
					    ps.setString(1, userName);
						ps.setInt(2, productId);
						ps.setInt(3, quantity);
						ps.setInt(4, price);
						ps.setInt(5, totalPrice);
						int added = ps.executeUpdate();
				 
						System.out.println(added+" product added to buy list");
				} catch (Exception e) {
					e.printStackTrace();
				}  

			}
			System.out.println("If you Want bill then press \"Y\" or enter anykey to view product ");
			String bill = sc.next();
			if (bill.equalsIgnoreCase("y")) {
				System.out.println("Customer Name :" + userName);
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.print("\nProduct ID\t\tName\t\tQuantity\tRate\t\tTotal Price\n");
				System.out.println(
						"--------------------------------------------------------------------------------------------");
				for (Product p : list) {
					System.out.println(p);
				}
			} else {
				UserInfoImpl info = new UserInfoImpl();
				 info.viewProduct();
			}
			sc.close();
			return list;
		}
		 
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 