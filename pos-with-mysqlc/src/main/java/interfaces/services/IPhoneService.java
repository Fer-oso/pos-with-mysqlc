package interfaces.services;

import interfaces.entitys.phone.IPhone;
import interfaces.services.crud.CrudService;

public interface IPhoneService<T extends IPhone,ID> extends CrudService<T, ID>{

}
