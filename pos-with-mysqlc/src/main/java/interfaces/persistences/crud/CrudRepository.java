package interfaces.persistences.crud;

import interfaces.persistences.repositorys.Repository;

public interface CrudRepository<T extends Object, ID extends Object> extends Crud<T, ID>, Repository<T, ID> {
}
