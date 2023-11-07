# Guide de démarrage pour notre projet

Ce guide vous expliquera comment lancer notre projet sur votre système, que vous utilisiez Windows ou macOS.

## Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre système :

- [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Wildfly](https://wildfly.org/downloads/)
- Un gestionnaire de base de données (par exemple, MySQL ou PostgreSQL)

## Étapes pour lancer le projet

1. Tout d'abord, assurez-vous d'avoir importé la base de données en exécutant le script SQL `script.sql` dans votre système de gestion de base de données. Assurez-vous que la base de données s'appelle `prj_progav`.

2. Lancez votre serveur Wildfly en utilisant la commande appropriée sur votre système.

3. Ouvrez votre environnement de développement intégré (IDE) de choix (par exemple, Eclipse, IntelliJ IDEA, NetBeans).

4. Importez le projet ProgAv depuis le dépôt GitHub : [https://github.com/MunHaxx/ProjetProgAv](https://github.com/MunHaxx/ProjetProgAv).

5. Assurez-vous que les configurations de votre IDE sont correctement définies pour se connecter à votre serveur Wildfly.

6. Compilez le projet à l'aide de votre IDE. Assurez-vous que toutes les dépendances sont correctement résolues.

7. Déployez le projet sur le serveur Wildfly à partir de votre IDE.

8. Une fois le déploiement terminé, vous pourrez accéder à l'application à l'adresse [http://localhost:8080/ProjetTAN](http://localhost:8080/ProjetTAN).

## Lancement sur macOS

Si vous utilisez macOS, vous pouvez également lancer le projet en utilisant le script `startProject.sh`. Voici comment faire :

1. Ouvrez un terminal.

2. Naviguez vers le répertoire du projet.

3. Exécutez la commande suivante pour lancer le projet :

   ```bash
   ./startProject.sh 
   ```

Le script startProject.sh va compiler le projet, le déployer sur Wildfly et lancer Wildfly automatiquement.

## Identifiants d'accès

Pour vous connecter à l'application, utilisez l'un des trois ensembles d'identifiants suivants :

- **Admin** :
  - Identifiant : `admin`
  - Mot de passe : `prograv`

- **Enseignant** :
  - Identifiant : `enseignant`
  - Mot de passe : `prograv`

- **Recruteur** :
  - Identifiant : `recruteur`
  - Mot de passe : `prograv`

Félicitations ! Vous avez maintenant lancé avec succès notre projet sur votre système.

Si vous rencontrez des problèmes ou des erreurs, assurez-vous de vérifier les configurations et les dépendances de votre environnement de développement, ainsi que votre serveur Wildfly.
