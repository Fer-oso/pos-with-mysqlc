package interfaces.persistences.repositorys.clients;

import java.util.List;

public interface FindByName<T extends Object> {
    
    <S extends T> List<S> findByName(String name);
}
