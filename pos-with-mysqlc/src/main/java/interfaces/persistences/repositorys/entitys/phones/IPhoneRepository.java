package interfaces.persistences.repositorys.entitys.phones;

import interfaces.persistences.crud.CrudRepository;
import interfaces.entitys.phone.IPhone;

public interface IPhoneRepository<T extends IPhone,ID> extends CrudRepository<T, ID>{
    
}
