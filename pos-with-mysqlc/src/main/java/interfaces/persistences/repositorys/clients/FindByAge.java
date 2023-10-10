package interfaces.persistences.repositorys.clients;

import java.util.List;

public interface FindByAge<T extends Object> {

    <S extends T> List<S> findByAge();
}
