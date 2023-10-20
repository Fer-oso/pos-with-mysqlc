package interfaces.services;

import interfaces.entitys.clients.Client;
import interfaces.persistences.crud.Delete;
import interfaces.persistences.crud.Save;
import interfaces.persistences.crud.Update;
import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByAge;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByClasification;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByLastName;
import interfaces.persistences.repositorys.entitys.clients.client.FindAllByName;
import interfaces.persistences.repositorys.entitys.clients.client.FindBySsn;

public interface ClientService<T extends Client, ID> extends Service<T>,Save<T>, Update<T, ID>, Delete<Integer>, FindById<T, ID>, FindAll<T>, FindAllByName<T>, FindAllByLastName<T>, FindAllByAge<T>, FindBySsn<T>, FindAllByClasification<T> {
    
}
