<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>
Librarian Page
</title>
<link rel="stylesheet" href="formstyle.css"></link>
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="#ffffcc">
<div align="center">
<h2>You are logged in as a Librarian</h2>
<h3>
<a href="addbook.jsp" target="f3">Add Book </a> 
<br/><br/>
<a href="viewbook.jsp" target="f3">View All Book</a>
<br/><br/>
<a href="updatebook.jsp" target="f3">Update Book </a>
<br/><br/>
<a href="deletebook.jsp" target="f3">Delete Book</a>
<br/><br/>
<a href="issuebook.jsp" target="f3">Issue Book</a> 
<br/><br/>
<a href="returnbook.jsp" target="f3">Return Book</a> 
<br/><br/>
<a href="addmember.jsp" target="f3">Add Member</a> 
<br/><br/>
<a href="updatemember.jsp" target="f3">Update Member</a> 
<br/><br/>
<a href="deletemember.jsp" target="f3">Delete Member</a> 
</h3>
</div>
</body>
</c:if>
</html>