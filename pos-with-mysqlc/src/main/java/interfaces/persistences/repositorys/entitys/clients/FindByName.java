package interfaces.persistences.repositorys.entitys.clients;

import java.util.List;

public interface FindByName<T extends Object> {
    
    List<T> findByName(String name);
}
