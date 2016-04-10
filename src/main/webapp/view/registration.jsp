<!DOCTYPE html PUBLIC
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
<<div class="container">
    <h2 align="center">Registration</h2>
    <form class="form-inline" method="post" action="singup.action">
        <div class="form-group">
            <label>Login: <input class="form-control" name="login"></label><br>
            <label>Password: <input type="password" class="form-control" name="password"></label><br>
            <%--  <label>Confirm password: <input type="password" class="form-control" name="user.password"></label><br>--%>
            <button type="submit" class="btn btn-default">Ok</button>
        </div>

    </form>
</div>

</body>
</html>
