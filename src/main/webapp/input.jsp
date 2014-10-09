<%@ page import="java.io.*,java.util.*,com.habibu.expertsystem.Algorithms" %>
<%!String message1 = ""; %>
<%
if(request.getParameter("submit") != null) {
	//int age = Integer.parseInt(request.getParameter("age"));
	//String ses = request.getParameter("sex");
	String chestpain = request.getParameter("chestpain");
	String bloodpressure = request.getParameter("bloodpressure");
	String cholestrol = request.getParameter("cholestrol");
	String bloodsugar = request.getParameter("bloodsugar");
	String maxheartrate = request.getParameter("maxheartrate");
	String oldpeak = request.getParameter("oldpeak");
	//String exercise = request.getParameter("exercise");
	//String thal = request.getParameter("thal");
	
	HashMap hm = new HashMap();
	hm.put("chestpain", chestpain);
	hm.put("cholestrol", cholestrol);
	hm.put("maxheartrate", maxheartrate);
	hm.put("bloodpressure", bloodpressure);
	hm.put("bloodsugar", bloodsugar);
	hm.put("oldpeak", oldpeak);
	
	Algorithms alg = new Algorithms();
	String results = alg.results(hm);
		
	message1 = "Results: "+results;
	

	
	
	
}
/**
   Enumeration paramNames = request.getParameterNames();

   while(paramNames.hasMoreElements()) {
      String name = (String)paramNames.nextElement();
      String value = request.getHeader(name);
      out.println(name+"=="+value+"<br>");
   }
   */
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Text</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="">
  <table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td width="396"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="40" colspan="2" align="center"><h1><%= message1 %></h1></td>
          </tr>
        <tr>
          <td width="51%" height="40"><strong>chestpain:</strong></td>
          <td width="49%" height="40"><select name="chestpain" id="chestpain">
            <option value="verylow" selected="selected">verylow</option>
            <option value="low">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40"><strong>cholestrol:</strong></td>
          <td height="40"><select name="cholestrol" id="cholestrol">
            <option value="verylow" selected>verylow</option>
            <option value="low">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40"><strong>maxheartrate:</strong></td>
          <td height="40"><select name="maxheartrate" id="maxheartrate">
            <option value="verylow" selected>verylow</option>
            <option value="low">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40"><strong>bloodpressure:</strong></td>
          <td height="40"><select name="bloodpressure" id="bloodpressure">
            <option value="verylow" selected>verylow</option>
            <option value="low">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40"><strong>bloodsugar:</strong></td>
          <td height="40"><select name="bloodsugar" id="bloodsugar">
            <option value="verylow">verylow</option>
            <option value="low" selected="selected">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40"><strong>oldpeak:</strong></td>
          <td height="40"><select name="oldpeak" id="oldpeak">
            <option value="verylow" selected>verylow</option>
            <option value="low">low</option>
            <option value="medium">medium</option>
            <option value="high">high</option>
            <option value="veryhigh">veryhigh</option>
          </select></td>
        </tr>
        <tr>
          <td height="40">&nbsp;</td>
          <td height="40"><input name="submit" type="submit" id="submit" value="Submit"></td>
        </tr>
      </table></td>
      <td width="394">&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>
