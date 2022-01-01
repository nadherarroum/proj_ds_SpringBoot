## Projet J2E - TP_DS
###Réaliser par : Nadher Arroum - GLSI 2-A

> Création d'un nouveau projet avec les dépendances suivant :
- H2 Database Engine
- MySQL Connector
- Projet Lombok
- Spring boot dev tools
- Spring boot starter data JPA
- Spring boot starter web
- Spring boot test
- Spring boot thymeleaf (optionel)

> Configuration pour connecter l'application au BD sous :
- src\main\resources\application.properties

> Création des entités sous :
- src\main\java\com\nadherarroum\proj_ds\entities

> Création le contrôleur "CustomerController.java" sous :
- src\main\java\com\nadherarroum\proj_ds\controllers

> Préparation des repositories sous : 
- src\main\java\com\nadherarroum\proj_ds\repositories

> Préparer le service " CustomerService.java " sous :
- src\main\java\com\nadherarroum\proj_ds\services

>  Modification du "CustomerRepo.java" pour :
- Prépare les request MySQL
- Exécuter les requêtes
- Sauvegarder le résultat

## Architecture
````
------------------
| RestController |
|     CRUD       |
------------------
    ↓  ↑
-----------
| Service |
-----------
    ↓  |
-----------------
| JpaRepository |
-----------------
    ↓  ↑
------------
| Database |
------------
````