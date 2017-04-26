<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Book</title>
<script type="text/javascript">
	function change() {
		if (document.getElementById("title").checked)
			document.getElementById("s").innerHTML = "Enter Title : ";
		if (document.getElementById("author").checked)
			document.getElementById("s").innerHTML = "Enter Author : ";
		if (document.getElementById("accessionno").checked)
			document.getElementById("s").innerHTML = "Enter Accessionno : ";
	}
</script>
</head>
<c:if test="${member == null}">
<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${member != null}">
<body bgcolor="wheat">
	<div align="center">
		<h1>Search Book</h1>
		<form name="bookform" method="post">
			<br />
			<br /> <input type="radio" name="type" id="title" value="title"
				onclick="change()" />Title &nbsp; &nbsp; <input type="radio"
				name="type" id="author" value="author" onclick="change()" />Author
			&nbsp; &nbsp; <input type="radio" name="type" id="accessionno"
				value="accessionNo" onclick="change()" />Accession No <br />
			<br /> <strong id="s">Enter Title:</strong><input type="text"
				name="query" /> <br />
			<br /> <input type="submit" name="action" value="viewBook">
			<div id="y"></div>
		</form>

		<c:if test="${param.action!=null}">
			<jsp:useBean id="bb" class="com.library.model.Book"
				scope="request" />

			<c:if test="${param.type=='title'}">
				<jsp:setProperty property="title" name="bb" param="query" />


				<c:if test="${bb.booksByTitle!=null}">
					<table border="10" cellpadding="10" cellspacing="10">
						<tr>
							<th>Accession No</th>
							<th>Title</th>
							<th>Author</th>
							<th>Status</th>
						</tr>
						<tr>
							<c:forEach items="${bb.booksByTitle}" var="book">
								<td>${book.accessionNo}</td>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td>${book.status}</td>
							</c:forEach>
						</tr>
					</table>
				</c:if>
			</c:if>

			<c:if test="${param.type=='author'}">
				<jsp:setProperty property="author" name="bb" param="query" />
				<c:if test="${bb.booksByAuthor!=null}">
					<table border="10" cellpadding="10" cellspacing="10">
						<tr>
							<th>Accession No</th>
							<th>Title</th>
							<th>Author</th>
							<th>Status</th>
						</tr>
						<tr>
							<c:forEach items="${bb.booksByAuthor}" var="book">
								<td>${book.accessionNo}</td>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td>${book.status}</td>
							</c:forEach>
						</tr>
					</table>
				</c:if>


			</c:if>
			<c:if test="${param.type=='accessionNo'}">
				<jsp:setProperty property="accessionNo" name="bb" param="query" />
				<c:if test="${bb.booksByAccessionNo!=null}">
					<table border="10" cellpadding="10" cellspacing="10">
						<tr>
							<th>Accession No</th>
							<th>Title</th>
							<th>Author</th>
							<th>Status</th>
						</tr>
						<tr>
							<c:forEach items="${bb.booksByAccessionNo}" var="book">
								<td>${book.accessionNo}</td>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td>${book.status}</td>
							</c:forEach>
						</tr>
					</table>
				</c:if>

			</c:if>

		</c:if>

	</div>
</body>
</c:if>
</html>