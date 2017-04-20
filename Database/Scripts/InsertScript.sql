
/* Users */

INSERT INTO User (ID_User, Username, Registered) VALUES (1, 'Tomáš Moravec', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (2, 'Pavel Novotný', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (3, 'Karel Plachý', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (4, 'Patrik Šulc', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (5, 'Domonik Ferry', NOW());
INSERT INTO User (ID_User, Username, Registered) VALUES (6, 'Uživatel bez obrázku', NOW());

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

INSERT INTO Tag (Name) VALUES ('Animals');
INSERT INTO Tag (Name) VALUES ('Artistic');
INSERT INTO Tag (Name) VALUES ('Cartoons');
INSERT INTO Tag (Name) VALUES ('Celebrities');
INSERT INTO Tag (Name) VALUES ('City');
INSERT INTO Tag (Name) VALUES ('Computers');
INSERT INTO Tag (Name) VALUES ('Games');
INSERT INTO Tag (Name) VALUES ('Girls');
INSERT INTO Tag (Name) VALUES ('Movies');
INSERT INTO Tag (Name) VALUES ('Music');
INSERT INTO Tag (Name) VALUES ('Nature');
INSERT INTO Tag (Name) VALUES ('Space');
INSERT INTO Tag (Name) VALUES ('Sports');
INSERT INTO Tag (Name) VALUES ('Tag bez obrázku');

/* Image_Tags */

INSERT INTO Image_Tag (ID_Image, Name) VALUES (1, 'Animals');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (1, 'Artistic');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (2, 'Celebrities');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (3, 'Cartoons');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (4, 'Games');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (4, 'City');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (4, 'Computers');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (5, 'Girls');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (5, 'Music');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (6, 'Nature');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (6, 'Animals');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (6, 'Games');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (7, 'Space');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (8, 'Music');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (8, 'Sports');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (8, 'Space');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (8, 'Nature');
INSERT INTO Image_Tag (ID_Image, Name) VALUES (9, 'Sports');

/* Image_Ratings */

INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (1, 1, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (1, 2, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (1, 4, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (1, 5, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (1, 6, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (2, 2, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (2, 4, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (2, 5, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (3, 1, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (3, 6, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (4, 1, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (4, 2, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (4, 5, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (5, 4, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (5, 5, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (6, 5, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (6, 1, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (6, 6, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (7, 1, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (7, 3, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (8, 1, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (8, 2, FALSE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (8, 3, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (8, 4, TRUE);
INSERT INTO Image_Rating (ID_Image, ID_User, Rating) VALUES (8, 6, FALSE);

/* Comments */

INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (1, 1, 1, 'Snad se vám můj obrázek bude líbit', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (2, 1, 2, 'First', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (3, 1, 1, 'Nope', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (4, 1, 2, 'Omg...', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (5, 1, 3, 'Krásný obrázek', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (6, 2, 2, 'Nádherné', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (7, 2, 6, 'Lol...', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (8, 4, 3, 'Brilatní', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (9, 4, 4, 'Tak tak', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (10, 5, 1, 'Oooouc', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (11, 5, 2, 'Krása', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (12, 5, 5, 'Nice', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (13, 6, 5, 'Pecka', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (14, 6, 6, 'True', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (15, 7, 5, 'Noooo... nic moc', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (16, 8, 1, 'Kdy bude konec hodiny? :D', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (17, 8, 3, 'Nevím', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (18, 9, 4, 'Bože už nevydržím ani minutu', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (19, 9, 1, 'Iam dying here', NOW(), NOW());
INSERT INTO Comment (ID_Comment, ID_Image, ID_Author, Message, Created, Updated) VALUES (20, 9, 6, 'Kašlu na to, going home...', NOW(), NOW());

/* Comment_Ratings */

INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (1, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (2, 1, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (2, 3, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (2, 4, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (3, 5, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (4, 1, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (5, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (6, 3, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (6, 4, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (7, 5, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (7, 6, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (8, 1, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (8, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (9, 3, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (9, 5, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (9, 6, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (10, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (11, 1, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (11, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (11, 3, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (12, 4, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (13, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (13, 5, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (13, 6, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (14, 1, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (14, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (14, 3, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (15, 4, FALSE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (15, 5, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (15, 6, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 1, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 2, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 3, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 4, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 5, TRUE);
INSERT INTO Comment_Rating (ID_Comment, ID_User, Rating) VALUES (16, 6, FALSE);
