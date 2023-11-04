package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.ArrayList;

public interface FindAllByName<T extends Object> {
    
    ArrayList<T> findAllByName(String name) throws Exception;
}
