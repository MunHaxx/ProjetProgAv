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
            <div class="Menu">
                <button type="submit" name="action" value="VoirListePoste" class="element select">Liste postes</button>
                <button type="submit" name="action" value="VoirListeCandidature" class="element">Liste candidatures</button>
                <button type="submit" name="action" value="VoirModifierProfil" class="element">Modifier profil</button>

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
                        <button class="ajout-champ">+</button>
                      </div>
                    </div>
          
          
          
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
                        <button class="ajout-champ">+</button>
                      </div>
                    </div>
          
          
          
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
                        <button class="ajout-champ">+</button>
                      </div>
                    </div>
          
                    <div class="container-liste experience">
                      <div class="title-liste">Expériences</div>
                      <div class="container-champs">
                        <div class="container-experience">
                          <div class="container-champ container-ecole">
                            <div class="point-champ">-</div>
          
                            <div class="titre-champ">Ecole</div>
                            <input class="input-champ" placeholder="Ecole" name="champInteret1" />
          
                            <div class="titre-champ duree">Duree</div>
                            <input class="input-champ" placeholder="Duree" name="champInteret1" />
          
                            <div class="titre-champ evaluation">Evaluation</div>
                            <input class="input-champ" placeholder="Evaluation" name="champInteret1" />
                          </div>
          
                          <div class="container-competences">
                            <div class="titre-liste-competence">Compétences développés</div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                          </div>
                        </div>
          
                        <div class="container-experience">
                          <div class="container-champ container-ecole">
                            <div class="point-champ">-</div>
          
                            <div class="titre-champ">Ecole</div>
                            <input class="input-champ" placeholder="Ecole" name="champInteret1" />
          
                            <div class="titre-champ duree">Duree</div>
                            <input class="input-champ" placeholder="Duree" name="champInteret1" />
          
                            <div class="titre-champ evaluation">Evaluation</div>
                            <input class="input-champ" placeholder="Evaluation" name="champInteret1" />
                          </div>
          
                          <div class="container-competences">
                            <div class="titre-liste-competence">Compétences développés</div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                          </div>
                        </div>
          
                        <div class="container-experience">
                          <div class="container-champ container-ecole">
                            <div class="point-champ">-</div>
          
                            <div class="titre-champ">Ecole</div>
                            <input class="input-champ" placeholder="Ecole" name="champInteret1" />
          
                            <div class="titre-champ duree">Duree</div>
                            <input class="input-champ" placeholder="Duree" name="champInteret1" />
          
                            <div class="titre-champ evaluation">Evaluation</div>
                            <input class="input-champ" placeholder="Evaluation" name="champInteret1" />
                          </div>
          
                          <div class="container-competences">
                            <div class="titre-liste-competence">Compétences développés</div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                            <div class="container-champ container-competence">
                              <div class="point-champ">-</div>
          
                              <div class="titre-champ titre-competence">Compétences</div>
                              <input class="input-champ" placeholder="Intérêt" name="champInteret1" />
          
                              <div class="titre-champ titre-competence niveau">Niveau </div>
                              <select class="input-champ input-niveau" name="champNiveau" >
                                <option value="debutant">Débutant</option>
                                <option value="intermediare">Intermédiaire</option>
                                <option value="avance">Avancé</option>
                                <option value="expert">Expert</option>
                              </select>
                            </div>
                          </div>
                        </div>
          
                        <button class="ajout-champ">+</button>
                      </div>
                    </div>
          
                    <div class="container-button">
                      <input type="submit" name="action" value="Sauvegarder" class="sauvegarder"/>
                    </div>
                </div>
              </div>
        </form>
    </body>
</html>