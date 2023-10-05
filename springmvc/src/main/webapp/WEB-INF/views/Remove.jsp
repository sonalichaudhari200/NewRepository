<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.jspiders.springmvc.pojo.StudentPojo"%>
 <%@page import="java.util.List"%>
 
    
    
        <jsp:include page="NavBar.jsp"/>
       <%  List<StudentPojo> students = (List<StudentPojo>) request.getAttribute("students");
           String msg=(String)request.getAttribute("msg");
       %>
        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <div align="center">
      <fieldset>
        <legend></legend>
        <form action="./remove" method="post">
          <table>
            <tr>
             <td>Enter id</td>
             <td> <input type="text" name="id" ></td>
             </tr>
          </table>
             <input type="submit" value="Remove">
          
        </form>
      </fieldset>
         <%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (students != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (StudentPojo pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
      </div>
</body>
</html>