# 01 — Cible JDK 17

Objectif : modifier seulement la configuration de compilation Maven pour Java 17.

Périmètre : propriétés/compiler dans migrationex/pom.xml et confirmation du JDK CI. Ne pas réparer les erreurs de source ni mettre à jour de dépendances.

Critères :
- Configuration Java 17 cohérente; préférer maven.compiler.release si plugin compatible.
- CI vérifie sous JDK 17.
- Aucun changement d’API retirée, dépendance ou javax/Jakarta.
- Signaler l’échec possible de sun.misc.BASE64Encoder comme tâche 02.

Fichiers probables : migrationex/pom.xml, documentation prérequis si nécessaire.

Vérifications : java -version; mvn -B clean verify. Échec sur API retirée attendu si tâche 02 non acceptée; ne pas corriger ici. Aucun test Java initialement.
