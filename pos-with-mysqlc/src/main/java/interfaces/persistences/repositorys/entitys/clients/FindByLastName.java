package interfaces.persistences.repositorys.entitys.clients;

import java.util.List;

public interface FindByLastName<T extends Object> {
    
    List<T> findByLastName(String lastName);
}
