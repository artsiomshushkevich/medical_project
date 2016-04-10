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
<div class="container">
    <h2 align="center">Authorisation</h2>
    <form class="form-inline" role="form" method="post" action="login.action">
        <div class="form-group">
            <label>Login: <input type="name" class="form-control" name="login"></label>
        </div><br>
        <div class="form-group">
            <label>Password: <input type="password" class="form-control" name="password"></label>
        </div><br>
        <button type="submit" class="btn btn-default">Ok</button>
    </form>
</div>

</body>
</html>