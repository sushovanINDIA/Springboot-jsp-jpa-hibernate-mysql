<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link href="/css/bootstrap.css" rel="stylesheet"> -->
<link href="/css/custom.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Students List</h1>
	<table id="t02" cellpadding="2">
		<tr>
			<th><a href="/enroll"><h2>Home Page</h2></a><a align="right" href="/delete"><h2>Delete All Students</h2></a>
			</th>

			<th></th>
			</tr>
	</table>
	

	<form:form class="form-horizontal">
		<table id="t01" border="2" width="70%" cellpadding="2">
			<!-- <tr><th>Id</th> -->
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Sex</th>
			<th>Date Modified</th>
			<th>Email</th>
			<th>Section</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr>

			<c:forEach var="student" items="${list}">
				<tr>
					<%--    <td>${student.id}</td>   --%>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.sex}</td>
					<td>${student.createdAt}</td>
					<td>${student.email}</td>
					<td>${student.section}</td>
					<td>${student.country}</td>


					<td><a href="/editstudent/${student.id}">Edit</a></td>
					<td><a href="/deletestudent/${student.id}">Delete</a></td>
				</tr>
			</c:forEach>


		</table>
		<br />


	</form:form>
</body>
</html>