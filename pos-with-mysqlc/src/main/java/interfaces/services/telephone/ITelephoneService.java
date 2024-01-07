package interfaces.services.telephone;

import interfaces.entitys.phone.IPhone;
import interfaces.services.crud.CrudService;

public interface ITelephoneService<T extends IPhone,ID> extends CrudService<T, ID>{

}
