<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dashboard</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>

<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Dashboard</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <!-- if need a top right link write here -->
            </li>
            <!-- /.dropdown -->
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                    </li>
                    <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <a href="doctor-myinfo.action"><i class="fa fa-dashboard"></i>My info</a>
                </li>
                <li>
                    <a href="doctor-myorders.action"><i class="fa fa-paperclip"></i>My orders</a>
                </li>
                <li>
                    <a class="active-menu" href="doctor-makevisit.action"><i class="fa fa-thumb-tack"></i>Create visit</a>
                </li>
                <li>
                    <a href="doctor-medical-histories.action"><i class="fa fa-medkit"></i>Medical histories</a>
                </li>
                <li>
                    <a href="doctor-myschedule.action"><i class="fa fa-calendar"></i>My schedule</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Create visit by order id
                        </div>
                        <div class="panel-body">
                            <form method="post" action="doctor-visit-add.action">
                                <div class="form-group">
                                    <label>Complaints: <input type="text" required class="form-control" name="visit.complaints"></label>
                                </div>
                                <div class="form-group">
                                    <label>Diagnosys: <input type="text" required  class="form-control" name="visit.diagnosys"></label>
                                </div>
                                <div class="form-group">
                                    <label>Medical history id:
                                        <select class="form-control" name="visit.medicalHistoryId">
                                            <s:iterator value="medicalHistories" var="medicalHistory">
                                                <option value="<s:property value="id"/>"><s:property value="id"/></option>
                                            </s:iterator>
                                        </select>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Order id: <input type="number" required min="1" class="form-control" name="visit.orderId"></label>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-primary add-btn">Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- Morris Chart Js -->
<script src="assets/js/morris/raphael-2.1.0.min.js"></script>
<script src="assets/js/morris/morris.js"></script>
<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>

</html>

