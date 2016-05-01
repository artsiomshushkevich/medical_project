<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Orders Table</title>
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
                    <a class="active-menu" href="orders-index.action"><i class="fa fa-paperclip"></i>Orders</a>
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
                    <a href="clients-index.action"><i class="fa fa-user"></i>Clients</a>
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
    <%@include file='orders-modal-add.jsp'%>
    <%@include file='orders-modal-edit.jsp'%>
    <%@include file='orders-modal-delete.jsp'%>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!-- Table -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Orders
                        </div>
                        <div class="panel-body">
                            <div class="container">
                                <button class="btn btn-primary" onclick="showAddModal()">Add new order</button>
                            </div>

                            <div class="table-responsive">
                                <p>Order list:</p>
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>client fullname</th>
                                        <th>date</th>
                                        <th>doctor fullname</th>
                                        <th>begin time</th>
                                        <th>actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="ordersList" var="order">
                                        <tr>
                                            <td><s:property value="id"></s:property></td>
                                            <td><s:property value="clientFullname"></s:property></td>
                                            <td><s:property value="dateInString"></s:property></td>
                                            <td><s:property value="doctorFullname"></s:property></td>
                                            <td><s:property value="beginTimeInString"></s:property></td>
                                            <td>
                                                <button class="btn btn-link"
                                                        id="<s:property value="id"/>"
                                                        clientId="<s:property value="clientId"/>"
                                                        doctorId="<s:property value="doctorId"/>"
                                                        dateInString="<s:property value="dateInString"/>"
                                                        beginTimeInString="<s:property value="beginTimeInString"/>"
                                                        onclick="showEditModal(this)">update</button>
                                                &middot;
                                                <button class="btn btn-link" id_instance="<s:property value="id"/>" onclick="showDeleteModal(this)">delete</button>
                                                &middot;
                                                <a href="/generateOrderPDF.action?id=<s:property value="id"/>">PDF</a>
                                                &middot;
                                                <a href="/generateOrdersXLS.action">XLS</a>
                                                &middot;
                                                <a href="/generateOrdersCSV.action">CSV</a>
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
        $('.orders_add_modal').modal();
    }

    function showEditModal(instance)
    {
        $('#orders_edit_clientId option').removeAttr('selected');
        $('#orders_edit_clientId option[value=' + $(instance).attr('clientId') + ']').attr('selected', 'selected');

        $('#orders_edit_doctorId option').removeAttr('selected');
        $('#orders_edit_doctorId option[value=' + $(instance).attr('doctorId') + ']').attr('selected', 'selected');

        $('#orders_edit_id').val($(instance).attr('id'));
        $('#orders_edit_dateInString').val($(instance).attr('dateInString'));
        $('#orders_edit_beginTimeInString').val($(instance).attr('beginTimeInString'));
        $('.orders_edit_modal').modal();
    }

    function showDeleteModal(instance)
    {
        $('#orders_delete_id').val($(instance).attr('id'));
        $('.orders_delete_modal').modal();
    }
</script>
</body>

</html>