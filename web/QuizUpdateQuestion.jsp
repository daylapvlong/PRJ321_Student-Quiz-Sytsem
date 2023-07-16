<%-- Document : Quiz Created on : Jun 13, 2023, 1:11:04 PM Author : admin's --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
                <link href="css/QuizUpdateQuestion.css" rel="stylesheet" />
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
            </head>

            <body>
                <div class="close-container" id="closeButton" onclick="history.back()">
                    <div class="leftright"></div>
                    <div class="rightleft"></div>
                </div>
                <div id="display-container">
                    <form action="changeQuizQuestion" method="post">
                        <div class="header">
                            <div class="number-of-count">
                                <span class="number-of-question">Question 1</span>
                            </div>
                        </div>
                        <div id="container">
                            <div class="container-mid">
                                <input type="text" name="id" value="${displayquestion.questionId}" hidden>
                                <input class="option-div-question" name="question" value="${displayquestion.content}">

                                <c:forEach items="${displayanswer}" var="a">
                                    <div class="formAnswer">
                                        <input class="option-div-answer" name="answer" value="${a.content}">
                                        <input class="radio" type="radio" name="radio" ${a.isCorrectAnswer=="true"
                                            ? "checked" : "" }>
                                    </div>
                                </c:forEach>
                            </div>

                        </div>
                        <div class="button-container">
                            <button class="update-button">Update</button>
                            <a href="#" class="update-button">Delete</a>
                        </div>
                    </form>
                </div>
            </body>

            <script src="js/quizUpdateQuestion.js"></script>

            </html>