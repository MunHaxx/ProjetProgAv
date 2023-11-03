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
                <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                <button type="submit" name="action" value="VoirListeRecruteur" class="element">Liste Recruteurs</button>
                <button type="submit" name="action" value="VoirCreerRecruteur" class="element">Créer Recruteur</button>
                <button type="submit" name="action" value="VoirListeEnseignant" class="element select">Liste Enseignants</button>
                <button type="submit" name="action" value="VoirCreerEnseignant" class="element">Créer Enseignant</button>
        
                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form> 
            
            <div class="liste-enseignant" method="post" action="ControleurAdmin">
                <form class="container-button">
                    <button type="submit" name="action" value="VoirCreerEnseignant" class="button-add">
                        <div class="plus">+</div>
                        <div class="title-button">Ajouter</div>
                    </button>
                </form>
        
                <c:forEach items="${tousLesEnseignants}" var="enseignant">
                    <form class="container-enseignant" method="post" action="ControleurAdmin">
                        <input type="hidden" name="data-id" value="${enseignant.idEnseignant}">
                        <button type="submit" name="action" value="VoirCreerEnseignant" class="modifier">Modifier</button>

                        <div class="title-enseignant">Enseignant n°N</div>
            
                        <div class="container-line">
                            <div class="info">Nom</div>
                            <div class="info">Prenom</div>
                            <div class="info">Recommandé par</div>
                        </div>

                        <div class="container-line">
                            <div class="info">Mail.mon.test@gmail.com</div>
                            <div class="info">0102030405</div>
                            <div class="info">truc-de-test.com</div>
                            <div class="info">L3 / M1 / M2</div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>