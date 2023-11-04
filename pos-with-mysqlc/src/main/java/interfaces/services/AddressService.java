package interfaces.services;

import interfaces.entitys.addres.Address;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;

public interface AddressService<T extends Address, ID> extends Service<T>,Save<T>, Update<T, ID>, Delete<ID>, FindById<T, ID>,FindAll<T>{
}
