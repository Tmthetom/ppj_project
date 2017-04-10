
/* Users */

INSERT INTO User (ID_User, Username, Registered) VALUES (1, 'Tomáš Moravec', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (2, 'Pavel Novotný', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (3, 'Karel Plachý', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (4, 'Patrik Šulc', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (5, 'Domonik Ferry', NOW());

/* Images */

INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (1, 1, 'Obrázek č. 1', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (2, 1, 'Obrázek č. 2', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (3, 1, 'Obrázek č. 3', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (4, 2, 'Obrázek č. 4', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (5, 3, 'Obrázek č. 5', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (6, 3, 'Obrázek č. 6', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (7, 4, 'Obrázek č. 7', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (8, 5, 'Obrázek č. 8', '../filepath/..', NOW(), NOW());
INSERT INTO Image (ID_Image, ID_Author, Name, Path, Created, Updated) VALUES (9, 5, 'Obrázek č. 9', '../filepath/..', NOW(), NOW());

/* Tags */

INSERT INTO Image (Name) VALUES ('Animals');
INSERT INTO Image (Name) VALUES ('Artistic');
INSERT INTO Image (Name) VALUES ('Cartoons');
INSERT INTO Image (Name) VALUES ('Celebrities');
INSERT INTO Image (Name) VALUES ('City');
INSERT INTO Image (Name) VALUES ('Computers');
INSERT INTO Image (Name) VALUES ('Games');
INSERT INTO Image (Name) VALUES ('Girls');
INSERT INTO Image (Name) VALUES ('Movies');
INSERT INTO Image (Name) VALUES ('Music');
INSERT INTO Image (Name) VALUES ('Nature');
INSERT INTO Image (Name) VALUES ('Space');
INSERT INTO Image (Name) VALUES ('Sports');

/* Image_Tags */

INSERT INTO Image (ID_Image, Name) VALUES (1, 'Animals');
INSERT INTO Image (ID_Image, Name) VALUES (1, 'Artistic');
INSERT INTO Image (ID_Image, Name) VALUES (2, 'Celebrities');
INSERT INTO Image (ID_Image, Name) VALUES (3, 'Cartoons');
INSERT INTO Image (ID_Image, Name) VALUES (4, 'Games');
INSERT INTO Image (ID_Image, Name) VALUES (4, 'City');
INSERT INTO Image (ID_Image, Name) VALUES (4, 'Computers');
INSERT INTO Image (ID_Image, Name) VALUES (5, 'Girls');
INSERT INTO Image (ID_Image, Name) VALUES (5, 'Music');
INSERT INTO Image (ID_Image, Name) VALUES (6, 'Nature');
INSERT INTO Image (ID_Image, Name) VALUES (6, 'Animals');
INSERT INTO Image (ID_Image, Name) VALUES (6, 'Games');
INSERT INTO Image (ID_Image, Name) VALUES (7, 'Space');
INSERT INTO Image (ID_Image, Name) VALUES (8, 'Music');
INSERT INTO Image (ID_Image, Name) VALUES (8, 'Sports');
INSERT INTO Image (ID_Image, Name) VALUES (8, 'Space');
INSERT INTO Image (ID_Image, Name) VALUES (8, 'Nature');
INSERT INTO Image (ID_Image, Name) VALUES (9, 'Sports');

/* Image_Ratings */

INSERT INTO Image (ID_Image, ID_User, Rating) VALUES (1, 'Animals');
























