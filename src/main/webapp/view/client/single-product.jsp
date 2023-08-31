<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Product Page - Ustora Demo</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="../css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="../css/owl.carousel.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">
</head>
<body>

	<jsp:include page="../layout/nav.jsp"></jsp:include>>

	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Shop</h2>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Review</h2>
						<form action="">
							<input type="text" placeholder="Search products..."> <input
								type="submit" value="Search">
						</form>
					</div>


				</div>

				<div class="col-md-8">
					<div class="product-content-right">


						<div class="row">
							<div class="col-sm-6">
								<div class="product-images">
									<div class="product-main-img">
										<img src="${product.image }" alt="">
									</div>

									<div class="product-gallery">
										<img src="img/product-thumb-1.jpg" alt=""> <img
											src="img/product-thumb-2.jpg" alt=""> <img
											src="img/product-thumb-3.jpg" alt="">
									</div>
								</div>
							</div>

							<div class="col-sm-6">
								<div class="product-inner">
									<h2 class="product-name">${product.title }</h2>
									<h2>Category : ${product.categoryProduct.name }</h2>
									<div class="product-inner-price">
										<ins>${product.price }</ins>
										<del>$100.00</del>										
									</div>
									<form action="" class="cart" method="get">
										<div class="quantity">
											<input type="number" size="4" class="input-text qty text"
												title="Qty" value="1" name="quantity" min="1" step="1">
										</div>
										<button type="submit" formaction="/product/add-to-cart/${product.id}">Add
											to cart</button>
									</form>

									<div class="product-inner-category">
										<p>
											Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>,
											<a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>.
										</p>
									</div>

									<div role="tabpanel">
										<ul class="product-tab" role="tablist">
											<li role="presentation" class="active"><a href="#home"
												aria-controls="home" role="tab" data-toggle="tab">Description</a></li>

										</ul>
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane fade in active"
												id="home">
												<h2>Product Description</h2>
												<p>${product.details }</p>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>


					</div>
				</div>
			</div>
		</div>


		<div class="footer-top-area">
			<div class="zigzag-bottom"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6">
						<div class="footer-about-us">
							<h2>
								u<span>Stora</span>
							</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
								Perferendis sunt id doloribus vero quam laborum quas alias
								dolores blanditiis iusto consequatur, modi aliquid eveniet
								eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit,
								debitis, quisquam. Laborum commodi veritatis magni at?</p>
							<div class="footer-social">
								<a href="#" target="_blank"><i class="fa fa-facebook"></i></a> <a
									href="#" target="_blank"><i class="fa fa-twitter"></i></a> <a
									href="#" target="_blank"><i class="fa fa-youtube"></i></a> <a
									href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
							</div>
						</div>
					</div>

					<div class="col-md-3 col-sm-6">
						<div class="footer-menu">
							<h2 class="footer-wid-title">User Navigation</h2>
							<ul>
								<li><a href="">My account</a></li>
								<li><a href="">Order history</a></li>
								<li><a href="">Wishlist</a></li>
								<li><a href="">Vendor contact</a></li>
								<li><a href="">Front page</a></li>
							</ul>
						</div>
					</div>

					<div class="col-md-3 col-sm-6">
						<div class="footer-menu">
							<h2 class="footer-wid-title">Categories</h2>
							<ul>
								<li><a href="">Mobile Phone</a></li>
								<li><a href="">Home accesseries</a></li>
								<li><a href="">LED TV</a></li>
								<li><a href="">Computer</a></li>
								<li><a href="">Gadets</a></li>
							</ul>
						</div>
					</div>

					<div class="col-md-3 col-sm-6">
						<div class="footer-newsletter">
							<h2 class="footer-wid-title">Newsletter</h2>
							<p>Sign up to our newsletter and get exclusive deals you wont
								find anywhere else straight to your inbox!</p>
							<div class="newsletter-form">
								<input type="email" placeholder="Type your email"> <input
									type="submit" value="Subscribe">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom-area">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<div class="copyright">
							<p>
								&copy; 2015 uCommerce. All Rights Reserved. <a
									href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a>
							</p>
						</div>
					</div>

					<div class="col-md-4">
						<div class="footer-card-icon">
							<i class="fa fa-cc-discover"></i> <i class="fa fa-cc-mastercard"></i>
							<i class="fa fa-cc-paypal"></i> <i class="fa fa-cc-visa"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Latest jQuery form server -->
		<script src="https://code.jquery.com/jquery.min.js"></script>

		<!-- Bootstrap JS form CDN -->
		<script
			src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

		<!-- jQuery sticky menu -->
		<script src="./js/owl.carousel.min.js"></script>
		<script src="./js/jquery.sticky.js"></script>

		<!-- jQuery easing -->
		<script src="./js/jquery.easing.1.3.min.js"></script>

		<!-- Main Script -->
		<script src="./js/main.js"></script>

		<!-- Slider -->
		<script type="text/javascript" src="./js/bxslider.min.js"></script>
		<script type="text/javascript" src="./js/script.slider.js"></script>
</body>
</html>