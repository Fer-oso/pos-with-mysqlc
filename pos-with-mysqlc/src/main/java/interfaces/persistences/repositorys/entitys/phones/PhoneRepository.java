package interfaces.persistences.repositorys.entitys.phones;

import interfaces.entitys.phone.Phone;
import interfaces.persistences.crud.CrudRepository;

public interface PhoneRepository<T extends Phone,ID> extends CrudRepository<T, ID>{
    
}
