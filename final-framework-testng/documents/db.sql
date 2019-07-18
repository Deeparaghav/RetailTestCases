create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
insert into login values("naveen", "testing@123"); 


insert into testdata1 values(90,"sooman", "sooman", "bose", "sbose@abc.com", 9876543210, "Integer vitae iaculis massa", "SKU-003");

create table testdata1 (OrderId int, CustName varchar(50) not null, 
FirstName varchar(50), LastName varchar(50), Email varchar(50), phonenumber varchar(10) not null,
product varchar(100), model varchar(50));
