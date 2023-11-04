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
            <div class="message erreur">
                ${messageErreur}
            </div> 
            
            <div class="message info">
                ${messageInfo}
            </div> 

            <form class="Menu" method="post" action="ControleurAdmin">
                <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                <button type="submit" name="action" value="VoirListeRecruteur" class="element select">Liste Recruteurs</button>
                <button type="submit" name="action" value="VoirCreerRecruteur" class="element">Créer Recruteur</button>
                <button type="submit" name="action" value="VoirListeEnseignant" class="element">Liste Enseignants</button>
                <button type="submit" name="action" value="VoirCreerEnseignant" class="element">Créer Enseignant</button>
        
                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form> 
            
            <div class="liste-recruteur">
                <form class="container-button" method="post" action="ControleurAdmin">
                    <button type="submit" name="action" value="VoirCreerRecruteur" class="button-add">
                        <div class="plus">+</div>
                        <div class="title-button">Ajouter</div>
                    </button>
                </form>

                <c:forEach items="${tousLesRecruteurs}" var="recruteur">
                    <form class="container-recruteur" method="post" action="ControleurAdmin">
                        <input type="hidden" name="data-id" value="${recruteur.idRecruteur}">
                        <button type="submit" name="action" value="VoirCreerRecruteur" class="modifier">Modifier</button>

                        <div class="title-recruteur">Recruteur n°${recruteur.idRecruteur}</div>
            
                        <div class="container-line">
                            <div class="info">${recruteur.nom}</div>
                            <div class="info">${recruteur.prenom}</div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>