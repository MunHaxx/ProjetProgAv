<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <link href="./style.css" rel="stylesheet">
        <title>ProjetTA - Login</title>
    </head>

    <body>
        <div>
            <div class="Header">
                <div class="title">Talent Teachers</div>
                <div class="hello">Connectez-vous !</div>
            </div>
    
            <div class="content-login">
                <div class="presentation-message">Bienvenue sur la plateforme de recrutement d'enseignant supérieurs</div>
    
                <form action="Controleur" method="post" class="container-input-login">
                    <input class="input-connexion" placeholder="Identifiant" name="champLogin" />
                    <input type="password" class="input-connexion" placeholder="Remarques 3" name="champPassword" />
                    <input type="submit" name="action" value="SeConnecter" class="se-connecter"/>
                </form>
            </div>
        </div>

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
