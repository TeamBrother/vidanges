CREATE TABLE `vidange`.`proprietaire` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NULL,
  `prenom` VARCHAR(45) NULL,
  `adresse` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `vidange`.`entretien` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NULL,
  `idvoiture` INT(11) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `vidange`.`voiture` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `couleur` VARCHAR(10) NULL,
  `marque` VARCHAR(45) NULL,
  `modele` VARCHAR(45) NULL,
  `idproprietaire` INT(11) NULL,
  PRIMARY KEY (`id`));
  