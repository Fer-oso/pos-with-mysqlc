package interfaces.persistences.repositorys.entitys.clients.client;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;

public interface StandardClientRepository extends ClientRepository<StandardClient, Integer>{
    
  void insertClientAddress(StandardClient client, StandardAddress address) throws Exception;
  
  void insertClientPhone(StandardClient client, Telephone phone) throws Exception;
}
