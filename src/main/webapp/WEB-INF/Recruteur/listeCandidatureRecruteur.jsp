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
                            <input type="hidden" name="data-id" value="${candidature.candidatureId}">

                            <div class="container-infos-candidature">
                                <button type="submit" name="action" value="AccepterCandidature" class="action-button accepter">Accepter</button>
                                <button type="submit" name="action" value="RejeterCandidature" class="action-button rejeter">Rejeter</button>
                                <div class="title-candidature">Candidature n°N</div>

                                <div class="container-line">
                                    <div class="infos">
                                        <div class="info">Nom</div>
                                        <div class="info">Mail.de.test@gmail.com</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">Prenom</div>
                                        <div class="info">0102030405</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">25/10/2023</div>
                                        <div class="info">icon-recruteur-de-test.com</div>
                                    </div>
                                    <div class="infos">
                                        <div class="info">Recommandé par</div>
                                        <div class="info">L3 / M1 / M2</div>
                                    </div>
                                </div>
                            </div>
                            <div class="agrandir" onclick="changeClass(this)">Agrandir</div>
                            
                            <div class="container-listes">
                                <div class="container-liste">
                                    <div class="title-liste">Activités</div>
                
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.activite}" var="activite">
                                            <li class="point">Attention à ça</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                
                                <div class="container-liste">
                                    <div class="title-liste">Intérêts</div>
                
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.interets}" var="interet">
                                            <li class="point">Attention à ça</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                
                                <div class="container-liste">
                                    <div class="title-liste">Etudes</div>
                
                                    <div class="container-points">
                                        <ul>
                                            <c:forEach items="${candidature.enseignant.etudes}" var="etude">
                                                <li class="left-point">Attention à ça</li>
                                            </c:forEach>
                                        </ul>
                
                                        <div>
                                            <c:forEach items="${candidature.enseignant.etudes}" var="etude">
                                                <div class="right-point">Date d'optention</div>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                
                                <div class="container-liste">
                                    <div class="title-liste">Expériences</div>
                                    <ul>
                                        <c:forEach items="${candidature.enseignant.experiences}" var="experience">
                                            <li class="point"><div class="container-points">
                                                <div class="point-etude">Ecole</div>
                                                <div class="point-etude">Duree</div>
                                                <div class="point-etude">Eval laissé</div>
                                            </div></li>
                                            <div class="container-competence">
                                                <div class="title-liste">Compétences</div>
                                                
                                                <div class="container-points">
                                                    <ul>
                                                        <c:forEach items="${experience.competence}" var="competence">
                                                            <li class="left-point">Nom de la compétence</li>
                                                        </c:forEach>
                                                    </ul>
                
                                                    <div>
                                                        <c:forEach items="${experience.competence}" var="competence">
                                                            <div class="right-point">Niveau</div>
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
