package interfaces.services.services.interfaces;

import interfaces.entitys.phone.Phone;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.services.Service;

public interface PhoneService extends Service<Phone>, Save<Phone>, Update<Phone, Integer>, Delete<Integer>, FindById<Phone, Integer>,FindAll<Phone>{

}
