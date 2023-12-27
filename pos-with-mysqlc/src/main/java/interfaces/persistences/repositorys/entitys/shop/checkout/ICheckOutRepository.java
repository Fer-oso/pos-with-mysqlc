package interfaces.persistences.repositorys.entitys.shop.checkout;

import entitys.models.shop.checkout.CheckOut;
import interfaces.persistences.crud.CrudRepository;

public interface ICheckOutRepository<T extends CheckOut,ID> extends CrudRepository<T, ID>{
    
}
