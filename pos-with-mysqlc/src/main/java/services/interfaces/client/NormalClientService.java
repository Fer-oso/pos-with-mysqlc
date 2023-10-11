package services.interfaces.client;

import interfaces.persistences.repositorys.entitys.clients.FindByAge;
import interfaces.persistences.repositorys.entitys.clients.FindByLastName;
import interfaces.persistences.repositorys.entitys.clients.FindByName;
import interfaces.persistences.repositorys.entitys.clients.FindBySsn;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;

public interface NormalClientService<T extends Object, ID> extends Save<T>, Update<T, ID>, Delete<ID>, FindById<T,ID>, FindAll<T> ,FindByName<T>, FindByLastName<T>, FindByAge<T>, FindBySsn<T> {


}
