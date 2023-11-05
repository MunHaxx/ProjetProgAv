<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Enseignant</title>
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
                <button type="submit" name="action" value="VoirListePoste" class="element select">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form>

            <div class="liste-poste-employe">
                <c:forEach items="${tousLesPostes}" var="poste">
                    <form class="poste-employe" method="post" action="ControleurEnseignant">
                        <input type="hidden" name="data-id" value="${poste.idPoste}">
                        <button type="submit" name="action" value="Postuler" class="postuler">Postuler</button>

                        <div class="title">${poste.nomPoste}</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                <div class="info">${poste.ecole.raisonSociale}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/periode.png" />
                                <div class="info">${poste.ecole.periode}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/contract.png" />
                                <div class="info">${poste.ecole.typeContrat}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/class.png" />
                                <div class="info">${poste.ecole.pourNivEtudiant.niveau}</div>
                            </div>
                        </div>
            
                        <div class="container-points">
                            <div class="title-point">Compétences</div>
                            <ul>
                                <c:forEach items="${poste.listeCompetences}" var="competence">
                                    <li class="point">${competence.nomCompetence}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Contraintes</div>
                            <ul>
                                <c:forEach items="${poste.listeContraintes}" var="contrainte">
                                    <li class="point">${contrainte.nomContrainte}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Remarques</div>
                            <ul>
                                <c:forEach items="${poste.listeRemarques}" var="remarque">
                                    <li class="point">${remarque.nomRemarque}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </body>
</html>