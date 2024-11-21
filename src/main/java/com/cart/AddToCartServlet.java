package com.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Library.LibraryDBUtil;




@WebServlet("/addtocarts")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		      
		 // Retrieve the song song_id
		       int song_id = Integer.parseInt(request.getParameter("songid"));
		       
		       double sum;
		       
		       boolean isTrue;
		       
		 // Insert the music item into the cart
		       isTrue = LibraryDBUtil.insertmusic(song_id, 1);
		       
		       if(isTrue == true) {
		    	   
		  // Calculate the total price of items in the cart
		          sum = com.Library.LibraryDBUtil.calculateTotalPrice();
					
		  // Set the total price as an attribute 	
		    	  request.setAttribute("totalPrice", sum);
				
		  // Retrieve the updated music list in the cart  	
				  List<Cart> musicList = LibraryDBUtil.getMusicList(song_id);
			   	  request.setAttribute("musicList", musicList);
				
				
		  // Retrieve the updated music list in the cart		
		    	   RequestDispatcher dis = request.getRequestDispatcher("cart.jsp");
		    	   dis.forward(request,response);
		       } else {
		    	   RequestDispatcher dis1 = request.getRequestDispatcher("unsuccess.jsp");
		    	   dis1.forward(request,response);
		       }
		
	
	
	
	}



	
	}
	
		         
	
	  
	
	
	
		  
		  

