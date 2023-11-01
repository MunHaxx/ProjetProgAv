<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
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
                    <input type="password" class="input-connexion" placeholder="Mot De Passe" name="champPassword" />
                    <input type="submit" name="action" value="Se Connecter" class="se-connecter"/>
                </form>
            </div>
        </div>
    </body>
</html>
