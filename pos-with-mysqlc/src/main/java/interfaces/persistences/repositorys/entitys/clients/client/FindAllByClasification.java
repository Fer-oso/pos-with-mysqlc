package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.ArrayList;

public interface FindAllByClasification<T extends Object> {
    
    ArrayList<T> findAllByClasification(String clasification) throws Exception;
}
