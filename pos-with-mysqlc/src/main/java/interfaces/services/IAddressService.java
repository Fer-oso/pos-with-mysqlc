package interfaces.services;

import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.entitys.addres.IAddress;

public interface IAddressService<T extends IAddress, ID> extends Service<T>,Save<T>, Update<T, ID>, Delete<ID>, FindById<T, ID>,FindAll<T>{
}
