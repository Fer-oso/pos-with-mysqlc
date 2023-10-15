package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.List;

public interface FindAllByAge<T extends Object> {

     List<T> findAllByAge(int age) throws Exception;
}
