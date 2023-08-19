
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Check out</title>
<link rel="stylesheet"
	href="/view/bootstrap-5.2.2-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/view/icofont/icofont.min.css" />
<link rel="stylesheet" href="/view/icofont/icofont.css" />
<link rel="stylesheet" href="/view/styles.css" />
<link rel="stylesheet" href="/view/logreg.css" />
<link rel="stylesheet"
	href="/view/assets/fonts/fontawesome-free-6.0.0/css/fontawesome.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css" />
</head>
<body>
	<section class="h-100 h-custom" style="background-color: #eee">
		<div class="container cartshop-container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col">
					<div class="card">
						<h1 style="text-align: center;">Quản lý Order</h1>

						<div class="card-body p-4">
							<div class="row">
								<div class="col-lg-12">
									<h5 class="mb-3"></h5>
									<hr />
									<table class="table">
										<tr>
											<th
												style="text-align: center; width: 300px; border: 1px solid #ccc;">
												Tên sản phẩm</th>
											<th
												style="text-align: center; width: 300px; border: 1px solid #ccc;">
												Hình ảnh</th>
											<th
												style="text-align: center; width: 200px; border: 1px solid #ccc;">
												Kích thước</th>
											<th
												style="text-align: center; width: 200px; border: 1px solid #ccc;">
												Giá</th>
											<th
												style="text-align: center; width: 200px; border: 1px solid #ccc;">
												Số lượng</th>
											<th
												style="text-align: center; width: 300px; border: 1px solid #ccc;">
												Thành tiền</th>
											<th
												style="text-align: center; width: 300px; border: 1px solid #ccc;">
												Ngày đặt hàng</th>
											<th
												style="text-align: center; width: 300px; border: 1px solid #ccc;">
												Trạng thái</th>

										</tr>
										<c:forEach items="${OrderList }" var="order">
											<tr>
												<td
													style="text-align: center; width: 300px !important; border: 1px solid #ccc;">
													${order.product.title }</td>
												<td
													style="text-align: center; width: 300px !important; border: 1px solid #ccc;">
													<img alt="" src="${order.product.image }"
													style="max-height: 100px">

												</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order.size.nameSize }

												</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order.product.price }

												</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">
													${order.quantity }</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order.quantity * order.product.price  }

												</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order.order.buyDate  }

												</td>
												<td
													style="text-align: center; width: 200px !important; border: 1px solid #ccc;">
													<form action="/admin" method="post">
														<select name="click">
															<c:choose>

																<c:when test="${order.order.statusOrder == false }">
																	<option value="false" selected>Chờ xác nhận
																		đơn hàng</option>
																	<option value="true">Xác nhận đơn hàng</option>
																</c:when>
																<c:when test="${order.order.statusOrder == true }">
																	<option value="false" selected>Xác nhận đơn
																		hàng</option>
																	<option value="true">Chờ xác nhận đơn hàng</option>

																</c:when>

															</c:choose>

														</select> <input type="submit"
															formaction="/admin/quan-ly-order/${order.order.id }"
															value="update">
													</form>
												</td>


											</tr>
										</c:forEach>

									</table>
								</div>
							</div>
						</div>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item"><a class="page-link" href="#">Previous</a></li>
								<c:forEach begin="1" end="${index }" var="index">
									<li class="page-item"><a class="page-link" href="#">${index }</a></li>

								</c:forEach>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>


			</div>
		</div>
	</section>
	<jsp:include page="/view/footer_component.jsp"></jsp:include>
</body>
</html>
