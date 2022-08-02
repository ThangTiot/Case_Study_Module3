create database case_study_md3;

use case_study_md3;

create table customer(
id int auto_increment primary key,
username varchar(50) not null,
pass varchar(50) not null,
phone varchar(10),
mail varchar(50),
address varchar(90)
);

create table petspecial(
id int auto_increment primary key,
special varchar(50),
checkDelete int not null
);

create table pet(
id int auto_increment primary key,
petName varchar(50),
age varchar(2),
price int not null,
petSpecialId int not null,
foreign key (petSpecialId) references petspecial (id),
image varchar(100),
petStatus varchar(50),
checkDelete int not null
);

create table ordercustomer(
id int auto_increment primary key,
customerId int not null,
foreign key (customerId) references customer (id),
dateCreateOrder date not null,
orderStatus varchar(50) not null
);

create table ordercustomerdetail(
petId int not null,
foreign key (petId) references pet(id),
orderCustomerId int not null,
foreign key(orderCustomerId) references ordercustomer(id),
primary key (petId, orderCustomerId)
);

create table service(
id int auto_increment primary key,
serviceName varchar(50) not null,
price int not null,
serviceDay int not null
);

create table orderCustomerService(
id int auto_increment primary key,
customerId int not null,
foreign key (customerId) references Customer (Id),
dateCreateService date not null,
orderServiceStatus varchar(50) not null
);

create table orderservicedetail(
serviceId int not null,
foreign key (serviceId) references service (id),
orderCustomerServiceId int not null,
foreign key(orderCustomerServiceId) references orderCustomerService(id),
quantity int,
primary key (serviceId, orderCustomerServiceId)
);


