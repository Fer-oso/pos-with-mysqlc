package interfaces.services;

import interfaces.entitys.addres.IAddress;
import interfaces.services.crud.CrudService;

public interface IAddressService<T extends IAddress, ID> extends CrudService<T, ID>{
}
