package interfaces.persistences.repositorys.entitys.clients;

import java.util.List;

public interface FindByClasification<T extends Object> {
    
    <S extends T> List<S> findByClasification();
}
