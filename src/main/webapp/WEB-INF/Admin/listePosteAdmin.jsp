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
                <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
                <button type="submit" name="action" value="VoirListeRecruteur" class="element">Liste Recruteurs</button>
                <button type="submit" name="action" value="VoirCreerRecruteur" class="element">Créer Recruteur</button>
                <button type="submit" name="action" value="VoirListeEnseignant" class="element">Liste Enseignants</button>
                <button type="submit" name="action" value="VoirCreerEnseignant" class="element">Créer Enseignant</button>
        
                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </form> 
            
            <div class="liste-poste-recruteur">
                <c:forEach items="${tousLesPostes}" var="poste">
                    <form class="poste-recruteur" method="post" action="ControleurAdmin">

                        <input type="hidden" name="data-id" value="${poste.idPoste}">
                        <button type="submit" name="action" value="VoirListeCandidature" class="postuler">Voir candidature</button>

                        <div class="title">${poste.nomPoste}</div>

                        <div class="container-infos">
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                <div class="info">${poste.ecole.raisonSociale}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/contract.png" />
                                <div class="info">${poste.typeContrat}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/periode.png" />
                                <div class="info">${poste.periode}</div>
                            </div>
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/class.png" />
                                <div class="info">${poste.pourNivEtudiant.niveau}</div>
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