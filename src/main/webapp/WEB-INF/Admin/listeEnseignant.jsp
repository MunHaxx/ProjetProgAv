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
            <div class="hello">Bonjour toto !</div>
        </div>
    
        <form class="content" method="post" action="ControleurEnseignant">
            <div class="Menu">
                <button type="submit" name="action" value="VoirListePoste" class="element select">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </div>
            
            <div class="liste-enseignant" >
                <div class="container-button">
                    <button class="button-add">
                        <div class="plus">+</div>
                        <div class="title-button">Ajouter</div>
                    </button>
                    <button type="submit" name="action" value="+ Ajouter" class="ajouter"/>
                </div>
        
                <c:forEach items="${tousLesEmployes}" var="employe">
                    <div class="container-enseignant">
                        <div class="modifier">Modifier</div>
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
                    </div>
                </c:forEach>
                
            </div>
        </form>
    </body>
</html>