<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <!-- <link rel="stylesheet" href="/style.css"> -->
        <link rel="stylesheet" type="text/css" href="/ProjetTAN/resources/css/style.css" />
        <title>ProjetTA - Enseignant</title>
    </head>

    <body>
        <div class="Header">
            <div class="title">Talent Teachers</div>
            <div class="hello">Bonjour Enseignant !</div>
        </div>
    
        <form class="content" method="post" action="ControleurEnseignant">
            <div class="message erreur">
                ${messageErreur}
            </div> 
            
            <div class="message info">
                ${messageInfo}
            </div> 

            <div class="Menu">
                <button type="submit" name="action" value="VoirListePoste" class="element">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element select">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </div>

            <div class="liste-canidature-enseignant">
                <div class="canidature-enseignant">
                    <button type="submit" name="action" value="VoirListePoste" class="postuler">Voir poste</button>
        
                    <div class="container-info Statut">
                        <img class="icon-status" src="/ProjetTAN/resources/icons/status.png" />
                        <div class="info">Statut</div>
                    </div>
        
                    <div class="title">Titre du poste</div>
        
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
                        <div class="container-info">
                            <img class="icon-recruteur" src="/ProjetTAN/resources/icons/date.png" />
                            <div class="info">Date candidature</div>
                        </div>
                    </div>
                </div>
        
                <div class="canidature-enseignant">
                    <button type="submit" name="action" value="VoirListePoste" class="postuler">Voir poste</button>
        
                    <div class="container-info Statut">
                        <img class="icon-status" src="/ProjetTAN/resources/icons/status.png" />
                        <div class="info">Statut</div>
                    </div>
        
                    <div class="title">Titre du poste</div>
        
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
                        <div class="container-info">
                            <img class="icon-recruteur" src="/ProjetTAN/resources/icons/date.png" />
                            <div class="info">Date candidature</div>
                        </div>
                    </div>
                </div>
        
                <div class="canidature-enseignant">
                    <button type="submit" name="action" value="VoirListePoste" class="postuler">Voir poste</button>
        
                    <div class="container-info Statut">
                        <img class="icon-status" src="/ProjetTAN/resources/icons/status.png" />
                        <div class="info">Statut</div>
                    </div>
        
                    <div class="title">Titre du poste</div>
        
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
                        <div class="container-info">
                            <img class="icon-recruteur" src="/ProjetTAN/resources/icons/date.png" />
                            <div class="info">Date candidature</div>
                        </div>
                    </div>
                </div>
        
            </div>
        </form>
    </body>
</html>