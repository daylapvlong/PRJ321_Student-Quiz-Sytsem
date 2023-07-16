<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Activity</title>
    <link rel="stylesheet" href="css/Course.css">
</head>
<body>
    <!-- demo table -->
    <div class="quiz_table">
        <table class="quiz_table_content">
            <thead
                class="quiz_table_header">
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
                    <th scope="col" class="quiz_else">
                        Points
                    </th>
                    <th scope="col" class="quiz_else">
                        Details
                    </th>
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
                        <td class="px-6 py-4">
                            <p>30/30</p>
                        </td>
                        <td class="px-6 py-4">
                            <a href="#" class="startbtn">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>