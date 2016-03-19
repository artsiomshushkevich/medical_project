<<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Index</title>
    <link rel='stylesheet' href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">

    <s:head />
</head>
<body>
<div class="container">
    <h2 align="center">ADD</h2>
    <form class="form-inline" role="form" method="post" action="/add.action">
        <div class="form-group">
            <label>Nickname: <input type="name" class="form-control" name="user.nickname"></label>
        </div>
        <div class="form-group">
            <label>Password: <input type="password" class="form-control" name="user.password"></label>
        </div>
        <button type="submit" class="btn btn-default">Add</button>
    </form>
</div>

<div class="container">
    <h2 align="center">Update</h2>
    <form class="form-inline" role="form" method="post" action="/update.action">
        <div class="form-group">
            <label>Id: <input type="name" class="form-control" name="user.id"></label>
        </div>
        <div class="form-group">
            <label>Nickname: <input type="name" class="form-control" name="user.nickname"></label>
        </div>
        <div class="form-group">
            <label>Password: <input type="password" class="form-control" name="user.password"></label>
        </div>
        <button type="submit" class="btn btn-default">Update</button>
    </form>
</div>

<div class="container">
    <h2 align="center">Users:</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>nickname</th>
            <th>password</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="usersList" var="user">
            <tr>
                <td><s:property value="id"></s:property></td>
                <td><s:property value="nickname"></s:property></td>
                <td><s:property value="password"></s:property></td>
                <td>
                    <a href="/delete.action?id=<s:property value="id"/>">delete</a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
</body>
</html>
