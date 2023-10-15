package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.List;

public interface FindAllByClasification<T extends Object> {
    
    List<T> findAllByClasification(String clasification) throws Exception;
}
