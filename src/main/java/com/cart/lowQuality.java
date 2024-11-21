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


@WebServlet("/lowQuality")
public class lowQuality extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double sum =0 ;
		
		String song_id = request.getParameter("song_id");
		int songids = Integer.parseInt(song_id);
		boolean isTrue;
		isTrue = LibraryDBUtil.updateLow(songids, 1);
		
		
		
		
 // Update the quality to "High" for the specified song in the cart
		if(isTrue == true) {
			List<Cart> musicList = LibraryDBUtil.getMusicList(songids);
			request.setAttribute("musicList", musicList);
			sum = com.Library.LibraryDBUtil.calculateTotalPrice();
			
			 request.setAttribute("totalPrice", sum);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			List<Cart> musicList = LibraryDBUtil.getMusicList(songids);
			request.setAttribute("musicList", musicList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("unsuccess.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
