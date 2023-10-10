package interfaces.persistences.repositorys.clients.normalclient;

import interfaces.persistences.repositorys.clients.FindByLastName;
import interfaces.persistences.repositorys.clients.FindBySsn;
import interfaces.persistences.repositorys.clients.FindByName;
import interfaces.persistences.repositorys.clients.FindByAge;

public interface NormalClientRepository<T> extends FindByName<T>, FindByLastName<T>, FindByAge<T>, FindBySsn<T>{
    
}
