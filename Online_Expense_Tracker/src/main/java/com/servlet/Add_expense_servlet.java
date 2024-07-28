package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

/**
 * Servlet implementation class Add_expense_servlet
 */
@WebServlet("/saveExpense")
public class Add_expense_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_expense_servlet() {
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
		
		String title=request.getParameter("title");
		String date=request.getParameter("date");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginuser");
		
		
		
		Expense ex=new Expense(title,date,description,price,user);
		ExpenseDao dao=new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveExpense(ex);
		if(f) {
			session.setAttribute("msg", "Successfully Added!");
			//System.out.println("Successfully registered!");
			response.sendRedirect("user/add_expense.jsp");
		}
		else {
			session.setAttribute("msg", "Something wrong on server");

			//System.out.println("Something wrong on server");
			response.sendRedirect("user/add_expense.jsp");

		}
		
	}

}
