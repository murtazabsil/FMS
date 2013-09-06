package com.bluestar.fms.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluestar.fms.bso.LoginBSO;
import com.bluestar.fms.bso.LoginBSOImpl;
import com.bluestar.fms.vo.AuthorizeVO;

public class LoginServlet extends HttpServlet{



	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response){
	
		LoginBSO loginBSO = new LoginBSOImpl();
		debugLogger(" UserId:::::::::::"+request.getParameter("UserID"));
		debugLogger("----- LoginServlet -----");
		
		RequestDispatcher view = null;
		try {

			AuthorizeVO authorizeVO = loginBSO.validateUser(request);		
		request.setAttribute("authorize", authorizeVO);
			view = request.getRequestDispatcher("Validate.jsp");
			view.forward(request, response);

		} catch (ServletException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();
	
		}

	}


	public static void debugLogger(String loggerString){
        System.out.println("### LoginServlet: "+loggerString);
    }
    

    public static void debugLogger(Exception e){
        for(StackTraceElement element : e.getStackTrace()){
            debugLogger("" + element.toString());   
        }    
    }
        

}
