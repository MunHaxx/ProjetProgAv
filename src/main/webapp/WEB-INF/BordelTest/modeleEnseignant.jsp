<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Enseignant</title>
    </head>

    <body>
        <div class="Header">
            <div class="title">Talent Teachers</div>
            <div class="hello">Bonjour Enseignant !</div>
        </div>
    
        <form class="content" method="post" action="ControleurEnseignant">
            <div class="Menu">
                <button type="submit" name="action" value="VoirListePoste" class="element select">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </div>


        </form>
    </body>
</html>