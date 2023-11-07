<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTAN - Mon profil</title>
    </head>

    <body>
        <div>
            <div class="Header">
                <div class="title">Talent Teachers</div>
                <div class="hello">Bonjour ${leRecruteur.prenom} ${leRecruteur.nom} !</div>
            </div>
            
            <form class="content" method="post" action="ControleurRecruteur">
                <input type="hidden" name="data-id" value="${leRecruteur.idRecruteur}">
                
                <div class="message erreur">
                    ${messageErreur}
                </div> 
                
                <div class="message info">
                    ${messageInfo}
                </div> 

                <div class="Menu">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element select">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </div> 

                <div class="container-modif-recruteur">
                    <div class="modif-recruteur">
                        <div class="title-page">Mon profil</div>

                        <div>
                            <div class="container-info">
                                <div class="title-info-case">Nom</div>
                                <input class="info-case" placeholder="Nom" name="champModifNomRecruteur" value="${leRecruteur.nom}"/>

                                <div class="title-info-case droite">Prénom</div>
                                <input class="info-case" placeholder="Prénom" name="champModifPrenomRecruteur" value="${leRecruteur.prenom}"/>
                            </div>
                    
                            <div class="container-button">
                                <button type="submit" name="action" value="SauveModifProfil" class="sauvegarder">Sauvegarder</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
