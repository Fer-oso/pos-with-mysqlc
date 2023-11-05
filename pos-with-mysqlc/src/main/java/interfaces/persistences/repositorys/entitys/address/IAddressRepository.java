package interfaces.persistences.repositorys.entitys.address;

import interfaces.persistences.crud.CrudRepository;
import interfaces.entitys.addres.IAddress;

public interface IAddressRepository<T extends IAddress, ID> extends CrudRepository<T,ID>{

}
