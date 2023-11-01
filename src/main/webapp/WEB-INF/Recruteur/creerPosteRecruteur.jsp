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
                <div class="hello">Bonjour Recruteur !</div>
            </div>
            
            <form class="content" method="post" action="ControleurRecruteur">
                <div class="Menu">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element select">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </div> 

                <div class="container-creer-poste">
                    <div class="creer-poste">
                        <div class="title">Titre poste</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <div class="truc">O</div>
                                <input class="info-case" placeholder="Ecole" name="champEcole" autofocus="" />
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <input class="info-case" placeholder="Contrat" name="champContrat" autofocus="" />
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <input class="info-case" placeholder="Période" name="champPeriode" autofocus="" />
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <input class="info-case" placeholder="Niveau" name="champNiveau" autofocus="" />
                            </div>
                        </div>
            
                        <div class="container-liste">
                            <div class="title-liste">Compétences</div>
                            <div class="container-champs">
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Compétences 1" name="champCompetences1" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Compétences 2" name="champCompetences2" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Compétences 3" name="champCompetences3" />
                            </div>
                            <button class="ajout-champ">+</button>
                            </div>
                        </div>
            
                        <div class="container-liste">
                            <div class="title-liste">Contraintes</div>
                            <div class="container-champs">
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Contraintes 1" name="champContraintes1" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Contraintes 2" name="champContraintes2" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Contraintes 3" name="champContraintes3" />
                            </div>
                            <button class="ajout-champ">+</button>
                            </div>
                        </div>
            
                        <div class="container-liste">
                            <div class="title-liste">Remarques</div>
                            <div class="container-champs">
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Remarques 1" name="champRemarques1" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Remarques 2" name="champRemarques2" />
                            </div>
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Remarques 3" name="champRemarques3" />
                            </div>
                            <button class="ajout-champ">+</button>
                            </div>
                        </div>
            
                        <div class="container-button">
                            <button type="submit" name="action" value="SaveCreationPosteRecruteur" class="sauvegarder">Sauvegarder</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
