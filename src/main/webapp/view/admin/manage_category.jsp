<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="col-10">
			<form:form  method="post"
				modelAttribute="categories">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<form:input path="name" class="form-control" placeholder="Name" />
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Name Code</label>
					<form:input path="nameCode" class="form-control"
						placeholder="Name code" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Status</label>
					<form:radiobutton path="status" value="true" label="Hiện"  />
					<form:radiobutton path="status" value="false" label="Ẩn" />
				</div>
				<button type="submit" class="btn btn-primary" formaction="/admin/quan-li-the-loai/save">Save</button>
				<button type="submit" class="btn btn-primary" formaction="/admin/quan-li-the-loai/update/${categories.id }">Update</button>

			</form:form>

		</div>
		<div class="col-10">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">Name code</th>
						<th scope="col">Status</th>
						<th scope="col">Edit</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list }" var="category">
						<tr>
							<th scope="row">${category.id }</th>
							<td>${category.name }</td>
							<td>${category.nameCode }</td>
							<td><c:if test="${category.status == false }">Ẩn </c:if> <c:if
									test="${category.status == true }">Hiện </c:if></td>
							<td>
							<a href="/admin/quan-li-the-loai/${category.id }">Chỉnh sửa</a>
						    <a href="/admin/quan-li-the-loai/delete/${category.id }">Xóa</a>
							
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>