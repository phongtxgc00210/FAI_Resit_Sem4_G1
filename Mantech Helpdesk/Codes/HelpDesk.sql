use master
go
create database HelpDesk1507
go
use HelpDesk1507
go
create table Users
(
	UserID int identity(1,1) primary key,
	UserAccount nvarchar(50),
	UserPassword nvarchar(50),
	UserName nvarchar(50),
	UserEmail nvarchar(50),
	UserRole int default 2
)

create table Complaints
(
	ComplaintID int identity(1,1) primary key,
	ComplaintTitle nvarchar(50),
	ComplaintDetails nvarchar(1000),
	CreateDate datetime NOT NULL DEFAULT GETDATE(),
	ComplaintStatus nvarchar(10) default 'pending',
	UserID int foreign key references Users(UserID)
)

select * from Complaints

drop table Complaints

insert into Users(UserAccount,UserPassword,UserName,UserEmail,UserRole)
values('technical1','1','technical 1','technical1@gmail.com',3),
('technical2','1','technical 2','technical2@gmail.com',3),
('technical3','1','technical 3','technical3@gmail.com',3),
('technical4','1','technical 4','technical4@gmail.com',3),
('technical5','1','technical 5','technical5@gmail.com',3)


select * from users
drop table Users

SELECT * FROM Users WHERE UserAccount=' ' OR UserEmail=' '
SELECT * FROM Complaints WHERE UserID=''
SELECT * FROM Complaints WHERE UserID='1'
INSERT INTO Complaints(ComplaintTitle,ComplaintDetails,UserID) VALUES(N'new complaint',N'My new complaint is problems','1')