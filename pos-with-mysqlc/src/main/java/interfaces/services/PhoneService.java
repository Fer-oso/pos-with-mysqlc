package interfaces.services;

import interfaces.entitys.phone.Phone;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;

public interface PhoneService<T extends Phone,ID> extends Service<T>, Save<T>, Update<T, ID>, Delete<ID>, FindById<T, Integer>,FindAll<T>{

}
