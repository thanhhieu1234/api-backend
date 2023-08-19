<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap -->
<link rel="stylesheet" href="../css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="../css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="../css/owl.carousel.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/responsive.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                            <li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                            <li><a href="/cart"><i class="fa fa-user"></i> My Cart</a></li>
                            <li><a href="/checkout"><i class="fa fa-user"></i> Checkout</a></li>
                            <li><a href="/login"><i class="fa fa-user"></i> Login</a></li>
                            <li><a href="/sign-up"><i class="fa fa-user"></i> Register</a></li>
                            
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
    </div> <!-- End header area -->
    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="/home"><img src="../img/logo.png"></a></h1>
                    </div>
                </div>
                
                <div class="col-sm-6">
                    <div class="shopping-item">
                        <a href="cart.html">Cart - <span class="cart-amunt">$800</span> <i class="fa fa-shopping-cart"></i> <span class="product-count">5</span></a>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                  <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/index">Home</a></li>
                        <li><a href="/shop">Shop page</a></li>
                        <li class="active"><a href="/single-product">Single product</a></li>
                        <li><a href="/cart">Cart</a></li>
                        <li><a href="/checkout">Checkout</a></li>
                        <li><a href="#">Category</a></li>
                        <li><a href="#">Others</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    

</body>
</html>