# 04 — Évaluation javax / Jakarta

Objectif : vérifier le runtime Servlet réellement visé.

État : README indique Tomcat 9+ et POM utilise Servlet API 4.0.1. Tomcat 9 utilise javax.servlet; Java 17 seul ne nécessite pas Jakarta. Références officielles : https://tomcat.apache.org/tomcat-9.0-doc/index.html et https://tomcat.apache.org/migration-10.html. Diagnostic en lecture seule tant que Tomcat 10+/Jakarta EE n’est pas explicitement adopté.

Critères :
- Documenter runtime cible et source officielle.
- Si Tomcat 9 reste visé : conclure migration Jakarta non requise et ne rien modifier.
- Si cible Tomcat 10+/Jakarta EE : proposer une fiche séparée avec API, dépendances, descripteurs, tests d’intégration et runtime; ne pas fusionner avec JDK.
- Ne pas remplacer aveuglément javax globalement, certains packages sont Java SE.

Fichiers probables : aucun actuellement; une future tâche pourrait concerner imports Servlet, POM, web.xml, configuration/doc runtime.
Vérification : mvn -B clean verify. Cela ne prouve pas le fonctionnement sur conteneur.
