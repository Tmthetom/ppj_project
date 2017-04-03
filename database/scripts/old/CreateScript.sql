Create table [User]
(
	[ID_User] Integer Identity NOT NULL,
	[Username] Nvarchar(20) NOT NULL,
	[Registrated] Datetime NOT NULL,
Primary Key ([ID_User])
) 
go

Create table [Image]
(
	[ID_Image] Integer Identity NOT NULL,
	[ID_ImageAuthor] Integer NOT NULL,
	[Name] Nvarchar(30) NOT NULL,
	[Path] Nvarchar(200) NOT NULL,
	[Created] Datetime NOT NULL,
	[Updated] Datetime NOT NULL,
Primary Key ([ID_Image],[ID_ImageAuthor])
) 
go

Create table [Tag]
(
	[Name] Nvarchar(16) NOT NULL, UNIQUE ([Name]),
Primary Key ([Name])
) 
go

Create table [ImageRating]
(
	[ID_Rating] Integer Identity NOT NULL,
	[ID_User] Integer NOT NULL,
	[ID_Image] Integer NOT NULL,
	[ID_ImageAuthor] Integer NOT NULL,
	[Rating] Bit NOT NULL,
Primary Key ([ID_Rating],[ID_User],[ID_Image],[ID_ImageAuthor])
) 
go

Create table [Comment]
(
	[ID_Comment] Integer Identity NOT NULL,
	[ID_CommentAuthor] Integer NOT NULL,
	[ID_Image] Integer NOT NULL,
	[ID_ImageAuthor] Integer NOT NULL,
	[Text] Nvarchar(100) NOT NULL,
	[Created] Datetime NOT NULL,
	[Updated] Datetime NOT NULL,
Primary Key ([ID_Comment],[ID_CommentAuthor],[ID_Image],[ID_ImageAuthor])
) 
go

Create table [CommentRating]
(
	[ID_Rating] Integer Identity NOT NULL,
	[ID_User] Integer NOT NULL,
	[ID_Comment] Integer NOT NULL,
	[ID_Image] Integer NOT NULL,
	[ID_ImageAuthor] Integer NOT NULL,
	[ID_CommentAuthor] Integer NOT NULL,
	[Rating] Bit NOT NULL,
Primary Key ([ID_Rating],[ID_User],[ID_Comment],[ID_Image],[ID_ImageAuthor],[ID_CommentAuthor])
) 
go

Create table [ImageTag]
(
	[TagName] Nvarchar(16) NOT NULL,
	[ID_Image] Integer NOT NULL,
	[ID_ImageAuthor] Integer NOT NULL,
Primary Key ([TagName],[ID_Image],[ID_ImageAuthor])
) 
go


Alter table [Image] add  foreign key([ID_ImageAuthor]) references [User] ([ID_User])  on update no action on delete no action 
go
Alter table [ImageRating] add  foreign key([ID_User]) references [User] ([ID_User])  on update no action on delete no action 
go
Alter table [Comment] add  foreign key([ID_CommentAuthor]) references [User] ([ID_User])  on update no action on delete no action 
go
Alter table [CommentRating] add  foreign key([ID_User]) references [User] ([ID_User])  on update no action on delete no action 
go
Alter table [ImageRating] add  foreign key([ID_Image],[ID_ImageAuthor]) references [Image] ([ID_Image],[ID_ImageAuthor])  on update no action on delete no action 
go
Alter table [Comment] add  foreign key([ID_Image],[ID_ImageAuthor]) references [Image] ([ID_Image],[ID_ImageAuthor])  on update no action on delete no action 
go
Alter table [ImageTag] add  foreign key([ID_Image],[ID_ImageAuthor]) references [Image] ([ID_Image],[ID_ImageAuthor])  on update no action on delete no action 
go
Alter table [ImageTag] add  foreign key([TagName]) references [Tag] ([Name])  on update no action on delete no action 
go
Alter table [CommentRating] add  foreign key([ID_Comment],[ID_CommentAuthor],[ID_Image],[ID_ImageAuthor]) references [Comment] ([ID_Comment],[ID_CommentAuthor],[ID_Image],[ID_ImageAuthor])  on update no action on delete no action 
go


Set quoted_identifier on
go


Set quoted_identifier off
go


