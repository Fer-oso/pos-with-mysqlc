package services.interfaces;

import interfaces.persistences.repositorys.entitys.clients.client.FindBySsn;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByName;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByLastName;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByAge;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByClasification;
import interfaces.entitys.clients.NormalClient;
import interfaces.persistences.repositorys.entitys.Service;

public interface NormalClientService extends Service<NormalClient>,Save<NormalClient>, Update<NormalClient, Integer>, Delete<Integer>, FindById<NormalClient, Integer>, FindAll<NormalClient>, FindAllByName<NormalClient>, FindAllByLastName<NormalClient>, FindAllByAge<NormalClient>, FindBySsn<NormalClient>, FindAllByClasification<NormalClient> {

}
