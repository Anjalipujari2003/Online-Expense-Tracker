	
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>	
 
<nav class="navbar navbar-expand-lg bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><b><i class="fa-solid fa-money-bill"></i>Expense Tracker</b></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" >
       <!--   <li class="nav-item"  >
          <a class="nav-link " aria-current="page" href="../index.jsp"><i class="fa-solid fa-house"></i></a></li>-->
          
         <c:if test="${not empty loginuser }">
                   <li class="nav-item" style="margin-left:-700px">
                  <a class="nav-link" href="add_expense.jsp"><i class="fa-solid fa-plus" style="margin-right:5px"></i>Add Expense</a>
       			  </li>
         		 <li class="nav-item">
          		<a class="nav-link " href="view_expense.jsp" ><i class="fa-solid fa-eye" style="margin-right:5px"></i>view Expense</a>
       			 </li>
       			 <li class="nav-item"  >
          <a class="nav-link " aria-current="page" href="user/home.jsp" style="border:none"><i class="fa-solid fa-house"></i></a></li>
        <li class="nav-item">
                  
          <li class="nav-item" style="margin-left:450px">
          <a class="nav-link" style="text-decoration:none;color:black;margin-right:10px;border:none" href="#"><i class="fa-solid fa-user" style="margin-right:5px"></i>${loginuser.fullname}</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="../logout" ><i class="fa-solid fa-right-from-bracket"></i>Logout</a>
        </li>
        
        </c:if>
        <c:if test="${empty loginuser }">
          <li class="nav-item"  >
          <a class="nav-link " aria-current="page" href="index.jsp" style="border:none"><i class="fa-solid fa-house"></i></a></li>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Login</a>
        </li>
         <li class="nav-item">
          <a class="navbar-brand1" href="#">Control your expenses better than your competition!</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link " href="Register.jsp" >Register</a>
        </li>
        </c:if>
      </ul>
      
    </div>
  </div>
</nav>

