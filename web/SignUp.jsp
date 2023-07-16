<%-- Document : SignUp Created on : Jun 1, 2023, 10:10:10 AM Author : admin's --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Sign Up Page</title>

            <!--===============================================================================================-->
            <link rel="stylesheet" type="text/css" href="css/util.css">
            <link rel="stylesheet" type="text/css" href="css/SignUp.css">
            <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

            <!--===============================================================================================-->
        </head>

        <body>
            <div class="limiter">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">New to Quizzle?</h2>
                            
                            <div>
                                ${passmess}
                            </div>
                            
                            <div>
                                ${checkmess}
                            </div>

                            <div>
                                ${radiomess}
                            </div>
                            
                            <div>
                                ${existedmess}
                            </div>
                            
                            <div>
                                ${checkmess}
                            </div>
                            
                            <div>
                                ${mailmess}
                            </div>
                            
                            <div>
                                ${radiomess}
                            </div>
                            
                            <div>
                                ${existedmess}
                            </div>
                            
                            <form method="post" action="signup" class="register-form" id="register-form">

                                <div class="form-group">
                                    <input class="form-control" type="text" name="name" id="name" placeholder="Your Name" required/>
                                    <span class="focus-input100"></span>
                                    <span class=" material-icons-name">
                                        <i class="zmdi zmdi-account"></i>
                                    </span>
                                </div>                              

                                <div class="form-group">
                                    <input class="form-control" type="text" name="email" id=""name="email" id="email" placeholder="Your Email" required/>
                                    <span class="focus-input100"></span>
                                    <span class=" material-icons-name">
                                        <i class="zmdi zmdi-email"></i>
                                    </span>
                                </div>

                                <div class="form-group">
                                    <input class="form-control" type="password" name="password" name="pass" id="pass" placeholder="Password" required/>
                                    <span class="focus-input100"></span>
                                    <span class=" material-icons-name">
                                        <i class="zmdi zmdi-lock"></i>
                                    </span>
                                </div>

                                <div class="form-group">
                                    <input class="form-control" type="password" name="re_pass" id="re_pass"
                                        placeholder="Repeat your password" required/>
                                    <span class="focus-input100"></span>
                                    <span class=" material-icons-name">
                                        <i class="zmdi zmdi-lock-outline"></i>
                                    </span>
                                </div>

                                 <div class="radio_option">
                                    <p>Are your a Student or a Teacher?</p>
                                    <div class="radio_option">
                                        <input type="radio" name="radiogroup" id="rd1" value="0">
                                        <label class="radio_label" for="rd1">Student</label>
                                
                                        <input type="radio" name="radiogroup" id="rd2" value ="1">
                                        <label class="radio_label" for="rd2">Teacher</label>
                                    </div>
                                </div> 

                                <div class="">
                                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                    <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree
                                        all statements in <a href="#" class="term-service">Terms of service</a></label>
                                </div>

                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup" class="form-submit"
                                        value="Register" />
                                </div>

                            </form>
                        </div>
                        <div class="signup-image">
                            <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                            <a href="Login.jsp" class="signup-image-link">I am already member</a>
                        </div>
                    </div>
                </div>
            </div>
        </body>

        </html>