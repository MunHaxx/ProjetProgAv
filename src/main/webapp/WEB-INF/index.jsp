<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
    <title>ProjetTAN - Login</title>
</head>

<body>
<div class="Header">
    <div class="title">Talent Teachers</div>
    <div class="hello">Bonjour toto !</div>
</div>

<div class="content">
    <div class="Menu">
        <div class="element select">Listes postes</div>
        <div class="element">Créer postes</div>
        <div class="element">Modif profil</div>

        <div class="deconnexion">Déconnexion</div>
    </div>

    <div class="liste-enseignant">
        <div class="container-button">
            <button class="button-add">
                <div class="plus">+</div>
                <div class="title-button">Ajouter</div>
            </button>
            <button type="submit" name="action" value="+ Ajouter" class="ajouter"/>
        </div>

        <c:forEach var="enseignant" items="${listeEnseignants}">
            <div class="container-enseignant">
                <div class="modifier">Modifier</div>
                <div class="title-enseignant">Enseignant n°<c:out value="${enseignant.idEnseignant}"/></div>

                <div class="container-line">
                    <div class="info"><c:out value="${enseignant.nom}"/></div>
                    <div class="info"><c:out value="${enseignant.prenom}"/></div>
                    <div class="info">Recommandé par ???</div>
                </div>
                <div class="container-line">
                    <div class="info"><c:out value="${enseignant.mail}"/></div>
                    <div class="info"><c:out value="${enseignant.tel}"/></div>
                    <div class="info"><c:out value="${enseignant.siteWeb}"/></div>
                    <div class="info">L3 / M1 / M2</div>
                </div>
            </div>
        </c:forEach>

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
    </div>
</div>
</body>
</html>