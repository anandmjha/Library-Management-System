<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Base Page</title>
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<div align="center">
			<h2 style="color: red">About Library:</h2>
			<p>
				Welcome To Library Management System By Anandmohan Jha for
				Understanding Web development <br />
				<br />
				<br />
				<br /> Thanks For Reading This
			</p>
		</div>
	</body>
</c:if>
</html>