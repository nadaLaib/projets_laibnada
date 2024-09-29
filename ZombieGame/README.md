# PROJET 2024

Sujet : 
https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf

# Equipe

- Anayes HACHOUR

- Nada LAIB

- Wissal NOUIBET

- Katia BOUAROUR

## Dans ce readme vous retrouverez : 
  * #### Objectif du projet
  * #### Comment exécuter le programme final ainsi que son extension
  * #### Les commandes de créations des fichiers jar
  * #### Les commandes de compilations ainsi que les commandes du makefile exigé (make zombicide.jar make doc, make cls,make clean)
  * #### Un récapitulatif de l'avancement du projet pour chaque livrable.


## Objectif du projet : 


L'objectif de ce projet était de créer une ville où les survivants et les zombies se battent à l'intérieur.

Pour l'organisation de cette ville, nous avons décidé de créer des bâtiments 2x2 contenant 4 pièces chacun. Chaque bâtiment sera séparé par des rues, avec des bouches d'égouts placées aux extrémités de chaque rue ainsi qu'une pharmacie et un hôtel placés aléatoirement. Des équipements sont disposés dans les pièces : la pharmacie et l'hôtel ont leur propre pièce dédiée.

Nous avons représenté les acteurs avec des emojis sur le plateau. La ville est dynamique : à chaque déplacement d'un des acteurs, la ville est mise à jour. Nous pouvons donc suivre leurs déplacements au fur et à mesure du jeu.

Ainsi, lorsque la ville est prête, les survivants peuvent combattre les zombies. Les deux types d'acteurs ont leurs propres actions respectives et peuvent également remplir certains rôles.

La partie est terminée lorsque tous les zombies sont éliminés ou lorsque le niveau d’expérience global (somme des expériences des survivants) atteint le score de 30.


## Pour exécuter le programme final : 

* Situé dans le dossier l2s4-projet-2024 : 

  * #### Jeu classique
    ```
    l2s4-projet-2024$ make zombicide.jar
    ```
    * ⭢ Lancera le jeu par defaut avec un tableau de taille 8x8 et 2 survivants.

    ou 
    ```
    l2s4-projet-2024$ make zombicide.jar ARG1=14 ARG2=14 ARG3=3
    ```
    * ⭢ Lance le jeu selon les choix de l'utilisateur pour la taille du plateau et le nombre de joueur. Ici en loccurence l'utilisateur à choisit un plateau 14x14 avec 3 survivants.

    ou, en étant situé dans le dossier jar :
    ```
    jar$ java -jar Zombicide.jar 5 5 6 
    ```
    * ⭢  (Ici un exemple d'un plateau 5*5 et 6 survivants par exemple)

  * #### Jeu interactif

    **Extension du jeu** : Créer un jeu interactif avec le joueur. Maintenant une immersion maximale à été mit en place avec des jeu de mots, un dialogue captivant durant le quel le joeur pourra participer et des emojis afin de rendre le jeu encore plus attrayant.
     ```
    l2s4-projet-2024$ make zombicideInteractive.jar
    ```

    ou 

    ```
    jar$ java -jar ZombicideInteractive.jar
    ```



## Creation des fichiers jar : 
  * #### Pour créer le fichier jar du <code>Jeu classique</code> : 
  ```
  l2s4-projet-2024$ make zombicide-jar
  ```
  * #### Pour créer le fichier jar du <code>Jeu Interactif</code> : 
  ```
  l2s4-projet-2024$ make zombicideInteractive-jar
  ```

  * #### Pour créer le fichier jar du <code>Livrable 1</code> : 
  ```
  jar cvfe Livrable1.jar zombiegame.Livrable1 -C classes zombiegame
  ```

  * #### Pour créer le fichier jar du <code>Livrable 2</code> : 
  ```
  jar cvfe Livrable2.jar zombiegame.Livrable2 -C classes zombiegame
  ```

  * #### Pour créer le fichier jar du <code>Livrable 3</code> :
  ```
  jar cvfe Livrable3.jar zombiegame.Livrable3 -C classes zombiegame
  ```

  * #### Pour créer les fichiers jar du <code>Livrable 4</code> : 

    * #### Jeu classique
    ```
    l2s4-projet-2024$ make zombicide-jar
    ```
    
    * #### Jeu Interactive 

    ```
    l2s4-projet-2024$ make zombicideInteractive-jar
    ```


## Compilations : 

* #### Compilations des fichiers sources
  * Pour compiler tout les fichiers contenu dans le dossier <code>src</code>, en étant dans le dossier l2s4-projet-2024 :
  ```
  l2s4-projet-2024$ make cls
  ```
  * Aussi, possibilité de compiler chaque dossier séparement avec leurs commandes respectives : 

  ```
  l2s4-projet-2024$ make zombiegame
  l2s4-projet-2024$ make actors
  l2s4-projet-2024$ make equipments
  l2s4-projet-2024$ make weapons
  l2s4-projet-2024$ make roles
  l2s4-projet-2024$ make specialroom
  l2s4-projet-2024$ make specialstreet
  l2s4-projet-2024$ make specialzombie
  ```

- #### Generé la doc : 

  ```
  l2s4-projet-2024$ make doc 
  ```
  
- #### Nettoyer les fichiers
  ```
  l2s4-projet-2024$ make clean
  ```

#
#
## Voici un récapitulatif de l'avancement du projet pour chaque livrable :

## Livrable 1  : 
Commande d'éxécution du Livrable1.jar:
```
java -jar Livrable1.jar
```

### Objectifs :

Création d'un plateau constitués de batiment de taille 2*2 représentés
par 4 pièces '🅁' et des rues par des lettres 'S'. Une pharmacie et un hotel seront placés aléatoirement dans chaque plateau 
représentés par des lettres respectives suivantes : '🅿' et '🅷'.
Nous retrouverons des bouches d'égouts aux extrémités de chaque carrefour représentées par des '𝗢'. (*Sauf pour ClassicalTown, une seul bouche d'égout sera au centre du carrefour.*)


