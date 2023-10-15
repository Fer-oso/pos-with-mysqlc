package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.List;

public interface FindAllByLastName<T extends Object> {

    List<T> findAllByLastName(String lastName) throws Exception;
}
