package interfaces.services;

import entitys.models.shop.checkout.CheckOut;
import interfaces.services.crud.CrudService;

public interface ICheckOutService<T extends CheckOut,ID> extends CrudService<T, ID> {

  
}
