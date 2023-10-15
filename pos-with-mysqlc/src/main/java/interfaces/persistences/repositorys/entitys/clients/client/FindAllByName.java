package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.List;

public interface FindAllByName<T extends Object> {
    
    List<T> findAllByName(String name) throws Exception;
}
