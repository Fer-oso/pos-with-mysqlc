package interfaces.persistences.repositorys.entitys.clients.normalclient;

import entitiys.client.NormalClient;
import interfaces.persistences.crud.CrudRepository;
import interfaces.persistences.repositorys.entitys.clients.ClientRepository;

public interface NormalClientRepository extends ClientRepository<NormalClient>, CrudRepository<NormalClient, Integer>{  
}
