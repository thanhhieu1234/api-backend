<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
		<div class="col-10">
	<form:form action="/quan-li-the-loai" modelAttribute="user"
		method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Username</label>
			<form:input path="username" class="form-control"
				placeholder="Username" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Password</label>
			<form:password path="password" value="${user.password }" class="form-control"
				placeholder="Password" />
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Email</label>
			<form:input path="email" class="form-control" placeholder="Email" />
		</div>
		<div class="form-group">
			<c:forEach items="${roles }" var="i">
				<input type="checkbox" name="check" value="${i.name }" />${i.name }
		</c:forEach>
		</div>





		<input type="submit" formaction="/save" value="save">
		<input type="submit" formaction="/update/${user.id }" value="update">
	</form:form>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">username</th>
				<th scope="col">password</th>
				<th scope="col">email</th>
				<th scope="col">Trạng thái</th>
				<th scope="col">role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="i">
				<tr>
					<th scope="row">${i.id}</th>
					<th scope="row">${i.username}</th>
					<th scope="row">${i.password}</th>
					<th scope="row">${i.email}</th>
					<th scope="row">
					<c:if test="${i.status == false}">Ẩn</c:if>
					<c:if test="${i.status == true}">Hiện</c:if>
					
					</th>
					<c:forEach items="${i.roles }" var="r">
						<th scope="row">${r.name}</th>
					</c:forEach>
					<th scope="row"><a href="/search/${i.id }">Edit</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	
</body>
</html>