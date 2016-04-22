<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Index</title>
    <link rel='stylesheet' href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <style>
        body{
            background-color: #525252;
        }
        .centered-form{
            margin-top: 150px;
        }

        .centered-form .panel{
            background: rgba(255, 255, 255, 0.8);
            box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
        }
    </style>
    <s:head />
</head>
<body>

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-8 col-sm-offset-2">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please sign up NoQueues</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="post" action="singup.action">
                            <div class="form-group">
                                <input type="text" required name="login" id="login" class="form-control input-sm" placeholder="Login">
                            </div>

                            <div class="form-group">
                                <input type="password" required  name="password" id="password" class="form-control input-sm" placeholder="Password">
                            </div>

                            <div class="row">
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" required  name="client.firstname" id="first_name" class="form-control input-sm" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" name="client.secondname" id="second_name" class="form-control input-sm" placeholder="Second name">
                                    </div>
                                </div>
                                <div class="col-xs-4 col-sm-4 col-md-4">
                                    <div class="form-group">
                                        <input type="text" required  name="client.lastname" id="last_name" class="form-control input-sm" placeholder="Last Name">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="email" required name="client.email" id="email" class="form-control input-sm" placeholder="Email Address">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="number" required name="client.phoneNumber" id="number" class="form-control input-sm" placeholder="Phone Number">
                                    </div>
                                </div>

                            </div>

                            <div class="form-group">
                                <input type="text" required name="client.address" id="address" class="form-control input-sm" placeholder="Home Address">
                            </div>

                            <input type="submit" value="Sign Up" class="btn btn-info btn-block">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
