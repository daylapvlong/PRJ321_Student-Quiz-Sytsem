<%-- Document : WelcomePage Created on : Jun 13, 2023, 8:59:27 AM Author : admin's --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link rel="stylesheet" href="css/welcome.css">
            <link href="css/util/bootstrap.min.css" rel="stylesheet">
        </head>

        <body>
            <jsp:include page="Navbar.jsp"></jsp:include>

            <div class="container-xxl py-6" id="about">
                <div class="container">
                    <div class="row g-5 flex-column-reverse flex-lg-row">
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                            <h1 class="mb-4">Manage & Push Your Business To The Next Level</h1>
                            <p class="mb-4">Diam dolor diam ipsum et tempor sit. Aliqu diam amet diam et eos labore.
                                Clita erat ipsum et lorem et sit, sed stet no labore lorem sit clita duo justo eirmod
                                magna dolore erat amet</p>
                            <div class="d-flex mb-4">
                                <div class=" btn-square rounded-circle text-white" style="background-color: #4AC4F3">
                                    <i class="fa fa-check"></i>
                                </div>
                                <div class="ms-4">
                                    <h5>First Working Process</h5>
                                    <p class="mb-0">Aliqu diam amet diam et eos labore. Clita erat ipsum et lorem et
                                        sit, sed stet no labore lorem sit clita duo justo magna</p>
                                </div>
                            </div>
                            <div class="d-flex mb-4">
                                <div class=" btn-square rounded-circle text-white" style="background-color: #4AC4F3">
                                    <i class="fa fa-check"></i>
                                </div>
                                <div class="ms-4">
                                    <h5>24/7 Hours Support</h5>
                                    <p class="mb-0">Aliqu diam amet diam et eos labore. Clita erat ipsum et lorem et
                                        sit, sed stet no labore lorem sit clita duo justo magna</p>
                                </div>
                            </div>
                            <a href="${sessionScope.acc == null ? 'Login.jsp' : 'home'}"
                                class="btn btn-primary py-sm-3 px-sm-5 rounded-pill mt-3">View our Courses</a>
                        </div>
                        <div class="col-lg-6">
                            <img class="img-fluid rounded wow zoomIn" data-wow-delay="0.5s" src="img/about.jpg">
                        </div>
                    </div>
                </div>
            </div>

            <!-- Feature Start -->
            <div class="container-xxl py-6">
                <div class="container">
                    <div class="row g-4">
                        <div class="col-lg-4 wow fadeInUp" data-wow-delay="0.1s">
                            <div class="feature-item bg-light rounded text-center p-5">
                                <i class="fa fa-4x fa-edit text-primary mb-4"></i>
                                <h5 class="mb-3">Fully Customizable</h5>
                                <p class="m-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam
                                    stet diam sed stet.</p>
                            </div>
                        </div>
                        <div class="col-lg-4 wow fadeInUp" data-wow-delay="0.3s">
                            <div class="feature-item bg-light rounded text-center p-5">
                                <i class="fa fa-4x fa-regular fa-user text-primary mb-4"></i>
                                <h5 class="mb-3">User Friendly</h5>
                                <p class="m-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam
                                    stet diam sed stet.</p>
                            </div>
                        </div>
                        <div class="col-lg-4 wow fadeInUp" data-wow-delay="0.5s">
                            <div class="feature-item bg-light rounded text-center p-5">
                                <i class="fa fa-4x fa-solid fa-link text-primary mb-4"></i>
                                <h5 class="mb-3">Easy Management</h5>
                                <p class="m-0">Erat ipsum justo amet duo et elitr dolor, est duo duo eos lorem sed diam
                                    stet diam sed stet.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Feature End -->

            <!-- Overview Start -->
            <div class="container-xxl bg-light my-6 py-5" id="overview">
                <div class="container">
                    <div class="row g-5 py-5 align-items-center">
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img class="img-fluid rounded" src="img/overview-1.jpg">
                        </div>
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                            <div class="d-flex align-items-center mb-4">
                                <h1 class="mb-0">01</h1>
                                <span class="bg-primary mx-2" style="width: 30px; height: 2px;"></span>
                                <h5 class="mb-0">App Integration</h5>
                            </div>
                            <p class="mb-4">Diam dolor diam ipsum et tempor sit. Aliqu diam amet diam et eos labore.
                                Clita erat ipsum et lorem et sit, sed stet no labore lorem sit clita duo justo eirmod
                                magna dolore erat amet</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>Fully customizable</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>User friendly interface</p>
                            <p class="mb-0"><i class="fa fa-check-circle text-primary me-3"></i>More effective &
                                poerwfull</p>
                        </div>
                    </div>
                    <div class="row g-5 py-5 align-items-center flex-column-reverse flex-lg-row">
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                            <div class="d-flex align-items-center mb-4">
                                <h1 class="mb-0">02</h1>
                                <span class="bg-primary mx-2" style="width: 30px; height: 2px;"></span>
                                <h5 class="mb-0">App Customization</h5>
                            </div>
                            <p class="mb-4">Diam dolor diam ipsum et tempor sit. Aliqu diam amet diam et eos labore.
                                Clita erat ipsum et lorem et sit, sed stet no labore lorem sit clita duo justo eirmod
                                magna dolore erat amet</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>Fully customizable</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>User friendly interface</p>
                            <p class="mb-0"><i class="fa fa-check-circle text-primary me-3"></i>More effective &
                                poerwfull</p>
                        </div>
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img class="img-fluid rounded" src="img/overview-2.jpg">
                        </div>
                    </div>
                    <div class="row g-5 py-5 align-items-center">
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                            <img class="img-fluid rounded" src="img/overview-3.jpg">
                        </div>
                        <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                            <div class="d-flex align-items-center mb-4">
                                <h1 class="mb-0">03</h1>
                                <span class="bg-primary mx-2" style="width: 30px; height: 2px;"></span>
                                <h5 class="mb-0">App Modification</h5>
                            </div>
                            <p class="mb-4">Diam dolor diam ipsum et tempor sit. Aliqu diam amet diam et eos labore.
                                Clita erat ipsum et lorem et sit, sed stet no labore lorem sit clita duo justo eirmod
                                magna dolore erat amet</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>Fully customizable</p>
                            <p><i class="fa fa-check-circle text-primary me-3"></i>User friendly interface</p>
                            <p class="mb-0"><i class="fa fa-check-circle text-primary me-3"></i>More effective &
                                poerwfull</p>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Overview End -->

            <jsp:include page="Footer.jsp"></jsp:include>
        </body>

        </html>