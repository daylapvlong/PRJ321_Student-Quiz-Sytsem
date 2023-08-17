<%-- Created by IntelliJ IDEA. User: admin's Date: 7/16/2023 Time: 4:25 PM To change this template use File | Settings |
    File Templates. --%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <html>

        <head>
            <title>Title</title>
            <link rel="stylesheet" href="css/result.css">
        </head>

        <body>
            <jsp:include page="Navbar.jsp"></jsp:include>
            <div class="result_header">
                <c:choose>
                    <c:when test="${sessionScope.role eq '1'}">
                        <h1 class="heading">Admin Result</h1>
                    </c:when>
                    <c:otherwise>
                        <h1 class="heading">Student Result</h1>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="quiz_table">
                <table class="quiz_table_content">
                    <thead class="quiz_table_header">
                        <tr>
                            <th scope="col" class="quiz_name">
                                Quiz Name
                            </th>
                            <th scope="col" class="quiz_else">
                                Number of Questions
                            </th>
                            <th scope="col" class="quiz_else">
                                Score
                            </th>
                            <th scope="col" class="quiz_else">
                                Time
                            </th>
                            <th scope="col" class="quiz_else">
                                View details
                            </th>
                    </thead>
                    <tbody>
                        <tr class="quiz_table_body">
                            <th scope="row">
                                PT1
                            </th>
                            <td class="px-6 py-4">
                                20
                            </td>
                            <td class="px-6 py-4">
                                18
                            </td>
                            <td class="px-6 py-4">
                                30.00.00
                            </td>
                            <td class="px-6 py-4">
                                View
                            </td>
                        </tr>

                    </tbody>
                </table>
            </div>
            <jsp:include page="Footer.jsp"></jsp:include>
        </body>

        </html>