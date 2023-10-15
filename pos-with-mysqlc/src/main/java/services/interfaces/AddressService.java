package services.interfaces;

import interfaces.entitys.addres.Address;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;

public interface AddressService extends Save<Address>, Update<Address, Integer>, Delete<Integer>, FindById<Address, Integer>,FindAll<Address>{
    
}
