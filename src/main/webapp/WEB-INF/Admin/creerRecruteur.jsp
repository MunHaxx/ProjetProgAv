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
            <div class="message erreur">
                ${messageErreur}
            </div> 
            
            <div class="message info">
                ${messageInfo}
            </div> 

            <form class="Menu" method="post" action="ControleurAdmin">
                <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                <button type="submit" name="action" value="VoirListeRecruteur" class="element">Liste Recruteurs</button>
                <button type="submit" name="action" value="VoirCreerRecruteur" class="element select">Créer Recruteur</button>
                <button type="submit" name="action" value="VoirListeEnseignant" class="element">Liste Enseignants</button>
                <button type="submit" name="action" value="VoirCreerEnseignant" class="element">Créer Enseignant</button>
      
                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form> 
            
            <form class="container-modif-recruteur" method="post" action="ControleurAdmin">
                <input type="hidden" name="data-id" value="${leRecruteur.idRecruteur}" />

                <div class="modif-recruteur">
                    <div class="title-page">Profil recruteur</div>

                    <div>
                        <div class="container-info">
                            <div class="title-info-case">Nom</div>
                            <input class="info-case" placeholder="Nom" name="champModifNomRecruteur" value="${leRecruteur.nom}"/>

                            <div class="title-info-case droite">Prénom</div>
                            <input class="info-case" placeholder="Prénom" name="champModifPrenomRecruteur" value="${leRecruteur.prenom}"/>
                        </div>
                
                        <div class="container-button">
                            <button type="submit" name="action" value="SauveRecruteur" class="sauvegarder">Sauvegarder</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>