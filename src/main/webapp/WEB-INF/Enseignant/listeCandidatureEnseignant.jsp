<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTAN - Liste Candidature</title>
    </head>

    <body>
        <div class="Header">
            <div class="title">Talent Teachers</div>
            <div class="hello">Bonjour Enseignant !</div>
        </div>
    
        <div class="content">
            <div class="message erreur">
                ${messageErreur}
            </div> 
            
            <div class="message info">
                ${messageInfo}
            </div> 

            <form class="Menu" method="post" action="ControleurEnseignant">
                <button type="submit" name="action" value="VoirListePoste" class="element">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element select">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form>

            <div class="liste-candidature-enseignant">
                <c:forEach items="${lEnseignant.listeCandid}" var="candidature">
                    <form class="candidature-enseignant" method="post" action="ControleurEnseignant">
                        <button type="submit" name="action" value="VoirListePoste" class="postuler">Voir poste</button>
            
                        <div class="container-info Statut">
                            <img class="icon-status" src="/ProjetTAN/resources/icons/status.png" />
                            <div class="info">${candidature.decision}</div>
                        </div>
            
                        <div class="title">${candidature.poste.nomPoste}</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                <div class="info">${candidature.poste.ecole.raisonSociale}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/contract.png" />
                                <div class="info">${candidature.poste.typeContrat}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/periode.png" />
                                <div class="info">${candidature.poste.periode}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/class.png" />
                                <div class="info">${candidature.poste.pourNivEtudiant.niveau}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/date.png" />
                                <div class="info">${candidature.dateCandid}</div>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>