package interfaces.persistences.repositorys.entitys.clients;

import interfaces.entitys.clients.Client;

public interface ClientRepository<T extends Client> extends FindByName<T>, FindByLastName<T>, FindByAge<T>, FindBySsn<T>, FindByClasification<T>{
    
}
