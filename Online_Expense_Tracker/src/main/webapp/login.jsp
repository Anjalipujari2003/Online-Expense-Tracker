<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@include file="Components/all_css.jsp" %>

</head>
<body>
<%@include file="Components/navbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<div class="card" style="margin-top:60px;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);">
			<div class="card-header"><p class="text-center fs-3">Login Here</p>
			<c:if test="${not empty msg }">
			<p class="text-center text-danger fs-4">${msg}</p>
			<c:remove var="msg"/>
			</c:if>  
			</div>
				<div class="card-body">
					
					<form action="login" method="Post">
						
						<div class="mb-3">
							<label>Email:</label>
							<input type="email" name="email" class="form-control">
						</div>
						<div class="mb-3">
							<label>Password:</label>
							<input type="password" name="password" class="form-control">
						</div>
						
						<button class="btn btn-primary col-md-12 " style="margin-bottom:20px">Login</button>
						<center>Don't have account ? <a href="Register.jsp" class="text-decoration-none">Create Account</a></center>
					</form>
				</div>

			</div>
		</div>
	</div>
</div>

</body>
</html>