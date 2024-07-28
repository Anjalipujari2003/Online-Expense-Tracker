<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
 <%@page import="com.dao.ExpenseDao" %>
  <%@page import="com.db.HibernateUtil" %>
    <%@page import="com.entity.Expense" %>
  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<%@include file="../Components/all_css.jsp" %>

</head>
<body>
<c:if test="${empty loginuser }">
	<c:redirect url="../login.jsp"></c:redirect>
</c:if>
<%

int id=Integer.parseInt(request.getParameter("id"));
ExpenseDao dao=new ExpenseDao(HibernateUtil.getSessionFactory());
Expense ex=dao.getExpenseById(id);
%>

<%@include file="../Components/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-4 offset-md-4">
		<div class="card shadow" style="margin-top:20px">
		<div class="card-header text-center">
		<p class="fs-3">Edit Expense</p>
		 
		 
		</div>
		<div class="card-body">
		<form action="../updateExpense" method="post">
			<div class="mb-3">
			<label>Title:</label>
			<input type="text" name="title" class="form-control" value="<%=ex.getTitle() %>">
			</div>
			<div class="mb-3">
			<label>Date:</label>
			<input type="date" name="date" class="form-control" value="<%=ex.getDate() %>">
			</div>
			<div class="mb-3">
			<label>Description:</label>
			<input type="text" name="description" class="form-control" value="<%=ex.getDescription() %>">
			</div>
			<div class="mb-3">
			<label>Price:</label>
			<input type="number" name="price" class="form-control" value="<%=ex.getPrice() %>">
			</div>
			<input type="hidden" name="id" value="<%=ex.getId()%>">
			
			<button class="btn btn-primary col-md-12">Update</button>
		
		</form>
		</div>
		</div>
	</div>
</div>
</div>
</body>
</html>