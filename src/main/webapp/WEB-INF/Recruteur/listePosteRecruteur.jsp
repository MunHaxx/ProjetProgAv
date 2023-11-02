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
                    <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </div> 

                <div class="liste-poste-recruteur">
                    <div class="poste-recruteur">
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
                            <li class="point">Attention à ça parce que c'est un texte assez long héhés</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Contraintes</div>
                            <ul>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Remarques</div>
                            <ul>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                    </div>
                    <div class="poste-recruteur">
                        <div class="postuler">Voir candidature</div>
                        <div class="title">Titre poste</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <div class="icon-recruteur">O</div>
                                <div class="info">Ecole</div>
                            </div>
                            <div class="container-info">
                                <div class="icon-recruteur">O</div>
                                <div class="info">Contrat</div>
                            </div>
                            <div class="container-info">
                                <div class="icon-recruteur">O</div>
                                <div class="info">Période</div>
                            </div>
                            <div class="container-info">
                                <div class="icon-recruteur">O</div>
                                <div class="info">Classe_etud</div>
                            </div>
                        </div>
            
                        <div class="container-points">
                            <div class="title-point">Compétences</div>
                            <ul>
                            <li class="point">Attention à ça parce que c'est un texte assez long héhés</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Contraintes</div>
                            <ul>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                        <div class="container-points">
                            <div class="title-point">Remarques</div>
                            <ul>
                            <li class="point">Attention à ça</li>
                            <li class="point">Attention à ça</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
