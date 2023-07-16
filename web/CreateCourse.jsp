<%-- Document : Update.jsp Created on : Jun 18, 2023, 4:50:31 PM Author : admin's --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
             <!--===============================================================================================-->
             <link rel="stylesheet" type="text/css" href="css/util.css">
             <link rel="stylesheet" href="css/UpdateCourse.css">
        </head>

        <body>
            <body>
                <div class="limiter">
                    <div class="container-update100">
                        <div class="wrap-update100">
                            <form action="createCourse" method="post" class="update100-form validate-form">
                                <div class="form-header">
                                    <div class="close-container" onclick="history.back()">
                                        <div class="leftright"></div>
                                        <div class="rightleft"></div>
                                    </div>
                                    <span class="update100-form-title">
                                        Creating Course
                                    </span>
                                </div>

                                <div>
                                    ${namemess}
                                </div>
                                
                                <div>
                                    ${desmess}
                                </div>
    
                                <div>
                                    ${radiomess}
                                </div>

                                <div>
                                    ${checkmess}
                                </div>
                                
                                <p class="form-heading">Enter your course name: </p>
                                <div class="wrap-input100 validate-input">
                                    <input class="input100" type="text" name="courseName" id="name" required>
                                </div>
    
                                <p class="form-heading">Write a description: </p>
                                <div class="wrap-input100 validate-input">
                                    <input class="input100" type="text" name="description" id="description" required>
                                </div>
    
                                <p class="form-heading">Select semester: </p>
                                <div class="wrap-input100">
                                    <input type="radio" value="1" name="semester">
                                    <label for="semester1">Semester 1</label>
                                    <input type="radio" value="2" name="semester">
                                    <label for="semester2">Semester 2</label>
                                    <input type="radio" value="3" name="semester">
                                    <label for="semester3">Semester 3</label>
                                    <input type="radio" value="4" name="semester">
                                    <label for="semester4">Semester 4</label>
                                </div>
                                <div class="container-update100-form-btn">
                                    <button class="update100-form-btn" type="submit">Create Course</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
    
                <!--===============================================================================================-->
                <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
                <!--===============================================================================================-->
                <script src="vendor/bootstrap/js/popper.js"></script>
                <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
                <!--===============================================================================================-->
                <script src="vendor/select2/select2.min.js"></script>
                <!--===============================================================================================-->
                <script src="vendor/tilt/tilt.jquery.min.js"></script>
                
            </body>
        </body>
            
        </html>