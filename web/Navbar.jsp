<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Navbar</title>
            <link rel="stylesheet" href="css/Navbar.css">
        </head>

        <body>
            <nav class="navbar">
                <div class="logo">
                    <a href="WelcomePage.jsp">
                        <h1 class="logo_heading">Quizzle</h1>
                    </a>
                </div>
                <div class="navbar_left">
                    <a class="navbar_icon" href="WelcomePage.jsp">Home</a>
                    <a class="navbar_icon" href="About.jsp">About us</a>
                    <a class="navbar_icon" href="${sessionScope.acc == null ? 'Login.jsp' : 'home'}">Courses</a>
                    <c:choose>
                        <c:when test="${sessionScope.role eq '1'}">
                            <a class="navbar_icon" href="${sessionScope.acc == null ? 'Login.jsp' : 'Result.jsp'}">Activity</a>
                            <a class="navbar_icon" href="${sessionScope.acc == null ? 'Login.jsp' : '#'}">Contact Us</a>
                        </c:when>
                        <c:otherwise>
                            <a class="navbar_icon" href="${sessionScope.acc == null ? 'Login.jsp' : 'Result.jsp'}">Activity</a>
                            <a class="navbar_icon" href="${sessionScope.acc == null ? 'Login.jsp' : '#'}">Contact Us</a>
                        </c:otherwise>
                    </c:choose>

                </div>

                <div class="navbar_right">
                    <c:if test="${sessionScope.acc == null}">
                        <a class="navbar_icon" href="Login.jsp">Login</a>
                        <a class="navbar_icon" href="SignUp.jsp">Sign up</a>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <a class="navbar_icon" href="javascript:logout()">Logout</a>
                    </c:if>
                </div>
            </nav>

            <script>
                function logout() {
                    // Send an AJAX request to your logout servlet or endpoint
                    var xhr = new XMLHttpRequest();
                    xhr.open('POST', 'Logout', true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                            // Redirect the user to the login page or any other appropriate page
                            window.location.href = 'Login.jsp';
                        }
                    };
                    xhr.send();
                }
            </script>
        </body>

        </html>