# Processus de modernisation assistée par Codex

## Référence
Fork lucieb09/migrationex, branche main, commit ad5c0bd au début du travail; licence Apache-2.0. Projet Maven dans migrationex/, WAR, source/cible 1.8, Compiler Plugin 3.8.1, JUnit 4.13.2 déclaré, Servlet javax 4.0.1 provided. Java local 18.0.2, Maven 3.9.11, sans wrapper; JDK 8 indisponible pour compiler la référence originale. Aucun test trouvé. mvn clean package et mvn test échouent sur sun.misc.BASE64Encoder. Ce n’est pas une vérification avec JDK 17. Exemple compact sans test d’intégration/runtime; README indique Tomcat 9+, donc Java 17 seul ne requiert pas Jakarta.

## Chaîne
1. Choisir une fiche unique dans modernization/tasks/.
2. .github/workflows/codex-modernization.yml est uniquement workflow_dispatch et accepte des IDs fermés. Codex lit AGENTS.md et la fiche.
3. Codex modifie seulement le checkout sur runner Linux éphémère (:workspace, drop-sudo); OPENAI_API_KEY n’est utilisée que dans cette étape. Aucune commande du projet n’y est lancée.
4. Le workflow transmet diff et résumé en artefacts temporaires.
5. Un second job sans secret API, permissions GitHub lecture seule, applique le diff, installe Java 17 Temurin et lance mvn -B clean verify. Il publie rapport/logs même si Maven échoue.
6. Une personne examine les résultats. Le workflow ne pousse rien, ne crée pas de branche/PR et ne peut ni fusionner ni déployer.

## Lancer manuellement
Le propriétaire configure OPENAI_API_KEY dans les secrets GitHub Actions s’il veut utiliser Codex. Dans Actions, lancer « Modernisation Java assistée par Codex », choisir une tâche et attendre Codex/Vérification. Télécharger modernization-<tâche>-<run-id>, examiner MODERNIZATION-REPORT.md, codex-final-message.md et modernization.patch. Rien n’est écrit dans le fork GitHub. Si clé absente ou action bloquée par une politique, le propriétaire configure le secret/autorisation; aucun secret n’est créé ici.

## Examiner les résultats
Le rapport comporte tâche, commit, fichiers modifiés, commandes, résultat et code retour Maven, erreurs, tests découverts et résumé Codex. Les logs complets sont joints. Un texte Codex ne prouve pas une réussite.

## Ajouter une tâche
Créer une fiche autonome avec objectif, périmètre, exclusions, critères, fichiers probables et commandes. Faire relire puis ajouter l’ID exact dans les options workflow_dispatch et la validation shell. Pas de texte libre. Garder JDK, API, dépendances et Servlet séparés.

## Planification nocturne (désactivée)
Aucun schedule n’est présent. Envisager après plusieurs essais manuels réussis et relus. Un seul ID statique par run, une seule tâche et revue humaine obligatoire. Garder concurrency par branche/tâche et cancel-in-progress false; limiter la durée, ne permettre au plus qu’une relance après diagnostic, jamais de relance automatique après échec. Revérifier les règles Actions et coût avant activation.

## Coûts et limites
Codex nécessite une clé OpenAI du propriétaire, potentiellement facturée selon volume/modèle. Java 17 installé via action officielle; Maven télécharge de Maven Central; aucun secret Maven connu. Le flux ne valide pas UI, compatibilité effective avec une version Tomcat, ni équivalence fonctionnelle. Réévaluer les versions d’actions.

## Références officielles vérifiées

- Action Codex v1.13 et entrées : https://github.com/openai/codex-action/blob/v1.13/README.md et https://github.com/openai/codex-action/blob/v1.13/action.yml.
- Sécurité Codex : https://github.com/openai/codex-action/blob/v1.13/docs/security.md.
- Versions des actions utilisées : https://github.com/actions/checkout/releases, https://github.com/actions/setup-java/releases, https://github.com/actions/upload-artifact/releases, https://github.com/actions/download-artifact/releases.
- Tomcat 9 / Servlet 4 : https://tomcat.apache.org/tomcat-9.0-doc/index.html; rupture javax vers jakarta entre Tomcat 9 et 10 : https://tomcat.apache.org/migration-10.html.
