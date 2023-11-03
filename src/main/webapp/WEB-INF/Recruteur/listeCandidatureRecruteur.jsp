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
            
            <form class="content" method="post" action="ControleurRecruteur">
                <div class="Menu">
                    <button type="submit" name="action" value="VoirListePoste" class="element">Listes postes</button>
                    <button type="submit" name="action" value="VoirCreerPoste" class="element">Créer postes</button>
                    <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>
            
                    <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
                </div> 

                <div class="liste-candidature-recruteur">
        
                    <div class="container-candidature-recruteur">
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
                                    <li class="point">Attention à ça parce que c'est un texte assez long héhés</li>
                                    <li class="point">Attention à ça</li>
                                    <li class="point">Attention à ça</li>
                                </ul>
                            </div>
            
                            <div class="container-liste">
                                <div class="title-liste">Intérêts</div>
            
                                <ul>
                                    <li class="point">Attention à ça parce que c'est un texte assez long héhés</li>
                                    <li class="point">Attention à ça</li>
                                    <li class="point">Attention à ça</li>
                                </ul>
                            </div>
            
                            <div class="container-liste">
                                <div class="title-liste">Etudes</div>
            
                                <div class="container-points">
                                    <ul>
                                        <li class="left-point">Diplome de l'EFREI</li>
                                        <li class="left-point">Diplome trouvé dans un kinder suprise</li>
                                        <li class="left-point">Ah merde, j'ai mis deux fois la même chose</li>
                                    </ul>
            
                                    <div>
                                        <div class="right-point">Date d'optention</div>
                                        <div class="right-point">Date d'optention</div>
                                        <div class="right-point">Date d'optention</div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="container-liste">
                                <div class="title-liste">Etudes</div>
                                <ul>
                                    <li class="point"><div class="container-points">
                                        <div class="point-etude">Ecole</div>
                                        <div class="point-etude">Duree</div>
                                        <div class="point-etude">Eval laissé</div>
                                    </div></li>
                                    <div class="container-competence">
                                        <div class="title-liste">Compétences</div>
                                        
                                        <div class="container-points">
                                            <ul>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                            </ul>
        
                                            <div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <li class="point"><div class="container-points">
                                        <div class="point-etude">Ecole</div>
                                        <div class="point-etude">Duree</div>
                                        <div class="point-etude">Eval laissé</div>
                                    </div></li>
                                    <div class="container-competence">
                                        <div class="title-liste">Compétences</div>
                                        
                                        <div class="container-points">
                                            <ul>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                            </ul>
        
                                            <div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <li class="point"><div class="container-points">
                                        <div class="point-etude">Ecole</div>
                                        <div class="point-etude">Duree</div>
                                        <div class="point-etude">Eval laissé</div>
                                    </div></li>
                                    <div class="container-competence">
                                        <div class="title-liste">Compétences</div>
                                        
                                        <div class="container-points">
                                            <ul>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                                <li class="left-point">Nom de la compétence</li>
                                            </ul>
        
                                            <div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                                <div class="right-point">Niveau</div>
                                            </div>
                                        </div>
                                    </div>  
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
