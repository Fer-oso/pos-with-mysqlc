package interfaces.persistences.repositorys.entitys.clients.client;

import entitiys.models.addres.StandardAddress;
import entitiys.dto.clientdto.StandardClient;
import entitiys.models.phone.Telephone;
import java.util.ArrayList;

public interface StandardClientRepository extends ClientRepository<StandardClient, Integer> {

    void insertClientAddress(StandardClient client, StandardAddress address) throws Exception;

    void insertClientPhone(StandardClient client, Telephone phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(StandardClient client) throws Exception;
    
    ArrayList<StandardAddress> getAddressClients(StandardClient client) throws Exception;
}
