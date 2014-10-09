<%@include file="header.jsp" %>
        
        <div id="tooplate_main">
        
            <div class="col_w580 float_l">
                <h2><%= message %></h2> 
                <img src="images/heart.jpg" alt="Image 01" class="image_wrapper image_fl" /><em>Welcome</em>
              <div class="cleaner h10"></div>
                <div class="cleaner"></div>
                <a class="more" href="#">More</a>
            </div>
            
            <div class="col_w280 float_r">
              <h4>User Login</h4>
                <form id="form1" name="form1" method="post" action="">
                  <table width="200" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td>Username:</td>
                      <td><input type="text" name="user" id="user" /></td>
                    </tr>
                    <tr>
                      <td>Password:</td>
                      <td><input type="text" name="pass" id="pass" /></td>
                    </tr>
                    <tr>
                      <td colspan="2" align="center"><input name="login" type="submit" value="Login" /></td>
                    </tr>
                  </table>
                  <p>&nbsp;</p>
                  <p>
                  <h4>User Register<br />
                  </h4>
                  <table width="230" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="97">Username:</td>
                      <td width="127"><input type="text" name="username" id="username" /></td>
                    </tr>
                    <tr>
                      <td>Password:</td>
                      <td><input type="text" name="password" id="password" /></td>
                    </tr>
                    <tr>
                      <td>Fullname</td>
                      <td><input type="text" name="fullname" id="fullname" /></td>
                    </tr>
                    <tr>
                      <td>Gender</td>
                      <td><input type="text" name="gender" id="gender" /></td>
                    </tr>
                    <tr>
                      <td>Age:</td>
                      <td><input type="text" name="age" id="age" /></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td><input name="register" type="submit" value="Register" id="register" /></td>
                    </tr>
                  </table>
                  <h4>&nbsp; </h4>
                  </p>
                </form>
            </div>
            
            <div class="cleaner"></div>
        </div> <!-- end of main -->
        
        <div id="tooplate_main_bottom"></div>
        <div class="cleaner"></div>
        
        <div id="tooplate_footer">
        
            Copyright © 2014 System Developed By: Habib Sharif Mahmud<a rel="nofollow" href=""></a>
            
        </div>
    </div> <!-- end of forever wrapper -->
</div> <!-- end of forever body wrapper -->

</body>
</html>