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
                <form class="poste-recruteur" method="post" action="ControleurAdmin">
                    <input type="hidden" name="data-id" value="${candidature.idCandidature}">
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
                </form>

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

            
            </div>
        </div>
    </body>
</html>