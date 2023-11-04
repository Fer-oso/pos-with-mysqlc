package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.ArrayList;

public interface FindAllByLastName<T extends Object> {

    ArrayList<T> findAllByLastName(String lastName) throws Exception;
}
