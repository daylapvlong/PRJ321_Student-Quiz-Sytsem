<%-- 
    Document   : Login
    Created on : May 31, 2023, 4:55:17 PM
    Author     : admin's
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	    <link rel="stylesheet" type="text/css" href="css/util.css">
	    <link rel="stylesheet" type="text/css" href="css/Login.css">
<!--===============================================================================================-->
    </head>

    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic">
                        <img src="images/signin-image.jpg" alt="IMG">
                    </div>

                    <form class="login100-form validate-form" action="change" method="post">
                        <span class="login100-form-title">
                            Changing your password
                        </span>
                        
                        <div>
                            ${passmess}
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="email" value="${request.getAttribute("email")}" placeholder="Email">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Password is required">
                            <input class="input100" type="password" name="password" value="${request.getAttribute("password")}" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Password is required">
                            <input class="input100" type="password" name="repassword" value="${request.getAttribute("repassword")}" placeholder="Re-enter Password">
                            <span class="focus-input100"></span>    
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i> 
                            </span>
                        </div>

                        <div class="container-login100-form-btn">
                            <input class="login100-form-btn" type="submit" value="change" />
                        </div>

                        <c:if test="${sessionScope.acc == null}">
                            <div class="text-center p-t-136">
                                <a class="txt2" href="Login.jsp">
                                    <i class="fa fa-long-arrow-left m-l-5" aria-hidden="true"></i>
                                    Go back to Login /
                                </a>
                                
                                <a class="txt2" href="SignUp.jsp">
                                    Create your Account
                                    <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                                </a>
                            </div>
                        </c:if>    
                    </form>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script >
                $('.js-tilt').tilt({
                        scale: 1.1
                })
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>


        <!--        <<form action="Login" method="post">
                    username: <input type="email" name="email" /><br>
                    password: <input type="text" name="password" /><br>
                    <input type="submit" value="login"/>
                    </form> -->
    </body>
</html>
