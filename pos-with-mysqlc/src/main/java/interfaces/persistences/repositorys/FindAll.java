package interfaces.persistences.repositorys;

import java.util.List;

public interface FindAll<T> {
    
    List<T> findAll() throws Exception;
}
