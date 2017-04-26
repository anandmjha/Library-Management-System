<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library System</title>
<link rel="stylesheet" href="formstyle.css">
</head>
<body id="bgi">
	<form action="MemberController" name="loginForm" method="post">
		<br /> <br /> <br /> <input type="text" name="memberId"
			placeholder="Member Id" /> <br /> <input type="password"
			name="password" placeholder="Password"><br /> <select
			name="type">
			<option value="librarian" selected>Librarian</option>
			<option value="staff">Staff</option>
			<option value="student">Student</option>
		</select>
		
			<input type="submit" name="action" value="Login" style="width: 100px">
	</form>
</body>
</html>