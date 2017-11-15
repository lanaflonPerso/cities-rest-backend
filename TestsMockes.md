## Exercice de prise en main d'une démarche de tests avec bouchons / mocks

- Etape 1 : forker et cloner le dépôt
- Etape 2 : prendre connaissance de la classe *MonumentResource.java*
- Etape 3 : créer une classe de test *MonumentResourceTest.java* et un premier scénario *deleteMonumentById_should_throw_IllegalArgumentException_when_id_is_null* avec *null* comme paramètre, enrichir l'implémentation pour faire passer le tests
- Etape 4 : compléter la classe de test avec un scénario *getMonuments_should_return_DEFAULT_PAGE_SIZE_items_when_from_and_limit_are_both_null* en créant une implémentation factice de *MonumentDao* pour les besoins du test
- Etape 5 : intégrer Mockito (dépendance Maven : org.mockito:mockito-all:1.9.5:test) et mettre à jour le précédent test à l'aide de ce dernier
