<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create Quiz</title>
            <link href="css/Create.css" rel="stylesheet" />
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        </head>

        <body>
            <div class="close-container" id="closeButton" onclick="history.back()">
                <div class="leftright"></div>
                <div class="rightleft"></div>
            </div>

            <div class="createContainer">
                <div class="createContainer_heading">
                    <h1>Create your quiz</h1>
                </div>

                <div class="formWrapper" id="wrapper">
                    <form class="createForm" method="post" action="create" id="form">
                        <div class="questionContainer" id="createTable">
                            <div class="formQuestion">
                                <input class="input" type="text" name="question" placeholder="Question"></textarea>
                            </div>
    
                            <div class="formAnswer" id="createAnswer">
                                <input class="input" type="text" name="option" placeholder="Option" />
                                <input class="radio" type="radio" name="isCorrect">
                                <button class="delete-btn" type="button" onclick="deleteAnswer()"><i class="material-icons" style="font-size:26px">delete</i></button>
                            </div>

                            <button type="button" class="btn-copy" onclick="duplicateAnswer()">New
                                Answer</button>

                            <button type="button" class="btn-copy" onclick="duplicateQuestion()">New
                                Question</button>
                                
                            <button type="button" id='btn-delete' class="btn-copy" onclick="deleteQuestion()">Delete
                                Question</button>


                        </div>



                        <button type="submit" class="btn-submit">Create Quiz</button>
                    </form>
                </div>

                <a href="#" onclick="getAnswerCount()">count answer</a>
            </div>

            <script src="js/create.js"></script>

        </body>

        </html>