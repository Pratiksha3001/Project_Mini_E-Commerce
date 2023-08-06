package com.ecom.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.resource.myDbConnection;

public class GuestInfoImpl implements GuestInfo {
	Connection con=null;
	@Override
	public void viewProductItem() {
		 try {
			
			 con= myDbConnection.getConnectionDetails();
			 PreparedStatement ps = con.prepareStatement("Select * from product");
			  ResultSet rs = ps.executeQuery();
			   
			 while(rs.next()) {
				 System.out.println("Product Id:: "+rs.getInt(1));
				 System.out.println("Product Name:: "+rs.getString(2));
				 System.out.println("Product Desc:: "+rs.getString(3));
				 System.out.println("Product quantity:: "+rs.getInt(4));
				 System.out.println("Product price:: "+rs.getInt(5));
				 System.out.println("======================================");
			 }
			 
             System.out.println();
        System.out.println("Note : Guest can only view Product. \n      "
        		+ "To buy product please get Register \n    and login to place your order");
			 ps.close();
			 rs.close();
			 con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

 

}
