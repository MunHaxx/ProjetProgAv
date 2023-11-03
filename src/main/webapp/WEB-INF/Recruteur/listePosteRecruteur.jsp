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
                <form class="Menu" method="post" action="ControleurRecruteur">
                    <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </form> 

                <div class="liste-poste-recruteur">
                    <c:forEach items="${tousLesPostes}" var="poste">
                        <form class="poste-recruteur" method="post" action="ControleurRecruteur">
                            <input type="hidden" name="data-id" value="${poste.posteId}">

                            <button type="submit" name="action" value="VoirListeCandidature" class="postuler">Voir candidature</button>

                            <div class="title">Titre poste</div>
                
                            <div class="container-infos">
                                <div class="container-info">
                                    <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                    <div class="info">Ecole</div>
                                </div>
                                <div class="container-info">
                                    <img class="icon-recruteur" src="/ProjetTAN/resources/icons/contract.png" />
                                    <div class="info">Contrat</div>
                                </div>
                                <div class="container-info">
                                    <img class="icon-recruteur" src="/ProjetTAN/resources/icons/periode.png" />
                                    <div class="info">Période</div>
                                </div>
                                <div class="container-info">
                                    <img class="icon-recruteur" src="/ProjetTAN/resources/icons/class.png" />
                                    <div class="info">Classe_etud</div>
                                </div>
                            </div>
                
                            <div class="container-points">
                                <div class="title-point">Compétences</div>
                                <ul>
                                    <c:forEach items="${poste.competences}" var="competence">
                                        <li class="point">Attention à ça</li>
                                    </c:forEach>
                                </ul>
                            </div>

                            <div class="container-points">
                                <div class="title-point">Contraintes</div>
                                <ul>
                                    <c:forEach items="${poste.contraintes}" var="contrainte">
                                        <li class="point">Attention à ça</li>
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
