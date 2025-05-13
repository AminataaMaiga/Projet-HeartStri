# 🎴 Projet HeartSTRI

Simulation Java d’un jeu de cartes stratégique inspiré de **Hearthstone**, développée dans le cadre de la formation **Licence Informatique Réseau et Télécommunication** – Université Paul Sabatier.

---

## 📅 Deadlines du projet

| Dépôt        | Date       | Contenu attendu                             |
|--------------|------------|----------------------------------------------|
| Dépôt 1      | 18/04/2025 | Code, Conception UML, README                 |
| Dépôt 2      | 14/05/2025 | Étape 2 complétée, UML mis à jour, README    |
| Dépôt final  | 23/05/2025 | Code complet, UML, README, Vidéo YouTube     |

---

## 🧱 Architecture du projet

### 📦 Packages principaux :
- `cartes` → `Carte`, `Serviteur`, `Deck`, `Sort`, `Arme`, `EffetSort`
- `jeu` → `Combat`, `Hero`, `Joueur`, `Main`, `Plateau`, `Tour`
- `test_fonctionnel` → Scénarios de test global
- `test_unitaires` → Tests JUnit 5 des classes critiques

---

## 👨‍💻 Technologies utilisées

- Java 17 (JavaSE-21)
- Eclipse IDE
- UML (Visual Paradigm)
- JUnit 5
- GitHub (versioning)
- H2 / JSON / XML (prévu pour persistance - étape 5)

---

## 🧪 Stratégie de test

- **Tests unitaires** dans `test_unitaires` (`JoueurTest`, `DeckTest`, `ServiteurTest`, etc.)
- **Tests fonctionnels** dans `test_fonctionnel` (simulation de tours, invocations, combats)
- Nom standard : `NomClasseTest.java`
- 📋 Objectif : garantir le comportement attendu à chaque étape

---

## 🎯 Fonctionnalités principales par étape

| Étape | Fonctionnalité |
|-------|----------------|
| 1     | Création de decks, gestion de serviteurs, combats entre cartes |
| 2     | Système de mana, héros, invocations, pioches, gestion du plateau |
| 3     | Intégration des sorts et des armes |
| 4     | Pouvoirs spéciaux des héros |
| 5     | Sauvegarde et chargement de parties (JSON/XML/BDD) |

---

## 🧩 UML fourni

- ✅ Diagrammes de cas d’utilisation (joueur, deck, combat…)
- ✅ Diagrammes de classes (modélisation complète)
- ✅ Diagrammes de séquence (tour de jeu, invocation, attaque)
- 🔄 Diagramme système (prévu étape 5)

---

## 👥 Répartition des tâches

### ✳️ TRAORE Fatoumata Salia – Développement & Documentation
- `Carte`, `Serviteur`, `Joueur`, `Plateau`
- Méthodes : `attaquer()`, `recevoirCoup()`, `invoquerServiteur()`, `piocherCarte()`
- Rédaction du rapport UML, tableau de suivi, `README.md`

### ✳️ MAIGA Aminata Alidji – Git & Mécanique de jeu
- `Deck`, `Hero`, `Sort`, `Tour`
- Gestion du mana, du tour de jeu et des effets spéciaux
- Suivi du dépôt GitHub et coordination de l’équipe

### ✳️ KANE Amayel – Combat & Cartes spéciales
- `Combat`, `Main`, `Arme`
- Intégration du système d’attaque avec arme, gestion des effets
- Tests fonctionnels globaux du jeu (simulations complètes)

---

## 🔗 Lien du dépôt GitHub

> 📁 [https://github.com/AminataaMaiga/Projet-HeartStri](https://github.com/AminataaMaiga/Projet-HeartStri)

---

## 📽️ Présentation finale

- Une **vidéo de démonstration** sera réalisée pour illustrer le fonctionnement complet du jeu.
- Elle sera mise en ligne sur **YouTube** lors du dépôt final.

---

## ✅ Dernière mise à jour : 14/05/2025 – Étape 2 terminée

