use case_study_md3;

-- danh sách cácc dịch vụ tại cửa hàng 
select * from service;

-- trạng thái của pet tại shop 
select * from pet ;

-- tìm kiếm pet theo tuổi  
select * from pet where age < ? and age > ?  ;
-- tìm kiếm theo giá tiền
select * from pet where price < ? and price > ? ;
-- tìm kiếm pet theo loại
select * from pet where species = ? ;

-- tìm kiếm theo tuổi và giá
select * from pet where (age < ? and age > ?) and ( price < ? and price > ?);
-- tìm kiếm theo tuổi và giống loại 
select * from pet where (age < ? and age > ?) and species = ? ;
-- tìm kiếm theo giá và giống loại
select * from pet where ( price < ? and price > ?) and species = ? ;

-- tìm kiếm theo tuổi và giá và giống 
select * from pet where (age < ? and age > ?) and ( price < ? and price > ?) and species = ? ;

-- hiển thị các giống có trong shop
select species from pet;

-- thêm động vật
insert into pet(petname,age,price,species,image,petstatus)
 value(?,?,?,?,?,?);
 
 -- update động vật
update pet 
set petname = ? , age = ? , price = ? , species = ? , image = ? , petstatus = ? 
where id = ? ;

-- delete động vật 
delete from pet 
where id = ? ;








