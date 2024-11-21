

package com.Library;


import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cart.Cart;



	    public class LibraryDBUtil {
		static double sum=0;
	    private static Connection con = null;
	    private static java.sql.Statement stmt = null;
	    private static ResultSet rs = null;
	
	    
	 // Retrieve a list of music items from the library
	   public static List<Library> getMusic( ){
		   

		  ArrayList<Library> lb = new ArrayList<>();
		   
		   try {
			    
			   con = DBConnect.getConnection();
			   stmt =  con.createStatement();
			   String sql = "select * from library ";
			   rs = stmt.executeQuery(sql);
			   
			   while(rs.next()) {
				   int song_id = rs.getInt(1);
				   String song_name = rs.getString(2);
				   String artist_name = rs.getString(3);
				   double price = rs.getDouble(4);
				   String images = rs.getString(5);
				   
				   Library l = new Library(song_id,song_name,artist_name,price,images);
				   lb.add(l);
				   
				    
			   }
			   
 		   }catch(Exception e) {
			       e.printStackTrace();
		   }
		return lb;
	   }
	   
	   
	   
	   
	// Insert a music item into the cart	   
	       public static boolean insertmusic(int song_id, int i) {
		   boolean isSuccess = false;
		   
		   
		   try {
			     con = DBConnect.getConnection();
			     stmt = con.createStatement();
			     String sql = "insert into cart values('"+song_id+"','"+i+"','low')";
			     int rs = stmt.executeUpdate(sql);
			     if(rs > 0) {
				   isSuccess = true;
				   }
			     else       {
				   isSuccess = false;
			       }
			     
		   }catch(Exception e) {
			   e.printStackTrace();
		           }
		   return isSuccess;
	   }
	   
	       
	       
	// Retrieve the list of music items in the cart   
	   public static List<Cart> getMusicList(int song_id) {

	       
       ArrayList<Cart> ct = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql ="select *from cart_song_view3 where userid=1" ;
		    rs = stmt.executeQuery(sql);
		   
			while(rs.next()) {
				int song_id1 = rs.getInt(1);
			    String song_name = rs.getString(2);
			    double price  = rs.getDouble(3);
			   
			    Cart cr = new Cart ( song_id1 ,song_name,price);
			    ct.add(cr);
		        }
			
		   }catch(Exception e) {
			    e.printStackTrace();
		        }
		
		
		     return ct; 
	         }
		
	   
	   
	   
	// Delete a music item from the cart	
	   public static boolean deleteSong(int song_id, int userid) {
	   System.out.println("database"+song_id);
		   
	   boolean isSuccess = false;
	   
		   try {
			   con = DBConnect.getConnection();
			   stmt = con.createStatement();
			   String sql = "delete from cart where song_id = '"+song_id+"' and userid = '"+userid+"'";

			   int r = stmt.executeUpdate(sql);
			   
			   
			if(r> 0) {
				   isSuccess = true;
			        }
			 else {
				   isSuccess = false;
			     }
			
			
	            }catch (Exception e) {
	               e.printStackTrace();
                       } 
		   
	   return isSuccess;
	   
	   }	    
	   
	   
	   
	   
	 // Calculate the total price of music items in the cart   
	   public static double calculateTotalPrice( ) {
		   	   
		  sum =0;
		  
		  try {
			  stmt = con.createStatement();
			  con = DBConnect.getConnection();
			  String sql ="select * from cart_song_view3 where userid=1" ;
		      rs = stmt.executeQuery(sql);
				   
			        
			 while(rs.next()) {
				   double price  = rs.getDouble(3);
                   sum = sum + price; 
				   
                         }
			} catch (SQLException e) {
			        e.printStackTrace();
				          }
			  
	   return sum;
	
	   }
	   
	   
	   
	   
	// Update the quality of a music item in the cart to "Low"
	   
	   public static boolean updateLow(int song_id,int i){
		 boolean isSuccess = false;
		   
		 try {
			   con = DBConnect.getConnection();
			   stmt = con.createStatement();
			   String sql = "update  cart set quality='low' where userid ='"+i+"'and song_id='"+song_id+"'";
			   int rs = stmt.executeUpdate(sql);
			   
			   if(rs > 0) {
				   isSuccess = true;
				   
			   }else {
				   isSuccess = false;
			       }
			   
		     }catch(Exception e) {
			   e.printStackTrace();
		   }
		 
		 return isSuccess;
	   }
	   
	
	   
	   
	 // Update the quality of a music item in the cart to "High"
	   public static boolean updateHigh(int song_id,int i){
		   
	       boolean isSuccess = false;
		   
		   try {
			  
			   con = DBConnect.getConnection();
			   stmt = con.createStatement();
			   String sql = "update  cart set quality='high' where userid = '"+i+"'and song_id='"+song_id+"'" ;
			   int rs = stmt.executeUpdate(sql);
			   
			   if(rs > 0) {
				   isSuccess = true;
				    }
			   
			   else {
				   isSuccess = false;
			        }
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		           }
		   
		   
		   return isSuccess;

	}
	   
	   
	}
	   
	  
	  
	   
	
	


