select ordercustomer.id, customer.username, ordercustomer.dateCreateOrder, ordercustomer.orderStatus
, sum(pet.price) from ordercustomer join ordercustomerdetail on ordercustomer.id = ordercustomerdetail.orderCustomerId
join pet on ordercustomerdetail.petId = pet.id join customer on ordercustomer.customerId = customer.id;