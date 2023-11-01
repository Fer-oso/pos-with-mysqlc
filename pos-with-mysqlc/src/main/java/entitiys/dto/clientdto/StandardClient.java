package entitiys.dto.clientdto;

import entitiys.models.client.Client;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import interfaces.entitys.addres.Address;
import interfaces.entitys.phone.Phone;

@NoArgsConstructor
@ToString
public class StandardClient extends Client{

    private static final long serialVersionUID = 1L;

    Client client;
    private ArrayList<Address> address;
    private ArrayList<Phone> phone;

    public StandardClient(Client client, ArrayList<Address> address, ArrayList<Phone> phone) {
        this.client = client;
        this.address = address;
        this.phone = phone;
    }
}
