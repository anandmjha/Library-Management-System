<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Member</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="wheat">
	<h1 align="center">Update Member</h1>
	<form action="user.html" onsubmit="Add(this)" name="Memberform">

		<input type="text" name="name" placeholder="Name" /> 
		<input type="text" name="memberId" placeholder="Member Id" />
		<textarea name="address" rows="3" cols="10" placeholder="Address" ></textarea>

		<select name="member_type">
			<option value="" selected>Select</option>
			<option value="Student">Student</option>
			<option value="Staff">Staff</option>
		</select> <br /> <br /> <input type="submit" value="update">
		<div id="y"></div>
	</form>
</body>
</c:if>
</html>