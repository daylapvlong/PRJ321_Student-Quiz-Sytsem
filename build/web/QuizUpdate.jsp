<%-- Document : Quiz Created on : Jun 13, 2023, 1:11:04 PM Author : admin's --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="css/QuizUpdate.css" rel="stylesheet"/>
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
            <jsp:useBean id="q_update" scope="request" type="Model.Quiz"/>
            <input type="hidden" name="quizId" value="${q_update.quizId}">
            <div class="header">
                <div class="number-of-count">
                    <div class="option-div">
                               ${q_update.quizName}
                    </div>
                </div>
                <div class="timer-div">
                    <p>time:</p>
                    <label>
                        <input name="time-min" type="text" class="time-lefft" value="${q_update.timeLimit}">
                    </label>
                    <label>
                        <input name="time-sec" type="text" class="time-let" value="${q_update.timeLimit}">
                    </label>
                </div>
            </div>

            <jsp:useBean id="displayquiz" scope="request" type="java.util.List<Model.Question>"/>
            <c:forEach begin="0" end="${displayquiz.size() - 1}" var="i">
                <c:set var="q" value="${displayquiz.get(i)}"/>
                <jsp:useBean id="q" type="Model.Question"/>
                <div class="container-mid">
                    <h2 class="quesnumber">
                        <input type="checkbox" id="cb-${q.questionId}" name="selected-question" value="${q.questionId}">
                        <label for="cb-${q.questionId}">
                            Question ${i + 1}
                        </label>
                        <button type="submit" name="delete" value="${q.questionId}">x</button>
                    </h2>
                    <div class="option-div">${q.content}</div>
                    <jsp:useBean id="displayanswer" scope="request" type="java.util.Map<java.lang.Integer,Model.Answer>"/>
                    <c:forEach items="${displayanswer.get(q.questionId)}" var="a">
                        <div class="formAnswer">
                            <div class="option-div">
                                <label for="radio-${q.questionId}-${a.id}">
                                        ${a.content}
                                </label>
                            </div>
                            <input class="radio" type="radio" id="radio-${q.questionId}-${a.id}"
                                   name="radio-${q.questionId}"
                                   disabled
                                ${a.isCorrectAnswer=="true" ? "checked" : "" }>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
            <div class="button-container">
                <a class="update-button" href="changeQuizDetail?quizid=${q_update.quizId}">Update</a>
                <button class="update-button" type="submit" name="delete-all" value="delete">Delete</button>
            </div>
        </form>
    </div>

</div>
</body>

</html>