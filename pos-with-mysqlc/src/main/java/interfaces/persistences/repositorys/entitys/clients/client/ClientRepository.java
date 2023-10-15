package interfaces.persistences.repositorys.entitys.clients.client;

import interfaces.entitys.clients.Client;
import interfaces.persistences.crud.CrudRepository;

public interface ClientRepository<T extends Client, ID> extends FindAllByName<T>, FindAllByLastName<T>, FindAllByAge<T>, FindBySsn<T>, FindAllByClasification<T>, CrudRepository<T, ID> {
}