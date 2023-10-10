package interfaces.persistences.repositorys;

import java.util.List;

public interface FindAll<T extends Object> {
    
    List<T> findAll();
}
