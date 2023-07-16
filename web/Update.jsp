<%-- Document : Update.jsp Created on : Jun 18, 2023, 4:50:31 PM Author : admin's --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
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
            <link rel="stylesheet" href="css/Update.css">
        </head>

        <body>
            <div class="limiter">
                <div class="container-update100">
                    <div class="wrap-update100">
                        <form action="changeAccount" method="post" class="update100-form validate-form">
                            <div class="form-header">
                                <div class="close-container" id="closeButton">
                                    <div class="leftright"></div>
                                    <div class="rightleft"></div>
                                </div>
                                <span class="update100-form-title">
                                    Changing Account Information
                                </span>
                            </div>

                            <p class="form-heading">Enter your new name: </p>
                            <div class="wrap-input100 validate-input">
                                <input class="input100" type="text" name="name" id="name" value="${a_update.name}"
                                    required>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                            </div>

                            <p class="form-heading">Enter your new email: </p>
                            <div class="wrap-input100 validate-input"
                                data-validate="Valid email is required: ex@abc.xyz">
                                <input class="input100" type="email" name="email" id="email" value="${a_update.email}"
                                    required>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                            </div>

                            <p class="form-heading">Enter your new Password: </p>
                            <div class="wrap-input100">
                                <input class="input100" type="password" name="password" id="password"
                                    value="${a_update.password}" required>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-lock" aria-hidden="true"></i>
                                </span>
                            </div>
                            <div class="container-update100-form-btn">
                                <button class="update100-form-btn" type="submit">Change Account</button>
                            </div>
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
            <script>
                $('.js-tilt').tilt({
                    scale: 1.1
                })

                var closeButton = document.getElementById("closeButton");
                closeButton.addEventListener("click", function () {
                    window.location.href = "home";
                });
            </script>
            <!--===============================================================================================-->
            <script src="js/main.js"></script>
        </body>

        </html>