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
 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin</title>
 <style>
      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
     /*  @import url(http://fonts.googleapis.com/css?family=Open+Sans); */
.btn { display: inline-block; *display: inline; *zoom: 1; padding: 4px 10px 4px; margin-bottom: 0; font-size: 13px; line-height: 18px; color: #333333; text-align: center;text-shadow: 0 1px 1px rgba(255, 255, 255, 0.75); vertical-align: middle; background-color: #f5f5f5; background-image: -moz-linear-gradient(top, #ffffff, #e6e6e6); background-image: -ms-linear-gradient(top, #ffffff, #e6e6e6); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#ffffff), to(#e6e6e6)); background-image: -webkit-linear-gradient(top, #ffffff, #e6e6e6); background-image: -o-linear-gradient(top, #ffffff, #e6e6e6); background-image: linear-gradient(top, #ffffff, #e6e6e6); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0); border-color: #e6e6e6 #e6e6e6 #e6e6e6; border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25); border: 1px solid #e6e6e6; -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px; -webkit-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); -moz-box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05); cursor: pointer; *margin-left: .3em; }
.btn:hover, .btn:active, .btn.active, .btn.disabled, .btn[disabled] { background-color: #e6e6e6; }
.btn-large { padding: 9px 14px; font-size: 15px; line-height: normal; -webkit-border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px; }
.btn:hover { color: #333333; text-decoration: none; background-color: #e6e6e6; background-position: 0 -15px; -webkit-transition: background-position 0.1s linear; -moz-transition: background-position 0.1s linear; -ms-transition: background-position 0.1s linear; -o-transition: background-position 0.1s linear; transition: background-position 0.1s linear; }
.btn-primary, .btn-primary:hover { text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25); color: #ffffff; }
.btn-primary.active { color: rgba(255, 255, 255, 0.75); }
.btn-primary { background-color: #4a77d4; background-image: -moz-linear-gradient(top, #6eb6de, #4a77d4); background-image: -ms-linear-gradient(top, #6eb6de, #4a77d4); background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#6eb6de), to(#4a77d4)); background-image: -webkit-linear-gradient(top, #6eb6de, #4a77d4); background-image: -o-linear-gradient(top, #6eb6de, #4a77d4); background-image: linear-gradient(top, #6eb6de, #4a77d4); background-repeat: repeat-x; filter: progid:dximagetransform.microsoft.gradient(startColorstr=#6eb6de, endColorstr=#4a77d4, GradientType=0);  border: 1px solid #3762bc; text-shadow: 1px 1px 1px rgba(0,0,0,0.4); box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.5); }
.btn-primary:hover, .btn-primary:active, .btn-primary.active, .btn-primary.disabled, .btn-primary[disabled] { filter: none; background-color: #4a77d4; }
.btn-block { width: 100%; display:block; }

* { -webkit-box-sizing:border-box; -moz-box-sizing:border-box; -ms-box-sizing:border-box; -o-box-sizing:border-box; box-sizing:border-box; }

html { width: 100%; height:100%;}

body { 
	width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
}
#contents {
       background: #fff7db url(../images/content-border.jpg) repeat-x left bottom;
       min-height: 1080px;
       padding-bottom: 10px;
}
#contents > div {
       width: 960px;
       margin: 0 auto;
       padding-top: 50px;
}
#contents h3 {
       color: #a17b2d;
       font-size: 16px;
       font-weight: normal;
       letter-spacing: 1px;
       margin: 0
}
#contents h1 {
       color: #a17b2d;
       font-size: 16px;
       font-weight: normal;
       letter-spacing: 1px;
       margin: 0
}
#contents p {
       color: #aa9387;
       font-size: 13px;
       line-height: 24px;
       margin: 0 auto;
       padding: 0 0 24px;
       text-align: justify;
}
#contents p a {
       color: #aa9387;
}
#contents a:hover {
       color: #ce8763;
}
/** Adbox **/
#contents div#adbox {
       margin-bottom: 36px;
       padding: 0;
       text-align: center;
}
#adbox img {
       margin-bottom: 24px;
}
#adbox p {
       width: 600px;
       text-align: center;
       text-indent: 40px;
}
#footer p {
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
						<img src="images/Vc.png"  alt="Img" width="100%" height="100px">
						  <ul class="nav navbar-nav">
                        <li><a href="adminHome.jsp">Home</a></li> 
						
						<li><a href="${pageContext.request.contextPath}/adminDatabase">Manage User</a></li>  
						
				<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                   <li><a>Hi,${userUserName }</a></li>        
                    </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </div>
		
	</header>
</div><br>
	<br><br><br><br>
	<br><br>
		<div id="contents">
		<div id="adbox" class="w3-content w3-section" style="max-width:1000px" >
			<img class="mySlides" src="images/11.png" alt="Img" style="width:1000px" height="500px">
		<img class="mySlides" src="images/4.png"  alt="Img" style="width:1000px">
			<img class="mySlides" src="images/b.png"  alt="Img">
			<img class="mySlides" src="images/2.png"  alt="Img" style="width:1000px">
			<img class="mySlides" src="images/3.jpg"  alt="Img">
			<img class="mySlides" src="images/e.jpg"  alt="Img">
		
			<h4>
			Today learners want new ways to engage and collaborate. Virtual classrooms and online professional development deliver new opportunities to meet your learners where they are. Inspire and engage your learners with the easy to use online collaborative solutions they crave.	
			</h4>
		</div>
		</div>
		<script>
		var myIndex = 0;
		carousel();

		function carousel() {
		    var i;
		    var x = document.getElementsByClassName("mySlides");
		    for (i = 0; i < x.length; i++) {
		       x[i].style.display = "none";  
		    }
		    myIndex++;
		    if (myIndex > x.length) {myIndex = 1}    
		    x[myIndex-1].style.display = "block";  
		    setTimeout(carousel, 2000); // Change image every 2 seconds
		}
		
		
		
		</script>
	<div id="footer">
		
		<h4 align="center">
		Copyright &copy;
		<%= new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()) %>
		
			All rights reserved &reg;
		</h4>
	</div>
</body>
</html>