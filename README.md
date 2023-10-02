# PokeAPIClientJava De [Execice-Apprendre JAVA](https://discord.com/channels/745101396705149019/972963497707180083/1158138997642633266)
![Preview](https://github.com/codeurzebs/PokeAPIClientJava/blob/main/.github/workflows/private/previewUrlApi.PNG?raw=true)
## Voir le Wiki --> [Clique Ici](https://github.com/codeurzebs/PokeAPIClientJava/wiki)

Ce projet Java utilise la classe `HttpClient` pour effectuer des requêtes à la PokeAPI, une API RESTful fournissant des informations détaillées sur les Pokémon. L'objectif principal de ce programme est de démontrer l'utilisation de `HttpClient` dans Java 21 pour interagir avec des API externes.

## Fonctionnalités

- Effectue une requête GET vers l'endpoint `https://pokeapi.co/api/v2/pokemon/` pour obtenir une liste de Pokémon avec leur nom et leur URL.
- Analyse la réponse JSON pour extraire le nom et l'URL du premier Pokémon de la liste.
- Envoie une requête GET à l'URL du premier Pokémon pour obtenir des détails tels que l'identifiant, la taille, le poids, et les capacités.
- Analyse la réponse JSON pour extraire le nom et l'identifiant d'une capacité spécifique du Pokémon.
- Envoie une requête GET à l'URL de la capacité pour obtenir des détails supplémentaires tels que l'effet.

## Comment Utiliser

1. Clonez le projet sur votre machine locale.
2. Assurez-vous d'avoir Java 21 installé.
3. Exécutez le programme `PokeApiClass.java` depuis votre IDE ou en ligne de commande.
4. ```
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.13.0</version>
    </dependency>
   ```
![output](https://github.com/codeurzebs/PokeAPIClientJava/blob/main/.github/workflows/private/out.PNG?raw=true)
## Remarques

- La classe `JsonClass` est utilisée pour faciliter l'analyse des réponses JSON. Assurez-vous de l'avoir correctement implémentée.

---

*Amusez-vous à explorer le monde des Pokémon avec cette petite application Java !*
