<%-- Document : home Created on : Jun 6, 2023, 8:11:16 AM Author : admin's --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>


            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>HomePage</title>
                <!--===============================================================================================-->
                <link rel="stylesheet" href="css/Home.css">
                <!--===============================================================================================-->
                <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
            </head>

            <body>
                <jsp:include page="Navbar.jsp"></jsp:include>
                <div class="body_container">
                    <div class="body_function_container">
                        <div class="enter_code_container col-sm-7">
                            <div class="inner-form">
                                <form class="enter_code_form" action="search" method="post">
                                    <input name="txt" type="text" class="enter_code_input"
                                        id="choices-text-preset-values" type="text" placeholder="Find a course..." />
                                    <button class="enter_code_button" type="submit">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                            viewBox="0 0 24 24">
                                            <path
                                                d="M15.5 14h-.79l-.28-.27C15.41 12.59 16 11.11 16 9.5 16 5.91 13.09 3 9.5 3S3 5.91 3 9.5 5.91 16 9.5 16c1.61 0 3.09-.59 4.23-1.57l.27.28v.79l5 4.99L20.49 19l-4.99-5zm-6 0C7.01 14 5 11.99 5 9.5S7.01 5 9.5 5 14 7.01 14 9.5 11.99 14 9.5 14z">
                                            </path>
                                        </svg>
                                    </button>
                                </form>
                            </div>
                        </div>
                        <div class="profile_container col-sm-4">
                            <div class="profile_box">
                                <div class="profile_header">
                                    <h2>Hello ${sessionScope.name}</h2>
                                </div>
                            </div>
                            <div class="profile_body">
                                <c:forEach items="${listAccount}" var="o">
                                    <c:if test="${o.id == sessionScope.acc.id}">
                                        <a class="" href="changeAccount?accid=${o.id}" onclick="redirectToUpdate()">Edit
                                            Profile</a>
                                        <p class="profile_body_slash">/</p>
                                        <a class="" href="Result.jsp">View Activity</a>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>

                    <div class="body_content_container">
                        <div class="dropdown">
                            <button onclick="myFunction()" class="dropbtn">Semester</button>
                            <div id="myDropdown" class="dropdown-content">
                                <c:forEach items="${listCategory}" var="o">
                                    <a href="category?cid=${o.categoryId}" class="active">${o.categoryName}</a>
                                </c:forEach>
                            </div>
                        </div>
                        <section class="">
                            <div class="content_container container mt-5">
                                <div
                                    class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                                    <c:forEach items="${listPaging}" var="o">
                                        <div class="col mb-5">
                                            <div class="content_wrapper card">
                                                <h2>${o.courseName}</h2>
                                                <p>${o.description}</p>
                                                <a class="content_button" href="course?courseid=${o.courseId}">View
                                                    course now</a>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="pageSelector">
                                <ul class="pageSelector_list">
                                    <li>
                                        <c:choose>
                                            <c:when test="${tag > 1}">
                                                <a href="#" class="pageSelector_box"
                                                    onclick="previousPage()">&laquo;</a>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="pageSelector_box disabled">&laquo;</span>
                                            </c:otherwise>
                                        </c:choose>

                                        <c:forEach begin="1" end="${endP}" var="o">
                                            <a href="home?index=${o}" class="pageSelector_box">${o}</a>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${tag < endP}">
                                                <a href="#" class="pageSelector_box" onclick="nextPage()">&raquo;</a>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="pageSelector_box disabled">&raquo;</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                </ul>
                            </div>
                        </section>
                    </div>
                </div>

                <jsp:include page="Footer.jsp"></jsp:include>

                <script>
                    function previousPage() {
                        var currentPage = parseInt("${tag}");
                        if (currentPage > 1) {
                            var previousPage = currentPage - 1;
                            window.location.href = "home?index=" + previousPage;
                        }
                    }

                    function nextPage() {
                        var currentPage = parseInt("${tag}");
                        var totalPages = parseInt("${endP}");
                        if (currentPage < totalPages) {
                            var nextPage = currentPage + 1;
                            window.location.href = "home?index=" + nextPage;
                        }
                    }
                </script>

                <script src="js/home.js"></script>
            </body>

            </html>