Des couleurs ainsi que des caractères spéciaux ont été ajoutés afin d'améliorer la qualité visuel du plateau de jeu.

Aussi, des émojis ont été intégrés pour une immersion maximale dans l'univers du jeu.


### Difficultés rencontrées :

Pour un plateau 5x5, 1 fois sur 10 l'hôtel ne s'affiché pas sur le plateau de jeu. Après reflexion nous avons compris qu'enfait si, l'hôtel s'affiché mais la pharmacie se mettait par-dessus et la remplacé. Alors nous avons rectifié cet erreur dans le code afin qu'un hôtel ne puisse pas se mettre à la place d'une pharmacie et vice-versa.

Réflexion longue sur l'importance de la modélisation des portes. 

Hésitation sur 
la création d'une classe Building.

Difficulté à coder certains tests : Pharmacy, ContinentalHotel.

#

#### Semaine 1 : 15/01 au 20/01
- Création du git commun et prise en main d'Eclipse.
- Prise conscience du sujet
- Visualisation du plateau de jeu 
- Modélisation de l'uml des classes principales nécessaires à la création du plateau 



#### Semaine 2 : du 22/01 au 26/01 
- Amélioration du diagramme UML. Création des classes, interfaces ... Questionnement sur la nécessité de la classe Building
- Avancé sur la modélisation de l'uml pour la création du plateau de jeu. 
Town, Room, Door, Street, Pharmacy, Continental, Sewer ont été modélisés.

De plus, un tirage au sort à été effectué pour la répartitions des taches :

* Nada + Wissal : Création de la classe Town

* Wissal : Test + Documentation

* Nada : ClassicalTown

* Anayes : Création de la classe Street

* Katia : Création de la classe Room

Pour l'UML, chacune se chagera, au fur et à mesure, de faire des mise à jour.


