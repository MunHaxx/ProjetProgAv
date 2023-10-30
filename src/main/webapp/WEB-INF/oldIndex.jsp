<%--
  Created by IntelliJ IDEA.
  User: Jacques
  Date: 19/09/2023
  Time: 14:26
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <title>Jakarta EE - Login</title>
    </head>

    <body>
        <div class="container" style="margin-top:30px">
            <div class="col-md-4">
                <div style="color:red">
                    ${messageErreur}
                </div>
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login</h3>
                    </div>
                    <div class="panel-body">
                        <form action="Controleur" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Login" name="champLogin" autofocus="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Mot de passe" name="champMotDePasse" type="password">
                                </div>

                                <input type="submit" name="action" value="Login" class="btn btn-primary"/>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
