package interfaces.persistences.repositorys.entitys.clients;

import java.util.List;

public interface FindByAge<T extends Object> {

     List<T> findByAge();
}
