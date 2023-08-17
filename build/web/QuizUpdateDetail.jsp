<%-- Document : Quiz Created on : Jun 13, 2023, 1:11:04 PM Author : admin's --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="css/QuizUpdateDetail.css" rel="stylesheet"/>
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
        <form action="changeQuizDetail" method="post">
            <input type="hidden" name="quizId" value="${q_update.quizId}">
            <div class="header">
                <div class="number-of-count">
                    <label>
                        <input type="text" class="option-div" name="quizname" placeholder="Enter quiz name"
                               value="${q_update.quizName}">
                    </label>
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

            <div class="all-questions-wrapper">
            <jsp:useBean id="displayquiz" scope="request" type="java.util.List<Model.Question>"/>
            <c:forEach begin="0" end="${displayquiz.size() - 1}" var="i">
                <c:set var="q" value="${displayquiz.get(i)}"/>
                <jsp:useBean id="q" type="Model.Question"/>
                <div class="question-wrapper container-mid" id="question-${q.questionId}">
                    <h2 class="quesnumber">
                        Question ${i + 1}
                    </h2>
                    <div class="option-div">
                        <input type="hidden" name="questionId" value="${q.questionId}">
                        <label class="option-label">
                            <input type="text" name="question-content-${q.questionId}" value="${q.content}"/>
                        </label>
                    </div>
                    <jsp:useBean id="displayanswer" scope="request"
                                 type="java.util.Map<java.lang.Integer,Model.Answer>"/>
                    <c:forEach items="${displayanswer.get(q.questionId)}" var="a">
                        <div class="formAnswer" id="ans-${q.questionId}-${a.id}">
                            <label for="delete-answer-${q.questionId}-${a.id}"
                                   onclick="removeAnswer(${a.id},${q.questionId}, true)"
                            >
                                x
                            </label>
                            <div class="option-div">
                                <input type="hidden" name="answer-id-${q.questionId}" class="answer-id-${q.questionId}"
                                       value="${a.id}">
                                <label>
                                    <input
                                            type="text" name="answer-content-${q.questionId}"
                                            value="${a.content}"/>
                                </label>
                            </div>
                            <label>
                                <input class="radio" type="radio"
                                       name="radio-${q.questionId}"
                                       value="${a.id}"
                                    ${a.isCorrectAnswer=="true" ? "checked" : "" }>
                            </label>
                        </div>
                    </c:forEach>
                </div>
                <button type="button" class="add-answer" onclick="addAnswer(${q.questionId})">Add answer</button>
            </c:forEach>
            </div>
            <div class="button-container">
                <button class="update-button" type="submit">Update</button>
                <button class="update-button" type="button" onclick="addQuestion()">Add Question</button>
            </div>
        </form>
    </div>

</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"
        integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    removeAnswer = (aid, qid, addHidden) => {
        $('#ans-' + qid + '-' + aid).after(addHidden ? '<input type="hidden" name="delete-answer-id" value="' + aid + '">' : '').remove();

    }

    addAnswer = (qid) => {
        let aid = +$('.answer-id-' + qid + ':last').val() + 1;
        aid = aid ? aid : 1;
        const answerFormTemplate = '<div class="formAnswer" id="ans-' + qid + '-' + aid + '">\n                            <label\n                                 onclick="removeAnswer(' + aid + ',' + qid + ',false)">\n                                 x\n                            </label>\n                            <div class="option-div">\n <input type="hidden" name="added-answer-id-' + qid + '" class="answer-id-' + qid + '" value="' + aid + '">                               <label>\n                                    <input\n                                        type="text" name="added-answer-content-' + qid + '"/>\n                                </label>\n                            </div>\n                            <label>\n                                <input class="radio" type="radio"\n                                       name="radio-' + qid + '" value="' + aid + '"/>\n                            </label>\n                        </div>';
        $('#question-' + qid).append(answerFormTemplate);
    }

    addQuestion = () => {
        const num = $('.question-wrapper').length;
        const qid = +num + 999;
        const template = '<div class="question-wrapper container-mid" id="question-'+ qid + '" >\n' +
            '<h2 class="quesnumber">\n' +
            'Question ' + (num + 1) +'\n' +
            '</h2> \n' +
            '<div class="option-div"> \n' +
            '<input type="hidden" name="added-questionId" value="'+qid+'">\n' +
            '<label><input type="text" name="added-question-content-'+qid+'" value="Default question"/> </label>\n' +
            '</div>\n' +
            '</div>\n' +
            '<button type="button" class="add-answer" onclick="addAnswer('+qid+')">Add answer</button>';

        $('.all-questions-wrapper').append(template);

    }
</script>
</body>

</html>