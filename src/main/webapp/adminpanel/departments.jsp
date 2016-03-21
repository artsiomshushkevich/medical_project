<%--
  Created by IntelliJ IDEA.
  User: vitalyorlov
  Date: 20.03.16
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@taglib prefix="s" uri="/struts-tags" %>

        <!DOCTYPE html>
        <html xmlns="http://www.w3.org/1999/xhtml">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Users Table</title>
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
                    <a href="index.jsp"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Users</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Visits</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Treatments</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Specializations</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Schedules</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Prescriptions</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Orders</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Medical histories</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Doctors</a>
                </li>
                <li>
                    <a class="active-menu" href="index.action"><i class="fa fa-desktop"></i>Departments</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Clients</a>
                </li>
                <li>
                    <a href="index.action"><i class="fa fa-desktop"></i>Analyses</a>
                </li>

            </ul>

        </div>

    </nav>
    <%@include file='departments-modal-add.jsp'%>
    <%@include file='departments-modal-edit.jsp'%>
    <%@include file='departments-modal-delete.jsp'%>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- Table -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Departments:
                        </div>
                        <div class="panel-body">
                            <div class="container">
                                <button class="btn btn-primary" onclick="showAddModal()">Add new department</button>
                            </div>

                            <div class="table-responsive">
                                <p>Departments list:</p>
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>name</th>
                                        <th>address</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="departmentsList" var="department">
                                        <tr>
                                            <td><s:property value="id"></s:property></td>
                                            <td><s:property value="name"></s:property></td>
                                            <td><s:property value="address"></s:property></td>
                                            <td>
                                                <button class="btn btn-link" id_instance="<s:property value="id"/>" onclick="showEditModal(this)">update</button>
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
        $('.departments_add_modal').modal();
    }

    function showEditModal(instance)
    {
        var id = $(instance).attr('id_instance');
        $('#departments_edit_id').val(id);
        $('.departments_edit_modal').modal();
    }

    function showDeleteModal(instance)
    {
        var id = $(instance).attr('id_instance');
        $('#departments_delete_id').val(id);
        $('.departments_delete_modal').modal();
    }
</script>
</body>

</html>