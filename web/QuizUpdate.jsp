<%-- Document : Quiz Created on : Jun 13, 2023, 1:11:04 PM Author : admin's --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>JSP Page</title>
                <link href="css/QuizUpdate.css" rel="stylesheet" />
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
            </head>

            <body>
                <div class="wrapper">
                    <div class="close-container" id="closeButton" onclick="history.back()">
                        <div class="leftright"></div>
                        <div class="rightleft"></div>
                    </div>
                    <div id="display-container">
                        <form action="changeQuiz" method="post">
                            <div class="header">
                                <div class="number-of-count">
                                    <input type="text" class="option-div" name="quizname" placeholder="Enter quiz name"
                                        value="${q_update.quizName}">
                                </div>
                                <div class="timer-div">
                                    <p>time:</p>
                                    <input name="time-min" type="time" class="time-lefft" value="${q_update.timeLimit}">
                                    <input name="time-sec" type="time" class="time-let" value="${q_update.timeLimit}">
                                </div>
                            </div>

                            <c:forEach items="${displayquiz}" var="q">
                                <a class="redirect" href="changeQuizQuestion?questionid=${q.questionId}" id="container">
                                    <div class="container-mid">
                                        <h2 class="quesnumber"></h2>
                                        <div class="option-div">${q.content}</div>
                                        <c:forEach items="${displayanswer}" var="a">
                                            <div class="formAnswer">
                                                <div class="option-div">${a.content}</div>
                                                <input class="radio" type="radio" name="radio-${q.questionId}"
                                                    ${a.isCorrectAnswer=="true" ? "checked" : "" }>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </a>
                            </c:forEach>
                            <div class="button-container">
                                <button class="update-button" type="submit">Update</button>
                                <a href="deleteQuiz?quizid=${q_update.quizId}" class="update-button">Delete</a>
                            </div>
                        </form>
                    </div>

                </div>
            </body>

            <script src="js/quizUpdate.js"></script>

            </html>