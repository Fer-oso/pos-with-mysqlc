package services.interfaces.client;

import interfaces.persistences.repositorys.clients.FindByAge;
import interfaces.persistences.repositorys.clients.FindByLastName;
import interfaces.persistences.repositorys.clients.FindByName;
import interfaces.persistences.repositorys.clients.FindBySsn;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindById;

public interface NormalClientService<NormalClient, ID> extends Save<NormalClient>, Update<NormalClient, ID>, Delete<ID>, FindById<NormalClient,ID>, FindByName<NormalClient>, FindByLastName<NormalClient>, FindByAge<NormalClient>, FindBySsn<NormalClient> {


}
