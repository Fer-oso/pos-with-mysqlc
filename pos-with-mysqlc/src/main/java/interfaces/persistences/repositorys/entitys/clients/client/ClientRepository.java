package interfaces.persistences.repositorys.entitys.clients.client;

import entitiys.models.addres.StandardAddress;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.persistences.crud.CrudRepository;
import java.util.ArrayList;

public interface ClientRepository extends FindAllByName<Client>, FindAllByLastName<Client>, FindAllByAge<Client>, FindBySsn<Client>, FindAllByClasification<Client>, CrudRepository<Client, Integer> {

    void insertClientAddress(Client client, StandardAddress address) throws Exception;

    void insertClientPhone(Client client, Telephone phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(Client client) throws Exception;

    ArrayList<StandardAddress> getAddressClients(Client client) throws Exception;
}
