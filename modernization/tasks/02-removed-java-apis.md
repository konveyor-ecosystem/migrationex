# 02 — API Java retirées

Objectif : retirer sun.misc.BASE64Encoder, bloquant sur JDK récents.

Périmètre : remplacer uniquement l’encodeur de Library.generateHash par java.util.Base64; préserver algorithme, entrée et représentation fonctionnelle.

Exclusions : ne pas modifier MD5, dépendances, niveau Java ou Servlet. Signaler MD5 pour revue après analyse d’usage/sécurité; aucune substitution automatique.

Critères :
- Aucune référence à sun.misc.BASE64Encoder restante.
- Encodage Base64 compatible sur entrées ciblées.
- mvn -B clean verify passe sous JDK 17 si tâche 01 acceptée; sinon expliquer erreurs.
- Test ciblé seulement s’il reste dans le périmètre.

Fichiers probables : migrationex/src/main/java/com/konveyor/Library.java, éventuellement test.
Vérification : mvn -B clean verify.
