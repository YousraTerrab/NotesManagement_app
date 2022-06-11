
************************************
	Import and install 
************************************

1- under maria db create the database  gs_notes_database  
2- Preferably check that your server does not contain any other application
3- import the project and execute mvn intsall and mvn update
4- Start the application and check that the tables are created correctly
5- Stop the application
6- Enter the following data into your database:






INSERT INTO `role` (`idRole`, `nomRole`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_PROF'),
(3, 'ROLE_CADRE_ADMIN'),
(4, 'ROLE_STUDENT'),
(5, 'ROLE_BIBLIO');


INSERT INTO `utilisateur` (`idUtilisateur`, `cin`, `email`, `nom`, `nomArabe`, `photo`, `prenom`, `prenomArabe`, `telephone`) VALUES
(8, 'AAAA', 'tarik@tarik.fr', 'BOUDAA', 'Tarik', NULL, 'Tarik', 'Boudaa', '060000000'),
(9, 'ABnh1', 'med1@med.com', 'BOUDAA', 'med', NULL, 'Mohamed', 'med', '2522255'),
(10, 'dqsdqsd', 'dqsdsqd', 'dqdqsd', 'dqsdqdqsd', NULL, 'dsqd', 'dqdqd', '12589632'),
(11, 'AB', 'dsqdqs', 'dsqd', 'dsqdqsd', NULL, 'aaa', 'dqsdqsd', '12589632'),
(12, 'BBBB', 'karama@karam.fr', 'KARAM', 'KARAM', NULL, 'KARAM', 'KARAM', '0666666666');


INSERT INTO `cadreadministrateur` (`grade`, `idCardreAdmin`) VALUES
('gradeeee', 8),
('Admin 2eme grade', 12);

INSERT INTO `enseignant` (`specialite`, `idEnseighant`) VALUES
('math', 10);

INSERT INTO `etudiant` (`cne`, `dateNaissance`, `idEtudiant`) VALUES
('aaaa', NULL, 9),
('dsqd', NULL, 11);



INSERT INTO `compte` (`idCompte`, `accepteDemandeAutorisationAbsence`, `accountNonExpired`, `accountNonLocked`, `afficheEmail`, `affichePhoto`, `credentialsNonExpired`, `disconnectAccount`, `enabled`, `login`, `password`, `idUtilisateur`, `idRole`) VALUES
(8, b'0', b'1', b'1', b'0', b'0', b'1', b'0', b'1', 'admin', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 8, 1),
(9, b'0', b'1', b'1', b'0', b'0', b'1', b'0', b'1', 'prof', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 9, 2),
(12, b'0', b'1', b'1', b'0', b'0', b'1', b'0', b'1', 'student', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 11, 4),
(13, b'0', b'1', b'1', b'0', b'0', b'1', b'0', b'1', 'cadre_admin', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 11, 3),
(14, b'0', b'1', b'1', b'0', b'0', b'1', b'0', b'1', 'biblio', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 12, 5);



			


7- Start the application then connect with the following accounts:
Compte admin :
**********
login:  admin pass : admin

Compte Student :
**********
login: student pass : admin

Compte cadre admin :
**********
login: cadre_admin pass : admin

Compte prof :
**********
login: prof pass : admin

