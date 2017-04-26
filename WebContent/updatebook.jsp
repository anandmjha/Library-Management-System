<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="wheat">
	<h1 align="center">Update Book</h1>
	<form action="BookController" method="post">
		<select name="accessionNo">
			<c:forEach items="${books}" var="book">
				<option value="${book.accessionNo}" >${book.accessionNo}</option>
			</c:forEach>
		</select> 
		<input type="text" name="title" placeholder="Title" /> 
		<input type="text" name="author" placeholder="Author" />
		<select	name="status">
			<option value="available" selected>Available</option>
			<option value="unavailable">Unavailable</option>
		</select> <input type="submit" name="action" value="Update" style="width: 100px">
		<div id="y"></div>
	</form>
</body>
</c:if>
</html>