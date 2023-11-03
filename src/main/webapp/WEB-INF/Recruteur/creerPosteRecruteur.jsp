<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Login</title>
    </head>

    <body>
        <div>
            <div class="Header">
                <div class="title">Talent Teachers</div>
                <div class="hello">Bonjour ${leRecruteur.prenom} ${leRecruteur.nom} !</div>
            </div>
            
            <form class="content" method="post" action="ControleurRecruteur">
                <input type="hidden" name="data-id" value="${recruteur.recruteurId}">

                <div class="Menu">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element select">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </div> 

                <div class="container-creer-poste">
                    <div class="creer-poste">
                        <!-- Info poste -->
                        <div class="title">Titre poste</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/school.png" />
                                <input class="info-case" placeholder="Ecole" name="champEcole" autofocus="" />
                            </div>

                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/contract.png" />
                                <input class="info-case" placeholder="Contrat" name="champContrat" autofocus="" />
                            </div>

                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/periode.png" />
                                <input class="info-case" placeholder="Période" name="champPeriode" autofocus="" />
                            </div>

                            <div class="container-info">
                                <img class="icon-recruteur" src="/ProjetTAN/resources/icons/class.png" />
                                <input class="info-case" placeholder="Niveau étudiant" name="champNiveau" autofocus="" />
                            </div>
                        </div>
                        
                        <!-- Compétences -->
                        <div class="container-liste">
                            <div class="title-liste">Compétences</div>
                            <div class="container-champs">
                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Compétence 1" name="champCompetence1" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Compétence 2" name="champCompetence2" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Compétence 3" name="champCompetence3" />
                                </div>
                            </div>
                        </div>
            
                        <!-- Contraintes -->
                        <div class="container-liste">
                            <div class="title-liste">Contraintes</div>
                            <div class="container-champs">
                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Contrainte 1" name="champContrainte1" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Contrainte 2" name="champContrainte2" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Contrainte 3" name="champContrainte3" />
                                </div>
                            </div>
                        </div>
            
                        <!-- Remarques -->
                        <div class="container-liste">
                            <div class="title-liste">Remarques</div>
                            <div class="container-champs">
                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Remarque 1" name="champRemarque1" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Remarque 2" name="champRemarque2" />
                                </div>

                                <div class="container-champ">
                                    <div class="point-champ">-</div>
                                    <input class="input-champ" placeholder="Remarque 3" name="champRemarque3" />
                                </div>
                            </div>
                        </div>
            
                        <div class="container-button">
                            <button type="submit" name="action" value="SauveCreationPosteRecruteur" class="sauvegarder">Sauvegarder</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