#### Semaine 3 : 29/01 au 02/02
- Modélisation de la ville sur tableau blanc On a revu le travail déja fait en autonomie et les points à améliorer, faire, revoir ... Idées sur répartition des différentes area(cases) de la ville, fonction pour diviser la ville en rues et immeubles
- Assemblage des classes et update de ces dernières, ajout des méthodes et mise au point du code en équipe
- Avancée sur la classe Town, Room et Street. Nous avons décidé d'utiliser la méthode to String pour la modélisation de Room par des 'R' et de Street par des 'S'


#### Semaine 4 : 05/02 au 09/02 
- Création du tag représentant le Livrable1 .
- Création du fichier jar.  
- Finalisation des tests .
- Nettoyage et aération du projet par la création de packages.

#
# Livrable 2 

### Difficultés rencontrées :

Nous avons hésité sur la représentations des rôles. "Aurions-nous un heritage ou une interface ?" Finalement nous avons décidé de faire une interface car nous trouvons cela plus approprié et accessible pour la suite.

#### Commande d'éxécution du Livrable2.jar:
```
java -jar Livrable2.jar
```

#### Semaine 5 : 12/02 au 16/02
- Modélisation de l'uml pour le Livrable 2 
  
- Apparition des classes Survivants, Zombie, Actor, Equipements, Roles

#### Semaine 6 : 19/02 au 23/02
- Update de l'uml : apparition de sous-classe de Zombie, de l'interface Role pour representer les differents roles des survivants
  
- Répartiton des classes par tirage au sort : 

  * Nada  : Update Town + Création de la classe Role et ses sous-classes 

  * Wissal : Création de la classe Zombie et ses sous-classes

  * Anayes : Création de la classe Equipements et ses sous-classes

  * Katia : Création de la classe Survivant + les Tests concernés


#### Semaine 7 : 26/01 au 01/03
- Codage et implémentation de code pour les differentes classes chacune de son coté.

#### Semaine 8 : 04/03 au 08/03
- Mise en relation des travaux de chacune.

-  Effectuer les methodes de Tests pour les différentes classes.


#### Semaine 9 : 11/03 au 15/03
- Mise au propre du Livrable 2.

- Nous avons décidé de mettre un émoji Ninja pour représenter un survivant.

- Nous avons ajouté des couleurs pour les batiments et pour les bouches d'égouts afin d'améliorer la qualité visuel de la ville et une bonne différenciation entre chaque partie.
  
#
# Livrable 3

#### Commande d'éxécution du Livrable3.jar:
```
java -jar Livrable3.jar
```

#### Semaine 10 : 18/03 au 23/03
Nous avons fait une rétrospective de toutes les actions à modéliser pour le jeu.

#### Semaine 11 : 25/03 au 30/03
Nous nous sommes équitablement partagées les actions entre nous. À la suite d'un tirage au sort, chacune avait un certains nombres d'actions à modéliser.

#### Semaine 12 : 01/04 au 06/04
Nous apportons au fur et à mesure des modifications à nos précédents codes afin de les adapter à la demande du jeu et aux différentes actions. Aussi, nous entamons les tests de nos nouvelles méthodes/classes.

#### Semaine 13 : 08/04 au 13/04

#
# Livrable 4

* Finalisation de l'UML
* Critères pour le rendu final respectés.
* Makefile Fait (*avec make zombicide.jar, make cls, make doc, make clean comme exigé.* et plus encore..)
* Dossier jar contenant les jar Fait
* Zombicide Fait
* ZombicideInteractive Fait

#### Commande d'éxécution du Livrable4.jar:

Les commandes d'éxécutions pour le jeu classique ainsi que le jeu interactif ont été introduit dans la partie <code>" Pour exécuter le programme final :"</code>


* #### Extension : 

  C'est un programme interactif qui demande à l'utilisateur ses préferences en terme de taille pour le plateau de sa ville et son choix du nombre de survivants qu'il veut faire jouer.

  *fin du readme*
