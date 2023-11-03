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
            <div className="message erreur">
                ${messageErreur}
            </div> 
            
            <div className="message info">
                ${messageInfo}
            </div> 

            <div class="Menu">
                <button type="submit" name="action" value="VoirListePoste" class="element">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element select">Modifier profil</button>

                <button type="submit" name="action" value="Deconnexion" class="deconnexion">Déconnexion</button>
            </div>

            <div class="container-modif-employe">
                <div class="modif-employe">
                    <div class="title-page">Mon profil</div>

                    <div class="container-info">
                        <div class="title-info-case">Nom</div>
                        <input class="info-case" placeholder="Nom" name="champNom" autofocus="" />

                        <div class="title-info-case droite">Site</div>
                        <input class="info-case" placeholder="Site" name="champSite" />
                    </div>

                    <div class="container-info">
                        <div class="title-info-case">Prénom</div>
                        <input class="info-case" placeholder="Prénom" name="champPrenom" />

                        <div class="title-info-case droite">Mail</div>
                        <input class="info-case" placeholder="Mail" name="champMail" />
                    </div>

                    <div class="container-info">
                        <div class="title-info-case">Soutenu par</div>
                        <input class="info-case" placeholder="Soutenu par" name="champSoutient" />
                        
                        <div class="title-info-case droite">Téléphone</div>
                        <input class="info-case" placeholder="Téléphone" name="champTelephone" />
                    </div>
          
                    <!-- Intérêts -->
                    <div class="container-liste">
                        <div class="title-liste">Intérêts</div>

                        <div class="container-champs">
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Intérêt 1" name="champInteret1" />
                            </div>

                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Intérêt 2" name="champInteret2" />
                            </div>

                            <div class="container-champ">
                                <div class="point-champ">-</div>
                                <input class="input-champ" placeholder="Intérêt 3" name="champInteret3" />
                            </div>
                        </div>
                    </div>
          
                    <!-- Activité -->
                    <div class="container-liste">
                        <div class="title-liste">Activités</div>

                        <div class="container-champs">
                            <div class="container-champ">
                              <div class="point-champ">-</div>
                              <input class="input-champ" placeholder="Activités 1" name="champActivite1" />
                            </div>

                            <div class="container-champ">
                              <div class="point-champ">-</div>
                              <input class="input-champ" placeholder="Activités 2" name="champActivite2" />
                            </div>

                            <div class="container-champ">
                              <div class="point-champ">-</div>
                              <input class="input-champ" placeholder="Activités 3" name="champActivite3" />
                            </div>
                        </div>
                    </div>
          
                    <!-- Etudes -->
                    <div class="container-liste etude">
                        <div class="title-liste">Etudes</div>
            
                        <div class="container-champs">
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                
                                <div class="titre-champ titre">Titre</div>
                                <input class="input-champ input-titre" placeholder="Titre etudes 1" name="champEtude1" />
                
                                <div class="titre-champ date">Date d'obtention</div>
                                <input type="date" class="input-champ input-date" name="champDate1" />
                            </div>
              
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                
                                <div class="titre-champ titre">Titre</div>
                                <input class="input-champ input-titre" placeholder="Titre etudes 2" name="champEtude2" />
                
                                <div class="titre-champ date">Date d'obtention</div>
                                <input type="date" class="input-champ input-date"name="champDate2" />
                            </div>
                            
                            <div class="container-champ">
                                <div class="point-champ">-</div>
                
                                <div class="titre-champ titre">Titre</div>
                                <input class="input-champ" placeholder="Titre etudes 3" name="champEtude3" />
                
                                <div class="titre-champ date">Date d'obtention</div>
                                <input type="date" class="input-champ input-date" name="champDate3" />
                            </div>
                        </div>
                    </div>
          
                    <!-- Expériences -->
                    <div class="container-liste experience">
                        <div class="title-liste">Expériences</div>
                        
                        <div class="container-champs">

                            <!-- Expérience 1 -->
                            <div class="container-experience">
                                <div class="container-champ container-ecole">
                                    <div class="point-champ">-</div>
                  
                                    <div class="titre-champ">Ecole</div>
                                    <input class="input-champ" placeholder="Ecole" name="champEcole1" />
                  
                                    <div class="titre-champ duree">Duree</div>
                                    <input class="input-champ" placeholder="Duree" name="champDuree1" />
                  
                                    <div class="titre-champ evaluation">Evaluation</div>
                                    <input class="input-champ" placeholder="Evaluation" name="champEvaluation1" />
                                </div>
                
                                <div class="container-competences">
                                    <div class="titre-liste-competence">Compétences développés</div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence1.1" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau1.1" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence1.2" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau1.2" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                      <div class="point-champ">-</div>
                  
                                      <div class="titre-champ titre-competence">Compétences</div>
                                      <input class="input-champ" placeholder="Intérêt" name="champInteret1.3" />
                  
                                      <div class="titre-champ titre-competence niveau">Niveau </div>

                                      <select class="input-champ input-niveau" name="champNiveau1.3" >
                                          <option value="debutant">Débutant</option>
                                          <option value="intermediare">Intermédiaire</option>
                                          <option value="avance">Avancé</option>
                                          <option value="expert">Expert</option>
                                      </select>
                                    </div>
                                </div>
                            </div>

                            <!-- Expérience 2 -->
                            <div class="container-experience">
                                <div class="container-champ container-ecole">
                                    <div class="point-champ">-</div>
                  
                                    <div class="titre-champ">Ecole</div>
                                    <input class="input-champ" placeholder="Ecole" name="champEcole2" />
                  
                                    <div class="titre-champ duree">Duree</div>
                                    <input class="input-champ" placeholder="Duree" name="champDuree2" />
                  
                                    <div class="titre-champ evaluation">Evaluation</div>
                                    <input class="input-champ" placeholder="Evaluation" name="champEvaluation2" />
                                </div>
                
                                <div class="container-competences">
                                    <div class="titre-liste-competence">Compétences développés</div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence2.1" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau2.1" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence2.2" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau2.2" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                      <div class="point-champ">-</div>
                  
                                      <div class="titre-champ titre-competence">Compétences</div>
                                      <input class="input-champ" placeholder="Intérêt" name="champInteret2.3" />
                  
                                      <div class="titre-champ titre-competence niveau">Niveau </div>

                                      <select class="input-champ input-niveau" name="champNiveau2.3" >
                                          <option value="debutant">Débutant</option>
                                          <option value="intermediare">Intermédiaire</option>
                                          <option value="avance">Avancé</option>
                                          <option value="expert">Expert</option>
                                      </select>
                                    </div>
                                </div>
                            </div>

                            <!-- Expérience 3 -->
                            <div class="container-experience">
                                <div class="container-champ container-ecole">
                                    <div class="point-champ">-</div>
                  
                                    <div class="titre-champ">Ecole</div>
                                    <input class="input-champ" placeholder="Ecole" name="champEcole3" />
                  
                                    <div class="titre-champ duree">Duree</div>
                                    <input class="input-champ" placeholder="Duree" name="champDuree3" />
                  
                                    <div class="titre-champ evaluation">Evaluation</div>
                                    <input class="input-champ" placeholder="Evaluation" name="champEvaluation3" />
                                </div>
                
                                <div class="container-competences">
                                    <div class="titre-liste-competence">Compétences développés</div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence3.1" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau3.1" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                        <div class="point-champ">-</div>
                    
                                        <div class="titre-champ titre-competence">Compétences</div>
                                        <input class="input-champ" placeholder="Intérêt" name="champCompetence3.2" />
                    
                                        <div class="titre-champ titre-competence niveau">Niveau </div>

                                        <select class="input-champ input-niveau" name="champNiveau3.2" >
                                            <option value="debutant">Débutant</option>
                                            <option value="intermediare">Intermédiaire</option>
                                            <option value="avance">Avancé</option>
                                            <option value="expert">Expert</option>
                                        </select>
                                    </div>

                                    <div class="container-champ container-competence">
                                      <div class="point-champ">-</div>
                  
                                      <div class="titre-champ titre-competence">Compétences</div>
                                      <input class="input-champ" placeholder="Intérêt" name="champInteret3.3" />
                  
                                      <div class="titre-champ titre-competence niveau">Niveau </div>

                                      <select class="input-champ input-niveau" name="champNiveau3.3" >
                                          <option value="debutant">Débutant</option>
                                          <option value="intermediare">Intermédiaire</option>
                                          <option value="avance">Avancé</option>
                                          <option value="expert">Expert</option>
                                      </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
          
                    <div class="container-button">
                        <button type="submit" name="action" value="SauveModifEnseignant" class="sauvegarder">Sauvegarder</button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>