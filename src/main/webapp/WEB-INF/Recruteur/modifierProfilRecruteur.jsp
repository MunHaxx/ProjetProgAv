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
                <div class="hello">Bonjour Recruteur !</div>
            </div>
            
            <div class="content">
                <form class="Menu" method="post" action="ControleurRecruteur">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element select">Modifier profil</button>
            
                    <div type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</div>
                </form> 

                <div class="container-modif-recruteur">
                    <div class="modif-recruteur">
                        <div class="title-page">Mon profil</div>

                        <form action="Controleur" method="post">
                            <div class="container-info">
                                <div class="title-info-case">Nom</div>
                                <input class="info-case" placeholder="Nom" name="champNom" autofocus="" />

                                <div class="title-info-case droite">Prénom</div>
                                <input class="info-case" placeholder="Prénom" name="champPrenom" />
                            </div>
                    
                            <div class="container-button">
                                <input type="submit" name="action" value="Sauvegarder" class="sauvegarder"/>
                            </div>
                        </form>
                    </div>
                  </div>
            </div>
        </div>
    </body>
</html>
