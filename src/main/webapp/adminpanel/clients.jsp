<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Clients Table</title>
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
            <a class="navbar-brand" href="../index.jsp">Medical</a>
        </div>

        <ul class="nav navbar-top-links navbar-right">
            <li style="color: white;" class="dropdown">
                <c:set var="salary" scope="session" value='<%=session.getAttribute("login")%>'/>
                <c:out value="${salary}"/>
            </li>
            <!-- /.dropdown -->
            <!-- /.dropdown -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="homepage.action"><i class="fa fa-home fa-fw"></i>Homepage</a>
                    </li>
                    <li class="divider"></li>
                    <li><a href="logout.action"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                    <a href="index.jsp"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a href="users-index.action"><i class="fa fa-users"></i>Users</a>
                </li>
                <li>
                    <a href="visits-index.action"><i class="fa fa-thumb-tack"></i>Visits</a>
                </li>
                <li>
                    <a href="treatments-index.action"><i class="fa fa-medkit"></i>Treatments</a>
                </li>
                <li>
                    <a href="schedules-index.action"><i class="fa fa-calendar"></i>Schedules</a>
                </li>
                <li>
                    <a href="orders-index.action"><i class="fa fa-paperclip"></i>Orders</a>
                </li>
                <li>
                    <a href="medical-histories-index.action"><i class="fa fa-book"></i>Medical histories</a>
                </li>
                <li>
                    <a href="doctors-index.action"><i class="fa fa-user-md"></i>Doctors</a>
                </li>
                <li>
                    <a href="departments-index.action"><i class="fa fa-hospital-o"></i>Departments</a>
                </li>
                <li>
                    <a class="active-menu" href="clients-index.action"><i class="fa fa-user"></i>Clients</a>
                </li>
                <li>
                    <a href="cures-index.action"><i class="fa fa-plus-square"></i>Cures</a>
                </li>
                <li>
                    <a href="analyses-index.action"><i class="fa fa-pencil-square-o"></i>Analyses</a>
                </li>

            </ul>

        </div>

    </nav>
    <%@include file='clients-modal-add.jsp'%>
    <%@include file='clients-modal-edit.jsp'%>
    <%@include file='clients-modal-delete.jsp'%>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- Table -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Clients
                        </div>
                        <div class="panel-body">
                            <div class="container">
                                <button class="btn btn-primary" onclick="showAddModal()">Add new client</button>
                            </div>

                            <div class="table-responsive">
                                <p>Clients list:</p>
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>user id</th>
                                        <th>first name</th>
                                        <th>second name</th>
                                        <th>last name</th>
                                        <th>phone number</th>
                                        <th>address</th>
                                        <th>email</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="clientsList" var="client">
                                        <tr>
                                            <td><s:property value="id"></s:property></td>
                                            <td><s:property value="userId"></s:property></td>
                                            <td><s:property value="firstname"></s:property></td>
                                            <td><s:property value="secondname"></s:property></td>
                                            <td><s:property value="lastname"></s:property></td>
                                            <td><s:property value="phoneNumber"></s:property></td>
                                            <td><s:property value="address"></s:property></td>
                                            <td><s:property value="email"></s:property></td>
                                            <td>
                                                <button class="btn btn-link"
                                                        id="<s:property value="id"/>"
                                                        userId="<s:property value="userId"/>"
                                                        firstname="<s:property value="firstname"/>"
                                                        secondname="<s:property value="secondname"/>"
                                                        lastname="<s:property value="Lastname"/>"
                                                        phoneNumber="<s:property value="phoneNumber"/>"
                                                        address="<s:property value="address"/>"
                                                        email="<s:property value="email"/>"
                                                        onclick="showEditModal(this)">update</button>
                                                &middot;
                                                <button class="btn btn-link" id_instance="<s:property value="id"/>" onclick="showDeleteModal(this)">delete</button>
                                            </td>
                                        </tr>
                                    </s:iterator>
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

<script>
    function showAddModal()
    {
        $('.clients_add_modal').modal();
    }

    function showEditModal(instance)
    {
        $('#clients_edit_id').val($(instance).attr('id'));
        $('#clients_edit_userId').val($(instance).attr('userId'));
        $('#clients_edit_firstname').val($(instance).attr('firstname'));
        $('#clients_edit_secondname').val($(instance).attr('secondname'));
        $('#clients_edit_lastname').val($(instance).attr('lastname'));
        $('#clients_edit_phoneNumber').val($(instance).attr('phoneNumber'));
        $('#clients_edit_address').val($(instance).attr('address'));
        $('#clients_edit_email').val($(instance).attr('email'));
        $('.clients_edit_modal').modal();
    }

    function showDeleteModal(instance)
    {
        var id = $(instance).attr('id_instance');
        $('#clients_delete_id').val(id);
        $('.clients_delete_modal').modal();
    }
</script>
</body>

</html>
