<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="simple-line-icons/css/simple-line-icons.css">
<link href="css/fancybox/jquery.fancybox.css" rel="stylesheet"> 
<link href="css/flexslider.css" rel="stylesheet" /> 
<link href="css/style1.css" rel="stylesheet" />
  <title>addUser</title>
 
<link href="css\styles_table_new.css" rel="stylesheet">
<script src="tables.js"></script>
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
					
						<li><a href="${pageContext.request.contextPath}/manageUserList">Manage User</a></li>
								<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                           <li><a>Hi,${userUserName }</a></li>
                    </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
		
	</header><br><br><br>
 <div id="wrapper3">
  <h1 align="center">ADD NEW USER</h1>
  	<form method="POST" action="addUser">
  <table id="keywords" cellspacing="0" cellpadding="0">
   

		   <h4 align="center" ><b><font color="red">${errorString5}</font></b></h4>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" required="required" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" required="required" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${product.pptlink}" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="phoneNo" value="${product.pptname}" /></td>
			</tr>
			<tr>
				<td>Branch</td>
				<td><input type="text" name="branch" value="${product.subject}" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="role" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> 
				<a href="${pageContext.request.contextPath}/manageResourceList">Cancel</a></td>
				
			</tr>
		</table>
	</form>
     

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