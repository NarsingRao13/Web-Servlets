<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web-Task</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Open Sans'
	rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Noto Serif'
	rel='stylesheet'>
<script src="https://use.fontawesome.com/3c260f3a8a.js"></script>
<link rel="stylesheet" type="text/css" href="FooterStyleSheet.css">
<link rel="stylesheet" type="text/css" href="HeaderStyleSheet.css">
<link rel="stylesheet" type="text/css" href="HomepagsStyleSheet.css">
</head>
<body>
	<script>
		$(document).ready(function() {
			$("#account").click(function() {
				$(this).css('background-color', '##7e4a92');//click to change
				$(".container").slideToggle("slow");
			});
		});

		$(document).ready(function() {
			$("#subnav").hover(function() {
				//$(this).css('background-color', '##7e4a92');//click to change
				$(".nav").slideToggle("slow");
			});
		});
		

	</script>
	
	<script type="text/javascript">
		var mgs = '<%=session.getAttribute("loginState")%>';
		if(mgs == "true"){
			alert("Loged In Successfully!!");
		}
		else if(mgs == "false"){
			alert("Loged Out Successfully!!");
		}
	</script>

	<%
		String s ="";
		///HttpSession
		HttpSession httpSession = request.getSession();
		s = (String) httpSession.getAttribute("UserName");
		if (s == null)
			s = "";
		
		System.out.println(httpSession.getAttribute("UserName")+ " ; "+httpSession.getAttribute("loginState"));
		//Cookies
		/*Cookie ck[] = request.getCookies();
		System.out.println(ck[0]);
		if(ck[0] != null){
			 s  = ck[0].getValue();
		//System.out.println(ck[0].getName()+" , "+ck[0].getValue());
		if (s == null)
			s = "";
		}*/
	%>

	<header>
		<div id="headerpart">
			<div id="header-first-part" class="headers">
				<div id="header-title">
					B<span style="font-size: medium;">2</span>C Acclerator
				</div>
				<div class="header-one-right"><a class = "a2" href="Logout.jsp">SIGN OUT</a></div>
				<div class="header-one-right" id="account">MY ACCOUNT</div>
				<div class="header-one-right">WELCOME <span><%=s%></span></div>
			</div>
			<div class="container" style="margin: 0px; padding: 0px;">
				<div class="myaccount-details">
					<div class="myaccount-details-data" >
					<a href="Registration.html" class = "a1">Register</a></div>
					<div class="myaccount-details-data">Password</div>
					<div class="myaccount-details-data">Saved Carts</div>
					<div class="myaccount-details-data">Support Tickets</div>
				</div>

				<div class="myaccount-details">
					<div class="myaccount-details-data">
					<a href="Login.html" class = "a1">Login</a></div>
					
					<div class="myaccount-details-data">Order History</div>
					<div class="myaccount-details-data">Consent Management</div>
					<div class="myaccount-details-data">Returns History</div>
				</div>

				<div class="myaccount-details">
					<div class="myaccount-details-data">Payment Details</div>
					<div class="myaccount-details-data">Address Book</div>
					<div class="myaccount-details-data">Close Account</div>
					<div class="myaccount-details-data">Dummey Details</div>
				</div>
			</div>
			<hr style="clear: both;">
			<div id="header-second-part" class="headers">
				<input type="text" name="search" placeholder="I'm looking for">
				<div class="header-two-right"
					style="padding-right: 0px; padding-bottom: 10px;">
					<span style="font-size: small;">(21 ITEMS) </span> <span
						style="font-size: medium; font-weight: bold;">£697.38</span> <sup>
						<i class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i>
					</sup>
				</div>
				<div class="header-vertical-line"></div>
				<div class="header-two-right">
					<i class="fa fa-list-alt fa-2x" aria-hidden="true"></i>
				</div>
				<div class="header-vertical-line"></div>
				<div class="header-two-right">
					<i class="fa fa-map-marker fa-2x" aria-hidden="true"></i>
				</div>
				<div class="header-vertical-line"></div>
			</div>
			<div id="header-third-part">
				<div id="header-third-part-inner">
					<div class="header-last-left">BRANDS</div>
					<div class="header-last-left">STREETWEAR</div>
					<div class="header-last-left">SNOW</div>
					<div class="header-last-left">ACCESSORIES</div>
					<div class="header-last-left" id="subnav">
						YOUTH <i class="fa fa-caret-down"
							style="background-color: #9169a0;"></i>
					</div>
				</div>
			</div>

		</div>
		<div class="nav">
			<div class="subnav-content">
				<div class="subnav-content-data" style="font-size: medium;">BOARDSHORTS</div>
				<div class="subnav-content-data">BILLABONG</div>
				<div class="subnav-content-data">69 SLAM</div>
				<div class="subnav-content-data">QUIKSILVER</div>
				<div class="subnav-content-data">VOLCOM</div>
			</div>
			<div class="subnav-content">
				<div class="subnav-content-data" style="font-size: medium;">T-SHIRTS</div>
				<div class="subnav-content-data">BILLABONG</div>
				<div class="subnav-content-data">BLUE TOMATO</div>
				<div class="subnav-content-data">BURTON</div>
				<div class="subnav-content-data">DC</div>
				<div class="subnav-content-data">QUIKSILVER</div>
				<div class="subnav-content-data">BROWSE ALL></div>
			</div>
		</div>
	</header>

	<p>Welcome to Home Page</p>

	<div id="Homepage-begining">
		SAVE BIG ON SELECT STREETWEAR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button id="shop-now-button">SHOP NOW</button>
	</div>
	<footer style="background-color: #362D92;">
		<div class="footer-body">
			<div style="color: #F19D67; padding-top: 10px; font-size: 15px;">
				<div
					style="float: left; padding-left: 15px; font-family: Noto Serif; font-style: normal; font-weight: normal;">
					<p style="font-size: 30px;">Find the right solution to power
						your idea</p>
				</div>
				<div
					style="float: right; padding-right: 10%; font-family: 'Open Sans'; font-style: normal; font-weight: lighter;">
					<p style="font-size: 30px; text-decoration: underline;">1.866.455.1655</p>
				</div>
			</div>
			<hr style="background-color: white; clear: both;">
			<br>
			<br>
			<div class="footer-secondpart">
				<div class="footer-data-left" style="padding-left: 15px;">
					<table>
						<tr>
							<th>PRODUCTS</th>
						</tr>
						<tr>
							<td>Domain Names</td>
						</tr>
						<tr>
							<td>Email</td>
						</tr>
						<tr>
							<td>Website Builde</td>
						</tr>
						<tr>
							<td>eCommerce</td>
						</tr>
						<tr>
							<td>SSL Certificates</td>
						</tr>
						<tr>
							<td>Web Hosting</td>
						</tr>
					</table>
				</div>
				<div class="footer-data-left">
					<table>
						<tr>
							<th>RESOURCES</th>
						</tr>
						<tr>
							<td>Blog</td>
						</tr>
						<tr>
							<td>Dispute Policy</td>
						</tr>
						<tr>
							<td>DMCA Notice</td>
						</tr>
					</table>
				</div>
				<div class="footer-data-left">
					<table>
						<tr>
							<th>SUPPORT</th>
						</tr>
						<tr>
							<td>Customer Service</td>
						</tr>
						<tr>
							<td>Report Ethical</td>
						</tr>
						<tr>
							<td>Hacking</td>
						</tr>
					</table>
				</div>
				<div class="footer-data-left">
					<table>
						<tr>
							<th>PARTNERSHIP</th>
						</tr>
						<tr>
							<td>Become an affiliate</td>
						</tr>
						<tr>
							<td>Become an reseller</td>
						</tr>
					</table>
				</div>
				<div class="footer-data-right">
					<table>
						<tr>
							<th>CONNECT WITH US:</th>
						</tr>
						<tr>
							<td>Follow Register.com to get your passion</td>
						</tr>
						<tr>
							<td>or business online</td>
						</tr>
						<tr>
							<td><i class="fa fa-facebook-square" aria-hidden="true"></i></td>
							<td><img class="image" alt="" src=""></td>
							<td><img class="image" alt="" src=""></td>
							<td><img class="image" alt="" src=""></td>
							<td><img class="image" alt="" src=""></td>
						</tr>
						<tr>
							<th><p></p></th>
						</tr>
						<tr>
							<th><p></p></th>
						</tr>
						<tr>
							<th>COMPANY</th>
						</tr>
						<tr>
							<td>About Us</td>
						</tr>
						<tr>
							<td>Register.com blog</td>
						</tr>
					</table>
				</div>
			</div>
			<div
				style="width: 1000px; padding-right: 15px; color: white; font-family: 'Open Sans'; font-size: 14px;">
				<img style="float: left; padding-left: 15px; padding-right: 20px;"
					alt=""
					src="https://www.register.com/content/dam/register/logos/logo.png">
				<div style="float: left; padding-right: 10px">Privacy policy</div>
				<div class="vl"></div>
				<div style="float: left; padding-right: 10px">Terms of use</div>
				<div class="vl"></div>
				<div style="float: left; padding-right: 10px">Service
					agreement</div>
				<div class="vl"></div>
				<div style="">Cookie Policy</div>
			</div>
			<br>
			<div id="footerendpara"
				style="padding-left: 15px; padding-bottom: 15px; clear: both; color: white; font-size: x-small; font-family: 'Open Sans'; font-weight: 32px;">
				Copyright© 2021 Register.com, A Web.com company. All rights
				reserved.<br> Register.com® and Web.com® are registered
				trademarks of Web.com Group, Inc. All other registered trademarks
				herein are the property of their respective owners. Call us<br>
				toll free at 1.866.455.1655 | Outside the U.S., please call
				1.902.749.2762
			</div>
		</div>

	</footer>

</body>
</html>