# 03 — Maintenance des dépendances

Objectif : examiner plugins et dépendances séparément après changements JDK/API.

Périmètre : migrationex/pom.xml; vérifier versions, maintenance, compatibilité Java 17 et raison des changements par petits groupes.

Exclusions : ne pas changer niveau Java, API, namespace Servlet, comportement ou Tomcat.

Critères :
- Source officielle et justification pour chaque version changée.
- Pas de mise à jour sans besoin; garder version si aucune mise à jour justifiée.
- mvn -B clean verify passe ou les nouveaux échecs sont expliqués.
- N’inventer aucune version.

Fichiers probables : migrationex/pom.xml.
Vérification : mvn -B clean verify.
