
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
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
		<form:form action="/admin" method="post" modelAttribute="product">
			<h1 class="auth-title container" style="text-align: center;">Quản
				lý sản phẩm</h1>
							${message }
				
			<div class="form-row">
				<div class="form-group col-md-6">
					<form:input type="text" class="form-control " path="title"
						placeholder="Tên sản phẩm" value="" />
				</div>
				<div class="form-group col-md-6">
					<form:input type="number" class="form-control " path="price"
						placeholder="Giá" value="" />
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<form:input type="text" class="form-control " path="description"
						placeholder="Mô tả ngắn" value="" />
				</div>
				<div class="form-group col-md-6">
					<form:input type="text" class="form-control " path="detail"
						placeholder="Mô tả chi tiết" value="" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputAddress">Thể loại</label> <select name="category"
					class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
					<c:forEach items="${categoryList }" var="i">
						<option value="${i.id }" >${i.title }</option>
					</c:forEach>

				</select>
			</div>
			<div class="form-group">
				<label for="inputAddress">Hình ảnh</label>
				<form:textarea path="image" rows="20" cols="50"
					placeholder="Hình ảnh " />
			</div>
			<div class="form-group">
				<label for="inputAddress">Hình ảnh chi tiết</label>
				<form:textarea path="image_detail" rows="20" cols="50"
					placeholder="Hình ảnh chi tiết" />
			</div>


			<button type="submit" class="btn btn-primary" formaction="/admin/saveProduct">Thêm sản phẩm</button>
		</form:form>
		<section class="h-100 h-custom"
			style="background-color: #eee; margin-top: 50px">
			<h1 style="text-align: center;">Danh sách sản phẩm</h1>
			<div class="container cartshop-container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col">
						<div class="card">
							<div class="card-body p-4">
								<div class="row">
									<div class="col-lg-12">
										<h5 class="mb-3"></h5>
										<hr />
										<table class="table">
											<tr>
												<th
													style="text-align: center; width: 300px; border: 1px solid #ccc;">
													ID sản phẩm</th>
												<th
													style="text-align: center; width: 300px; border: 1px solid #ccc;">
													Tên sản phẩm</th>
												<th
													style="text-align: center; width: 300px; border: 1px solid #ccc;">
													Hình ảnh</th>
												<th
													style="text-align: center; width: 200px; border: 1px solid #ccc;">
													Thể loại</th>
												<th
													style="text-align: center; width: 200px; border: 1px solid #ccc;">
													Giá</th>
												<th
													style="text-align: center; width: 300px; border: 1px solid #ccc;">
													Trạng thái</th>

											</tr>
											<c:forEach items="${listOrder }" var="order1">
												<tr>
													<td
														style="text-align: center; width: 300px !important; border: 1px solid #ccc;">
														${order1.product.title }</td>
													<td
														style="text-align: center; width: 300px !important; border: 1px solid #ccc;">
														<img alt="" src="${order1.product.image }"
														style="max-height: 100px">

													</td>
													<td
														style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order1.size.nameSize }

													</td>
													<td
														style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order1.product.price }

													</td>
													<td
														style="text-align: center; width: 200px !important; border: 1px solid #ccc;">
														${order1.quantity }</td>
													<td
														style="text-align: center; width: 200px !important; border: 1px solid #ccc;">${order1.quantity * order1.product.price  }

													</td>
													<c:if test="${order1.order.statusOrder == false }">
														<td
															style="text-align: center; width: 200px !important; border: 1px solid #ccc;">
															Chờ xác nhận đơn hàng</td>

													</c:if>

												</tr>
											</c:forEach>

										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script src="/ckeditor/ckeditor.js"></script>

	<script type="text/javascript">
		var editor = '';
		$(document).ready(function() {
			editor = CKEDITOR.replace('image');
			editor = CKEDITOR.replace('image_detail');

		});
	</script>
</body>
</html>


