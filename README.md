# Projet HeartStri

🎮 **Projet Java - Simulation de jeu de cartes inspiré de Hearthstone**  
📚 Projet pédagogique encadré, réalisé en Java avec une architecture orientée objet et une gestion progressive des fonctionnalités.

---

## 📅 Deadlines

- Dépôt 1        18/04/2025    Code, Conception UML, README          
- Dépôt 2        14/05/2025    Code, Conception UML, README          
- Dépôt Final    23/05/2025    Code complet, UML, Vidéo YouTube      

---

## 🧱 Architecture du projet

### 📦 Packages proposés :
- `cartes`: Serviteur, Deck, Sort, Arme, EffetSort
- `jeu`: Combat, Plateau, Main
- `joueur`: Hero, Joueur
- `test_fonctionnel`: Tous les tests unitaires

---

## 👨‍💻 Technologies

- Java 17+
- UML (Visual Paradigm)
- JUnit pour les tests
- H2 Database (ou JSON/XML) pour la persistance (étape 5)
- JDBC pour la connexion à la base de données

---

## 🧪 Tests

- Chaque fonctionnalité sera testée de façon unitaire dans le package `test_fonctionnel`
- Les tests seront nommés selon le standard `NomClasseTest.java`

---

## 🎯 Fonctionnalités principales

- Gestion des decks et des combats entre serviteurs
- Gestion du mana et des invocations
- Sorts et armes
- Pouvoirs spéciaux des héros
- Sauvegarde des parties (JSON/XML/BDD)

---

## 🧩 UML à fournir

- Diagrammes des cas d’utilisation
- Diagrammes de classes
- Diagrammes de séquence
- Diagrammes système

---

## 👥 Répartition des tâches

TRAORE
- Implémentation de la classe Serviteur
- Méthodes : attaquer(), recevoircoup(), estMort()
- Génération de serviteurs aléatoires
- Tests unitaires sur Serviteur        
MAIGA
- Implémentation de la classe Deck
- Méthodes : ajouterCarte(), tirerCarteAleatoire(), genererDeckAleatoire()
- Gestion de la liste de serviteurs
- Tests unitaires sur Deck
KANE  
- Implémentation de la classe Combat
- Lancement du jeu dans Main
- Gestion du déroulement du combat entre deux serviteurs
- Test fonctionnel du système global via main()

## 📽️ Présentation

- Une vidéo finale sera publiée sur YouTube pour démontrer le fonctionnement du jeu.

