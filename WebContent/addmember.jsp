<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member</title>
<link rel="stylesheet" href="formstyle.css">
<script type="text/javascript">
	function validate() {
		if (document.Memberform.memberId.value != "") {
			return true;
		} else
			document.getElementById('me').innerHTML="All field Required";
			return false;
	}
</script>
</head>
<c:if test="${member == null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
	<body bgcolor="wheat">
		<h5 align="center">
			<c:if test="${not empty msg}">
				<c:out value="${msg}" />
			</c:if>
		</h5>
		<h3 align="center">Add Member</h3>
		<div align="center" id="me"></div>
		<form action="MemberController" name="Memberform" method="post"
			onsubmit="return validate()">
			<input type="text" name="memberId" placeholder="Member Id" /> <input
				type="text" name="name" placeholder="Name" />
			<textarea name="address" rows="3" cols="10" placeholder="Address"></textarea>

			<select name="type">
				<option value="" selected>Select</option>
				<option value="Student">Student</option>
				<option value="Staff">Staff</option>
			</select> <br /> <br /> <input type="submit" name="action" value="AddMember">
		</form>
	</body>
</c:if>
</html>