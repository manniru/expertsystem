<%@ page import="java.io.*,java.util.*" %>
<%!String message = ""; %>

<%
   Enumeration paramNames = request.getParameterNames();

   while(paramNames.hasMoreElements()) {
      String paramName = (String)paramNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n");
      String paramValue = request.getHeader(paramName);
      out.println("<td> " + paramValue + "</td></tr>\n");
   }
%>

<%!
/**
public String results(String op1, String op2, String op3, String op4, String op5, String op6, String op7, String op8, String op9, String op10, String op11) {
	String output = "";
	
	// (chestpain is ) and (cholestrol is very_low) and (max.heartrate is very_low) and (blood_pressure is very_low) and (bloodsugar is low) and (oldpeak is very_low) then (result is healthy)(precautions is Exercise)
	
	if(op1.equals("veryLow") && op2.equals("veryLow")) {
		output = "<font color='#FF0000'>You have High Risk Heart Attacks</font>";
	}
	
	if(op1.equals("very high") && op2.equals("very high")) {
		output = "<font color='#FF0000'>You have High Risk Heart Attacks</font>";
	}
	
	if(op1.equals("very low") && op2.equals("very low")) {
		output = "<font color='#0000CC'>You are in Good Health</font>";
	}
	
	if(op1.equals("very high") && op2.equals("very low")) {
		output = "<font color='#009933'>Try to be taken medicine, and get enough sleep</font>";
	}
	
	if(op1.equals("very low") && op2.equals("very high")) {
		output = "<font color='#009933'>dont be thinking to much, and get enough sleep</font>";
	}
	
	return output;

}
*/
%>
<%
/**
if(request.getParameter("submit") != null) {
	String op1 = request.getParameter("op1");
	String op2 = request.getParameter("op2");
	String op3 = request.getParameter("op3");
	String op4 = request.getParameter("op4");
	String op5 = request.getParameter("op5");
	String op6 = request.getParameter("op6");
	String op7 = request.getParameter("op7");
	String op8 = request.getParameter("op8");
	String op9 = request.getParameter("op9");
	String op10 = request.getParameter("op10");
	String op11 = request.getParameter("op11");
	
	message = results(op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11);
		
}
*/
%>
<title>Expert System Algorithms</title>
<form id="form1" name="form1" method="post">
<table width="886" border="1" cellspacing="1" cellpadding="0" align="center">
  <tr>
    <td colspan="3" align="center"><h1>Application of Data Mining in Medicine:<br /> an Expert System to predict heart disease</h1></td>
  </tr>
  <tr>
    <td colspan="3" align="center"><h1><%= message %></font></h1></td>
  </tr>
  <tr>
    <td width="448">&nbsp;</td>
    <td width="448"><table width="100%" border="1" cellspacing="1" cellpadding="0">
      <tr>
        <td width="64%"><label for="select4">Chest Pain:</label></td>
        <td width="36%"><select name="op1">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
          </select></td>
        </tr>
      <tr>
        <td><label for="select5">Blood Pressure:</label></td>
        <td><select name="op2" id="op2">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
          </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'cholesterol,']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">cholesterol,</span></td>
        <td><select name="op3" id="op3">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'resting blood sugar']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">resting blood sugar</span></td>
        <td><select name="op4" id="op4">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'resting maximum heart rate']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">resting maximum heart rate</span></td>
        <td><select name="op5" id="op5">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td>Gender</td>
        <td><select name="op6" id="op6">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'electrocardiography (ECG)']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">Electrocardiography (ECG)</span></td>
        <td><select name="op7" id="op7">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'exercise']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">Exercise</span></td>
        <td><select name="op8" id="op8">
          <option value="True">True</option>
          <option value="False">False</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'old peak']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">Old peak</span></td>
        <td><select name="op9" id="op9">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'thallium scan']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">Thallium scan</span></td>
        <td><select name="op10" id="op10">
          <option value="very low">very low</option>
          <option value="moderate">moderate</option>
          <option value="high">high</option>
          <option value="very high">very high</option>
        </select></td>
        </tr>
      <tr>
        <td><!--td {border: 1px solid #ccc;}br {mso-data-placement:same-cell;}-->
          <span data-sheets-value="[null,2,'age']" data-sheets-userformat="[null,null,513,[null,0],null,null,null,null,null,null,null,null,0]">Age</span></td>
        <td><select name="op11" id="op11">
          <option value="young">young</option>
          <option value="mild">mild</option>
          <option value="old">old</option>
          <option value="very old">very old</option>
        </select></td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Submit"></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
    <td width="448"><img src="images/heart.jpg" width="448" height="303"></td>
  </tr>
</table>
</form>
