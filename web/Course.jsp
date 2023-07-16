<%-- Document : Course Created on : Jun 9, 2023, 8:17:28 PM Author : admin's --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
                <link rel="stylesheet" href="css/Course.css">
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                    crossorigin="anonymous">
            </head>

            <body>
                <jsp:include page="Navbar.jsp"></jsp:include>

                <div class="body_container">
                    <div class="course_container">
                        <c:choose>
                            <c:when test="${sessionScope.role eq '1'}">
                                <a href="changeCourse?courseid=${course.courseId}" class="course_details col-sm-8">
                                    <h1>${course.courseName}</h1>
                                    <h1>/</h1>
                                    <h2>${course.description}</h2>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <div class="course_details col-sm-8">
                                    <h1>${course.courseName}</h1>
                                    <h1>/</h1>
                                    <h2>${course.description}</h2>
                                </div>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${sessionScope.role eq '1'}">
                                <div class="course_filter col-sm-7">
                                    <div class="enter_code_container_admin">
                                        <div class="inner-form">
                                            <form class="enter_code_form" action="searchCourse" method="post">
                                                <input name="txt" class="enter_code_input" id="choices-text-preset-values"
                                                    type="text" placeholder="Enter quiz code..." />
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

                                    <a class="delete-btn" href="deleteCourse?courseid=${course.courseId}">
                                        <i class="material-icons" style="font-size:36px">delete</i>
                                        <span class="popuptext">Delete this course?</span>
                                    </a>

                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="course_filter col-sm-5">
                                    <div class="enter_code_container">
                                        <div class="inner-form">
                                            <form class="enter_code_form" action="searchCourse" method="post">
                                                <input name="txt" class="enter_code_input" id="choices-text-preset-values"
                                                    type="text" placeholder="Enter quiz code..." />
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
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <c:choose>
                        <c:when test="${sessionScope.role eq '1'}">
                            <div class="create">
                                <a class="create-btn" href="Create.jsp">Create
                                    quiz</a>
                            </div>
                        </c:when>
                    </c:choose>
                    <div class="quiz_table">
                        <table class="quiz_table_content">
                            <thead class="quiz_table_header">
                                <tr>
                                    <th scope="col" class="quiz_name">
                                        Quiz Name
                                    </th>
                                    <th scope="col" class="quiz_else">
                                        Created Date
                                    </th>
                                    <th scope="col" class="quiz_else">
                                        Number of Questions
                                    </th>
                                    <th scope="col" class="quiz_else">
                                        Time
                                    </th>
                                    <c:choose>
                                        <c:when test="${sessionScope.role eq '1'}">
                                            <th scope="col" class="quiz_else">
                                                Update Test?
                                            </th>
                                            <th scope="col" class="quiz_else">
                                                Delete Quiz?
                                            </th>
                                        </c:when>
                                        <c:otherwise>
                                            <th scope="col" class="quiz_else">
                                                Ready to Test?
                                            </th>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listQuiz}" var="o">
                                    <tr class="quiz_table_body">
                                        <th scope="row">
                                            ${o.quizName}
                                        </th>
                                        <td class="px-6 py-4">
                                            ${o.dateCreated}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${o.numOfQuestions}
                                        </td>
                                        <td class="px-6 py-4">
                                            ${o.timeLimit}
                                        </td>
                                        <c:choose>
                                            <c:when test="${sessionScope.role eq '1'}">
                                                <td class="px-6 py-4">
                                                    <a href="changeQuiz?quizid=${o.quizId}" class="startbtn">Update</a>
                                                </td>
                                                <td class="px-6 py-4">
                                                    <a href="deleteQuiz?quizid=${o.quizId}" class="startbtn">
                                                        <i class="material-icons" style="font-size:26px">delete</i>
                                                    </a>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="px-6 py-4">
                                                    <a href="quiz?quizid=${o.quizId}" class="startbtn">Start</a>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                </div>

                <jsp:include page="Footer.jsp"></jsp:include>

                <script src="js/course.js"></script>
            </body>

            </html>