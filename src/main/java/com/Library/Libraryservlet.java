
package com.Library;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/MusicLibraryServlet")
public class Libraryservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
    	List<Library> musicList = LibraryDBUtil.getMusic();
        request.setAttribute("musicList", musicList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("M_Library.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
  