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

insert into Users(UserAccount,UserPassword,UserName,UserEmail)
values('admin3','1','josky','josky@gmail.com')

select * from users
drop table Users

SELECT * FROM Users WHERE UserAccount=' ' OR UserEmail=' '