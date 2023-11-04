package interfaces.persistences.repositorys.entitys.clients.client;

import java.util.ArrayList;

public interface FindAllByAge<T extends Object> {

     ArrayList<T> findAllByAge(int age) throws Exception;
}
