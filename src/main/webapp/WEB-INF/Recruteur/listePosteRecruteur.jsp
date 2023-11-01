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
            
            <div class="content">
                <form class="Menu" method="post" action="ControleurRecruteur">
                    <button type="submit" name="action" value="VoirListePoste" class="element select">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <div type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</div>
                </form> 

                <form class="liste-poste-recruteur" method="post" action="ControleurRecruteur">
                    <div class="poste-recruteur">
                        <button type="submit" name="action" value="VoirListeCandidature" class="postuler">Voir candidature</button>
                        <div class="title">Titre poste</div>
            
                        <div class="container-infos">
                            <div class="container-info">
                                <div class="truc">O</div>
                                <div class="info">Ecole</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <div class="info">Contrat</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <div class="info">Période</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
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
                                <div class="truc">O</div>
                                <div class="info">Ecole</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <div class="info">Contrat</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
                                <div class="info">Période</div>
                            </div>
                            <div class="container-info">
                                <div class="truc">O</div>
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
            </div>
        </div>
    </body>
</html>
