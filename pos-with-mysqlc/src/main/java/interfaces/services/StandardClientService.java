package interfaces.services;

import entitiys.addres.StandardAddress;
import interfaces.services.services.interfaces.ClientService;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;

public interface StandardClientService extends ClientService<StandardClient, Integer> {

    void insertClientAddressPhone(StandardClient client, StandardAddress address, Telephone phone) throws Exception;
}
