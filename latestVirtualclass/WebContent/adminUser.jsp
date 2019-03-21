<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <title>admin</title>
<head>
<link href="css\styles_table_new.css" rel="stylesheet">
<script src="tables.js"></script>
 <link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="simple-line-icons/css/simple-line-icons.css">
<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet"> 
<link href="css/flexslider.css" rel="stylesheet" /> 
<link href="css/style1.css" rel="stylesheet" />
  <style>
 #footer  {
       color: #956836;
       font-size: 13px;
       line-height: 24px;
       width: 960px;
       margin: 0 auto;
       text-align: center;
}
 </style>
</head>
<body>
<div id="wrapper" class="home-page">
	<!-- start header -->
	<header>
        
		
<div class="navbar-wrapper">
            <div class="container-fluid">
                <nav class="navbar navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            </button>
                  
                            
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
						
						  <ul class="nav navbar-nav">
                        <li><a href="adminHome.jsp">Home</a></li> 
						<li><a href="${pageContext.request.contextPath}/adminDatabase">Manage Users</a></li>  
						
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
							   <li><a>Hi,${userUserName }</a></li>
                    </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
		
	</header>
	</div><br><br><br>
 <div id="wrapper3">
  <h1>Manage Users</h1>
  
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th><span>UserName</span></th>
        <th><span>Password</span></th>
        <th><span>Name</span></th>
        <th><span>Phone Number</span></th>
        <th><span>Branch</span></th>
        <th><span>Role</span></th>
       <th><span>Delete</span></th>
             </tr>
    </thead>
    <tbody>
        <c:forEach items="${userList}" var="user">
			<tr>
				<td><span>${user.userName}</span></td>
				
				<td><span>${user.password}</span></td>
				<td><span>${user.name}</span></td>
				<td><span>${user.phoneNo}</span></td>
				<td><span>${user.branch}</span></td>
				<td><span>${user.role}</span></td>
			<td><span><a href="deleteUser?userName=${user.userName}">Delete User</a></span></td>
			
			</tr>
		</c:forEach>
   
    </tbody>
  </table>
   <a href="addUser.jsp">Add User</a>   
   
 </div> 
  <div id="footer">
		
		<h4 align="center">
		Copyright &copy;
		<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %>
		
			All rights reserved &reg;
		</h4>
	</div>
</body>
</html>