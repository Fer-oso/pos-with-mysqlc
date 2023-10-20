package interfaces.persistences.repositorys.entitys.address;

import interfaces.entitys.addres.Address;
import interfaces.persistences.crud.CrudRepository;

public interface AddressRepository<T extends Address, ID> extends CrudRepository<T,ID>{

}
