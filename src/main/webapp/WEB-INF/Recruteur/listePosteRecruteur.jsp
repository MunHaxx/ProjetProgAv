<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Login</title>
    </head>

    <body>
        <div>
            <div class="Header">
                <div class="title">Talent Teachers</div>
                <div class="hello">Bonjour ${leRecruteur.prenom} ${leRecruteur.nom} !</div>
            </div>
            
            <div class="content" >
                <div class="message erreur">
                    ${messageErreur}
                </div> 
                
                <div class="message info">
                    ${messageInfo}
                </div> 

                <form class="Menu" method="post" action="ControleurRecruteur">
                    <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </form> 

                <div class="liste-poste-recruteur">
                    <c:forEach items="${leRecruteur.estRespoListePostes}" var="poste">
                        <form class="poste-recruteur" method="post" action="ControleurRecruteur">
                            <input type="hidden" name="data-id" value="${poste.idPoste}">

                            <button type="submit" name="action" value="VoirListeCandidature" class="postuler">Voir candidature</button>

                            <div class="title">${poste.nom}</div>
                
                            <div class="container-infos">
                                <div class="container-info">
                                    <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                    <div class="info">${poste.ecole}</div>
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
                                    <div class="info">${poste.pourNivEtudiant}</div>
                                </div>
                            </div>
                
                            <div class="container-points">
                                <div class="title-point">Compétences</div>
                                <ul>
                                    <c:forEach items="${poste.listeCompetences}" var="competence">
                                        <li class="point">${competence.nom}</li>
                                    </c:forEach>
                                </ul>
                            </div>

                            <div class="container-points">
                                <div class="title-point">Contraintes</div>
                                <ul>
                                    <c:forEach items="${poste.listeContraintes}" var="contrainte">
                                        <li class="point">${contrainte.contrainte}</li>
                                    </c:forEach>
                                </ul>
                            </div>

                            <div class="container-points">
                                <div class="title-point">Remarques</div>
                                <ul>
                                    <c:forEach items="${poste.remarques}" var="remarque">
                                        <li class="point">Attention à ça</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
