<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Admin</title>
    </head>

    <body>
        <div class="Header">
            <div class="title">Talent Teachers</div>
            <div class="hello">Bonjour Admin !</div>
        </div>
  
        <div class="content">
            <form class="Menu" method="post" action="ControleurAdmin">
                <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                <button type="submit" name="action" value="VoirListeRecruteur" class="element select">Liste Recruteurs</button>
                <button type="submit" name="action" value="VoirCreerRecruteur" class="element">Créer Recruteur</button>
                <button type="submit" name="action" value="VoirListeEnseignant" class="element">Liste Enseignants</button>
                <button type="submit" name="action" value="VoirCreerEnseignant" class="element">Créer Enseignant</button>
      
                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form> 
            
            
        </div>
    </body>
</html>