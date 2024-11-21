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


@WebServlet("/DeleteSongServlet")
public class DeleteSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// Retrieve the song_id parameter
		String song_id = request.getParameter("song_id");
		int songids = Integer.parseInt(song_id);
		
		  boolean isTrue;
		
		 
	// Attempt to delete the song from the cart
		isTrue = LibraryDBUtil.deleteSong(songids, 1);
		
		if(isTrue == true) {
			
			
	// If the deletion is successful, retrieve the updated music list in the cart
			List<Cart> musicList = LibraryDBUtil.getMusicList(songids);
			request.setAttribute("musicList", musicList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			
			
	// If deletion is not successful, retrieve the music list
			List<Cart> musicList = LibraryDBUtil.getMusicList(songids);
			request.setAttribute("musicList", musicList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("M_Library.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
