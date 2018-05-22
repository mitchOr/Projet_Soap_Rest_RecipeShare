-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 15 mai 2018 à 23:31
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `recipesshare`
--

-- --------------------------------------------------------

--
-- Structure de la table `recipes`
--

CREATE TABLE `recipes` (
  `IdRecipe` int(11) NOT NULL,
  `LibelleRecipe` text COLLATE utf8_bin NOT NULL,
  `DateCreation` date NOT NULL,
  `IdUser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `recipes`
--

INSERT INTO `recipes` (`IdRecipe`, `LibelleRecipe`, `DateCreation`, `IdUser`) VALUES
(6, 'hiiii', '3918-03-13', 1),
(7, 'hiiiiy', '3918-03-06', 2);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `IdUser` int(11) NOT NULL COMMENT 'L''identifiant de l''utilisateurs',
  `NomUser` varchar(350) COLLATE utf8_bin NOT NULL,
  `PrenomUser` varchar(350) COLLATE utf8_bin NOT NULL,
  `DateNaissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`IdUser`, `NomUser`, `PrenomUser`, `DateNaissance`) VALUES
(1, 'Aicha', 'Abdoulayer', '2018-05-02'),
(2, 'Konate', 'Mariam', '2018-05-02'),
(5, 'Ngatimo', 'Michel', '2018-05-08');

-- --------------------------------------------------------

--
-- Structure de la table `usersaccount`
--

CREATE TABLE `usersaccount` (
  `IdUserAccount` int(11) NOT NULL,
  `IdUser` int(11) NOT NULL,
  `Login` varchar(350) COLLATE utf8_bin NOT NULL,
  `Password` varchar(350) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `usersaccount`
--

INSERT INTO `usersaccount` (`IdUserAccount`, `IdUser`, `Login`, `Password`) VALUES
(1, 1, 'kaker', 'kaker');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`IdRecipe`),
  ADD KEY `FK_idUser_Recipes` (`IdUser`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`IdUser`);

--
-- Index pour la table `usersaccount`
--
ALTER TABLE `usersaccount`
  ADD PRIMARY KEY (`IdUserAccount`),
  ADD KEY `FK_idUser_UserAccount` (`IdUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `recipes`
--
ALTER TABLE `recipes`
  MODIFY `IdRecipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `IdUser` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''identifiant de l''utilisateurs', AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `usersaccount`
--
ALTER TABLE `usersaccount`
  MODIFY `IdUserAccount` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `recipes`
--
ALTER TABLE `recipes`
  ADD CONSTRAINT `FK_idUser_Recipes` FOREIGN KEY (`IdUser`) REFERENCES `users` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `usersaccount`
--
ALTER TABLE `usersaccount`
  ADD CONSTRAINT `FK_idUser_UserAccount` FOREIGN KEY (`IdUser`) REFERENCES `users` (`IdUser`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
