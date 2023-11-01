<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Login</title>
    </head>

    <body>
        <div class="Header">
            <div class="title">Talent Teachers</div>
            <div class="hello">Bonjour Admin !</div>
          </div>
    
          <div class="content">
            <form class="Menu" method="post" action="ControleurAdmin">
              <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
              <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
              <button type="submit" name="action" value="VoirModifierProfilRecruteur" class="element">Modifier profil</button>
    
              <div type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</div>
            </form> 
            
            <form class="liste-recruteur" method="post" action="ControleurAdmin">
                <div class="container-button">
                    <button class="button-add">
                        <div class="plus">+</div>
                        <div class="title-button">Ajouter</div>
                    </button>
                    <button type="submit" name="action" value="+ Ajouter" class="ajouter">
                </div>

                <c:forEach items="${tousLesRecruteurs}" var="recruteur">
                    <div class="container-recruteur">
                        <button class="modifier">Modifier</button>
                        <div class="title-recruteur">Recruteur n°${recruteur.idRecruteur}</div>
            
                        <div class="container-line">
                            <div class="info">${recruteur.nom}</div>
                            <div class="info">${recruteur.prenom}</div>
                        </div>
                    </div>
                </c:forEach>
            </form>
          </div>
    </body>
</html>