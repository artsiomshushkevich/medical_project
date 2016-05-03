<%--
  Created by IntelliJ IDEA.
  User: vitalyorlov
  Date: 19.03.16
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>NoQueues</title>
    <link rel="stylesheet" href="./main-style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <s:head />
</head>
<body>


    <div class="page-container">
        <header class="page-header">
            <h1><i class="fa fa-heartbeat" aria-hidden="true"></i> NoQueues</h1>
            <nav>
                <ul>
                    <c:set var="salary" scope="session" value='<%=session.getAttribute("role")%>'/>
                    <c:if test="${salary eq 'Client'}">
                        <li><a href="client-dashboard.action"><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i> Dashboard</a></li>
                        <li><a href="logout.action"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign out</a></li>
                    </c:if>
                    <c:if test="${salary eq 'Admin'}">
                        <li><a href="adminpanel.action"><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i> Admin panel</a></li>
                        <li><a href="logout.action"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign Out</a></li>
                    </c:if>
                    <c:if test="${salary eq 'Doctor'}">
                        <li><a href="doctor-dashboard.action"><i class="fa fa-arrow-circle-o-right" aria-hidden="true"></i> Dashboard</a></li>
                        <li><a href="logout.action"><i class="fa fa-sign-out" aria-hidden="true"></i> Sign Out</a></li>
                    </c:if>
                    <c:choose>
                        <c:when test="${salary eq null}">
                            <li><a href="registration.action"><i class="fa fa-plug" aria-hidden="true"></i> Sign Up</a></li>
                            <li><a href="authorisation.action"><i class="fa fa-sign-in" aria-hidden="true"></i> Sign In</a></li>
                        </c:when>

                    </c:choose>

                </ul>
            </nav>
        </header>
        <section class="wrapper">
            <input type="radio" name="point" id="slide1" checked>
            <input type="radio" name="point" id="slide2">
            <input type="radio" name="point" id="slide3">
            <div class="slider">
                <div class="slides slide1"></div>
                <div class="slides slide2"></div>
                <div class="slides slide3"></div>
            </div>
            <div class="controls">
                <label for="slide1"></label>
                <label for="slide2"></label>
                <label for="slide3"></label>
            </div>
        </section>

        <section class="reasons">
            <h2>
                Why should you use this service?
            </h2>
            <ul>
                <li>
                    <h3>You won't spend your patience in queues!</h3>
                    <img src="./images/queue.jpg" alt="queue" />
                </li>
                <li>
                    <h3>It will help you to save your time!</h3>
                    <img src="./images/time.jpg" alt="time" />
                </li>
                <li>
                    <h3>Is your card still made of paper?</h3>
                    <img src="./images/olddoc.jpg" alt="old document" />
                </li>
            </ul>
        </section>

        <section class="prepositions">
            <h2>
                What do we offer?
            </h2>
            <ul>
                <li class="preposition1" data-description="1. Fast ticket booking">
                    <i class="fa fa-bolt" aria-hidden="true"></i>
                </li>
                <li class="preposition2" data-description="2. Simplification of doctors work">
                    <i class="fa fa-user-md" aria-hidden="true"></i>
                </li>
                <li class="preposition3" data-description="3. Flexible admnistration">
                    <i class="fa fa-cog" aria-hidden="true"></i>
                </li>
                <li class="preposition4" data-description="3. Tracking your own card">
                    <i class="fa fa-stethoscope" aria-hidden="true"></i>
                </li>
            </ul>
        </section>

        <section class="partners">
            <h2>
                Our partners
            </h2>
            <ul>
                <li>
                    <a href="http://www.bsuir.by/">
                        <img src="./images/bsuir.png" alt="bsuir" />
                    </a>

                </li>
                <li>
                    <a href="http://fksis.bsuir.by/">
                        <img src="./images/fksis.png" alt="fksis" />
                    </a>

                </li>
                <li>
                    <a href="http://www.epam.by/">
                        <img src="./images/epam.png" alt="epam" />
                    </a>

                </li>
            </ul>
        </section>
        <div class="push"></div>
    </div>

    <footer class="page-footer">
        <span>&copy; VetArtDim Systems 2016</span>
        <div class="contacts">
            <ul>
                <li>
                    <a href="http://vk.com/">
                        <i class="fa fa-vk" aria-hidden="true"></i>
                    </a>
                </li>
                <li>
                    <a href="https://www.facebook.com">
                        <i class="fa fa-facebook-square" aria-hidden="true"></i>
                    </a>
                </li>
                <li>
                    <a href="https://twitter.com/">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                </li>
            </ul>
        </div>
    </footer>


</body>
</html>
