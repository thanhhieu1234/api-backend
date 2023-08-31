<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
				integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
				crossorigin="anonymous">
			<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
				integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
				integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
				crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
				integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
				crossorigin="anonymous"></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

		</head>

		<body>
			<div class="container">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Tinh</label>
					</div>
					<select id="tinh" class="custom-select" id="inputGroupSelect01">
						<option value="0">Choose...</option>
					</select>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Huyen</label>
					</div>
					<select id="huyen" class="custom-select" id="inputGroupSelect01">
						<option selected>Choose...</option>
					</select>
				</div>

				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<label class="input-group-text" for="inputGroupSelect01">Xa</label>
					</div>
					<select id="xa" class="custom-select" id="inputGroupSelect01">
						<option selected>Choose...</option>
					</select>
				</div>
			</div>

		</body>
		<script>
			$(document).ready(function () {
				$.ajax({
					url: "http://localhost:8081/api/city",
					dataType: 'json',
					type: 'GET',
					success: function (data) {
						for (var i = 0; i < data.length; i++) {
							var city = data[i];
							var a = city.nameCity
							var option = $('<option>', {
								value: city.id,
								text: a
							});
							$("#tinh").append(option);
						}
						$("#tinh").on("change", function (e) {
							layHuyen();
						});
					},
					error: function (r) {
						console.log(r);
					}
				});
			});

			function layHuyen() {
				var id = $('#tinh').val();
				$.ajax({
					url: "http://localhost:8081/api/district/" + id,
					dataType: 'json',
					type: 'GET',
					success: function (data) {
						$("#huyen").html("");
						for (var i = 0; i < data.length; i++) {
							var huyen = data[i];
							console.log(huyen);
							var option = $('<option>', {
								value: huyen.id,
								text: huyen.nameDistrict
							});
							$("#huyen").append(option);
						}
						$("#huyen").on("change", function () {
							layXa();
						});
					},
					error: function (r) {
						console.log(r);
					}
				});
			}

			function layXa() {
				var id = $("#huyen").val();
				$.ajax({
					url: "http://localhost:8081/api/ward/" + id,
					dataType: 'json',
					type: 'GET',
					success: function (data) {
						$("#xa").html("");
						for (var i = 0; i < data.length; i++) {
							var xa = data[i];
							console.log(xa);
							var option = $('<option>', {
								value: xa.id,
								text: xa.nameWard
							});
							$("#xa").append(option);
						}
					},
					error: function (r) {
						console.log(r);
					}
				});
			}
		</script>

		</html>