<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a class="active-menu" href="client-myinfo.action"><i class="fa fa-dashboard"></i>My info</a>
                </li>
                <li>
                    <a href="client-myorders.action"><i class="fa fa-paperclip"></i>My orders</a>
                </li>
                <li>
                    <a href="client-makeorder.action"><i class="fa fa-thumb-tack"></i>Make order</a>
                </li>
                <li>
                    <a href="client-mymedicalhistory.action"><i class="fa fa-medkit"></i>My medical history</a>
                </li>
                <li>
                    <a href="client-myanalyses.action"><i class="fa fa-calendar"></i>Analyse</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- Table -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            My info
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <p>Information about me:</p>
                                <table class="table table-striped table-hover">
                                    <tbody>
                                    <tr>
                                        <td>Login: </td>
                                        <td><s:property value="client.login"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Firstname: </td>
                                        <td><s:property value="client.firstname"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Secondname: </td>
                                        <td><s:property value="client.secondname"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Lastname: </td>
                                        <td><s:property value="client.lastname"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Phone number: </td>
                                        <td><s:property value="client.phoneNumber"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Address: </td>
                                        <td><s:property value="client.address"></s:property></td>
                                    </tr>
                                    <tr>
                                        <td>Email: </td>
                                        <td><s:property value="client.email"></s:property></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
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


