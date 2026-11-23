# 00 — Audit et référence

Objectif : reproduire/documenter la référence sans modifier application ou dépendances.

Périmètre : structure, licence, Git, versions Java/Maven, POM, sources, tests et commandes de référence.

Critères :
- Confirmer module migrationex/, cible Java 8 et absence initiale de tests.
- Exécuter depuis migrationex/: mvn -B clean package puis mvn -B test.
- Consigner versions, codes de sortie, erreur pertinente et limitations.
- Aucune modification applicative.

Fichiers probables : aucun; compte rendu en artefact.

Vérifications :
~~~
java -version
mvn -version
mvn -B clean package
mvn -B test
~~~
Référence observée : échec sun.misc.BASE64Encoder sous Java 18.0.2/Maven 3.9.11; aucun test Java trouvé.
