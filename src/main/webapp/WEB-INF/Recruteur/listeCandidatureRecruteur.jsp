<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Login</title>
    </head>

    <body>
        <script src="/ProjetTAN/resources/js/script.js"></script>

        <div>
            <div class="Header">
                <div class="title">Talent Teachers</div>
                <div class="hello">Bonjour ${leRecruteur.prenom} ${leRecruteur.nom} !</div>
            </div>
            
            <div class="content">
                <div class="message erreur">
                    ${messageErreur}
                </div> 
                
                <div class="message info">
                    ${messageInfo}
                </div> 

                <form class="Menu" method="post" action="ControleurRecruteur">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </form> 

                <div class="liste-candidature-recruteur">
                    <c:forEach items="${toutesLesCandidatures}" var="candidature">
                        <form class="container-candidature-recruteur" method="post" action="ControleurRecruteur">
                            <input type="hidden" name="data-id" value="${candidature.idCandidature}">

                            <div class="container-infos-candidature">
                                <button type="submit" name="action" value="AccepterCandidature" class="action-button accepter">Accepter</button>
                                <button type="submit" name="action" value="RejeterCandidature" class="action-button rejeter">Rejeter</button>
                                <div class="title-candidature">Candidature n°${candidature.idCandidature}</div>

                                <div class="container-line">
                                    <div class="infos">
                                        <div class="info">${candidature.enseignant.nom}</div>
                                        <div class="info">${candidature.enseignant.mail}</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">${candidature.enseignant.prenom}</div>
                                        <div class="info">${candidature.enseignant.telephone}</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">${candidature.dateCandid}</div>
                                        <div class="info">${candidature.enseignant.siteWeb}</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">${candidature.enseignant.recoParEcole.raisonSociale}${candidature.enseignant.recoParRecruteur.prenom} ${candidature.enseignant.recoParRecruteur.nom}</div>
                                        <div class="info">${candidature.enseignant.prefereNivEtudiant.niveau}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="agrandir" onclick="changeClass(this)">Agrandir</div>
                            
                            <div class="container-listes">
                                <div class="container-liste">
                                    <div class="title-liste">Activités</div>
                
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.listeActivites}" var="activite">
                                            <li class="point">${activite.nomActivite}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                
                                <div class="container-liste">
                                    <div class="title-liste">Intérêts</div>
                
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.listeInterets}" var="interet">
                                            <li class="point">${interet.nomInteret}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                
                                <div class="container-liste">
                                    <div class="title-liste">Etudes</div>
                
                                    <div class="container-points">
                                        <ul>
                                            <c:forEach items="${candidature.enseignant.listeEtudes}" var="etude">
                                                <li class="left-point">${etude.titre}</li>
                                            </c:forEach>
                                        </ul>
                
                                        <div>
                                            <c:forEach items="${candidature.enseignant.listeEtudes}" var="etude">
                                                <div class="right-point">${etude.dateObtention}</div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                
                                <div class="container-liste">
                                    <div class="title-liste">Expériences</div>
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.listeExperiences}" var="experience">
                                            <li class="point"><div class="container-points">
                                                <div class="point-etude">${experience.ecole}</div>
                                                <div class="point-etude">${experience.duree}</div>
                                                <div class="point-etude">${experience.evalEcole}</div>
                                            </div></li>
                                            <div class="container-competence">
                                                <div class="title-liste">Compétences</div>
                                                
                                                <div class="container-points">
                                                    <ul>
                                                        <c:forEach items="${experience.listeCompetences}" var="competence">
                                                            <li class="left-point">${competence.nomCompetence}</li>
                                                        </c:forEach>
                                                    </ul>
                
                                                    <div>
                                                        <c:forEach items="${experience.listeCompetences}" var="competence">
                                                            <div class="right-point">${competence.niveau}</div>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
