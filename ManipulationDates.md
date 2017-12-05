## Exercice de manipulation des dates

Remarque : le client H2 peut être lancé via *db/h2.bat* ou *db/h2.sh*, il suffit ensuite de renseigner la bonne chaîne de connexion. 

- Etape 1 : forker et cloner le dépôt
- Etape 2 : créer une branche locale intitulée dates et se placer dedans
- Etape 3 : avec le client H2, puis créer une table VISITS permettant de définir une visite (date de la visite) pour un monument donné

> CREATE TABLE VISITS (ID INTEGER(10) PRIMARY KEY AUTO_INCREMENT, DATE_VISITE DATE NOT NULL, MONUMENT_ID INTEGER(10) NOT NULL);

> ALTER TABLE VISITS ADD FOREIGN KEY (MONUMENT_ID) REFERENCES MONUMENTS(ID);

- Etape 4 : avec le client H2, remplir la table VISITS avec quelques données pertinente (date du jour, date dans le passé, date dans le futur, etc.)
- Etape 5 : avec le client H2, requêter la table VISITS et mettre en forme de différentes façon la date de visite extraite (notion de formatage)
- Etape 6 : avec le client H2, requêter la table VISITS pour en extraire un sous-ensemble basé sur une restriction (clause WHERE) pertinente sur la date de la visite
- Etape 7 : avec le client H2, requêter la table VISITS pour en extraire un sous-ensemble sur un intervalle de dates de visite
- Etape 8 : créer la classe *Visite* dans *co.simplon.PoleEmploi.patrimoine.modele* et l'intégrer au mapping JPA (ne pas oublier l'association avec *Monument*)
- Etape 9 : enrichir l'endpoint *MonumentResource* avec une méthode *getVisitesByMonument* qui vise à renvoyer au format JSON la liste des visites pour un monument donné (id)
- Etape 10 : enrichir l'endpoint *MonumentResource* avec une méthode *createVisite* qui vise à créer une visite pour un monument donné (s'inspirer de la méthode *createMonument* dans l'endpoint *VilleResource*)
- Bonus : ajouter une contrainte sur la table VISITS pour empêcher l'insertion d'une date dans le futur
