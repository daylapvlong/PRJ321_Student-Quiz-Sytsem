<%-- Document : Quiz Created on : Jun 13, 2023, 1:11:04 PM Author : admin's --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link href="css/Quiz.css" rel="stylesheet" />
            <script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        </head>

        <body>
            <div class="close-container" id="closeButton" onclick="history.back()">
                <div class="leftright"></div>
                <div class="rightleft"></div>
            </div>
            <div class="start-screen">
                <button id="start-button">Start</button>
            </div>
            <div id="display-container">
                <div class="header">
                    <div class="number-of-count">
                        <span class="number-of-question">1 of ${quiz.numOfQuestions} questions</span>
                    </div>
                    <div class="timer-div">
                        <p>time:</p>
                        <span class="time-left">${quiz.timeLimit}</span>
                    </div>
                </div>
                <div id="container">
                    <!-- questions and options will be displayed here -->
                </div>
                <button id="next-button">Next</button>
            </div>
            <div class="score-container hide">
                <div id="user-score">Demo Score</div>
                <button id="restart">Restart</button>
            </div>
        </body>

        <script src="js/quiz.js"></script>

        </html>