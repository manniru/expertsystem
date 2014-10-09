<%@page import="javax.servlet.*,
java.awt.EventQueue,
java.awt.event.ActionListener,
java.awt.event.ActionEvent,
java.util.Date,
java.io.*,
java.util.*,
java.sql.*"%>
<%!
String message="";
public Connection cn() {
	Connection cn = null;
	try { Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/expertsystem", "root", "");
		} catch(Exception e) { System.out.println(e); }
	return cn;
}
%>

<%
if(request.getParameter("register") != null) {
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String fullname = request.getParameter("fullname");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	
	PreparedStatement ps = cn().prepareStatement("insert into users(username, password, fullname, gender, age) VALUES(?,?,?,?,?)");
	ps.setString(1, username);
	ps.setString(2, password);
	ps.setString(3, fullname);
	ps.setString(4, gender);
	ps.setString(5, age);
	ps.executeUpdate();
	System.out.println("Record Saved");
	message = "Registration Successfull Please Login!";
}

if(request.getParameter("login") != null) {
	String user1="", pass1="", user2="", pass2="";
	user1 = request.getParameter("user");
	pass1 = request.getParameter("pass");
	
	
	
	try {
		ResultSet rs = cn().createStatement().executeQuery("SELECT * FROM users WHERE username='"+user1+"' AND password='"+pass1+"'"); rs.next();
		user2 = rs.getString("username");
		pass2 = rs.getString("password");
		
		session.setAttribute("username", user1);
		session.setAttribute("password", pass1);
		
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "main.jsp"); 
		
		
	} catch(Exception e) {
		System.out.println(e);
		message = "Invalid Username or Password!";
}
	
	

}


%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Text</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/tooplate_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.nivo.slider.js" type="text/javascript"></script>

<script type="text/javascript">
$(window).load(function() {
	$('#slider').nivoSlider({
		effect:'random',
		slices:15,
		animSpeed:500,
		pauseTime:3000,
		startSlide:0, //Set starting Slide (0 index)
		directionNav:false,
		directionNavHide:false, //Only show on hover
		controlNav:false, //1,2,3...
		controlNavThumbs:false, //Use thumbnails for Control Nav
		pauseOnHover:true, //Stop animation while hovering
		manualAdvance:false, //Force manual transitions
		captionOpacity:0.8, //Universal caption opacity
		beforeChange: function(){},
		afterChange: function(){},
		slideshowEnd: function(){} //Triggers after all slides have been shown
	});
});
</script>

</head>
<body>
<div id="tooplate_body_wrapper">
    <div id="tooplate_wrapper">
            
        <div id="tooplate_header">
            <div id="site_title">
            	<h1><a rel="nofollow" href="">Expert System</a></h1>
            </div><!-- end of tooplate_menu -->
        </div> <!-- end of forever header -->
        
        <div id="tooplate_main_top"></div>
        <div id="tooplate_middle">
            <div id="slider">
               	<a href="#"><img src="images/slideshow/01.jpg" alt="Slide 01" title="Expert System" /></a>            
                <a href="#"><img src="images/slideshow/02.jpg" alt="Slide 02" title="" /></a>
                <a href="#"><img src="images/slideshow/03.jpg" alt="Slide 03" title="" /></a>
                <a href="#"><img src="images/slideshow/04.jpg" alt="Slide 04" title="" /></a>
                <a href="#"><img src="images/slideshow/05.jpg" alt="Slide 05" title="" /></a>                
            </div>	
        </div>