package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

/**
 * Servlet implementation class Register_servlet
 */
@WebServlet("/userRegister")
public class Register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String about=request.getParameter("about");
		
		User u=new User(fullname,email,password,about);
		//System.out.println(u);
		UserDao dao=new UserDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveuser(u);
		
		HttpSession session=request.getSession();
		
		if(f) {
			session.setAttribute("msg", "Successfully registered!");
			//System.out.println("Successfully registered!");
			response.sendRedirect("Register.jsp");
		}
		else {
			session.setAttribute("msg", "Something wrong on server");

			//System.out.println("Something wrong on server");
		}

		


		
	}

}
