package main;

import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import persistence.dao.StandardAddressRepositoryImp;
import persistence.dao.TelephoneRepositoryImp;
import services.address.StandardAddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import persistence.dao.ClientRepositoryImp;
import java.util.ArrayList;
import interfaces.entitys.phone.IPhone;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.AddressService;
import interfaces.services.IClientService;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        // POS.main(args);
        AddressRepository addressRepository = new StandardAddressRepositoryImp();

        AddressService addressService = new StandardAddressServiceImp(addressRepository);

        TelephoneRepository phoneRepository = new TelephoneRepositoryImp();

        TelephoneService telephoneService = new TelephoneServiceImp(phoneRepository);

        ClientRepository ClientRepository = new ClientRepositoryImp();

        IClientService standarClientService = new ClientServiceImp(ClientRepository);

       // StandardAddress standarAddres = addressService.findById(12).get();
        
        //Telephone phone = telephoneService.findById(12).get();

        Client client = new Client();
        
        Telephone telephone = new Telephone(1, 123, "Movil");
        Telephone telephone1 = new Telephone(2,456,"Phone");
        
        ArrayList<IPhone> phonelists = new ArrayList<>();
        
        phonelists.add(telephone);
        phonelists.add(telephone1);
        
        client.setPhone(phonelists);
        
        System.out.println(client);

     //   standardClient = standarClientService.save(standardClient);
        
     //   System.out.println(standarClientService.getPhonesClients(standardClient));
        
     //   standarClientService.insertClientAddressPhone(standardClient, standarAddres, phone);
        
        

//        standarAddres.setStreetDirection("Islas Malvinas");
//        
//        standarAddres.setStreetNumber(2532);
//        
//        standarAddres.setCity("Isidro Casanova");
//        
//        standarAddres.setState("Buenos");
//        
//        standarAddres.setPostalCode(1765);
//        
//       
//        
//        addressService.save(standarAddres);
//        IPhone telephone = phoneService.create(Telephone.class);
//        
//        System.out.println(phoneService.findById(1));
//        
//        
//        StandardClient regularClient = standarClientService.create(StandardClient.class);
//        
//        System.out.println(regularClient);
        //normalClientServiceImp.save(normalClient);
        //  System.out.println(normalClientServiceImp.createNormalClient(StandardClient.class));
        // System.out.println(normalClientServiceImp.findAll());
        // norClientRepository.save(normalClient);
//        NormalClient normalClient = normalClientServiceImp.createNormalClient();
//        
//        normalClient.getAddress();
//
//        normalClientServiceImp.save(normalClient);
//
//        // List<NormalClient> normalClientList = normalClientServiceImp.findAll();
//        System.out.println();
//          
//          System.out.println(normalClientList);
//          
//        normalClient.setName("JEJEJE");
//        normalClient.setLastName("Osorio");
//        normalClient.setAge(29);
//        normalClient.setSsn("38128526");
//        normalClient.setClasification("Vip");
//        normalClient.setAddress(new Address());
    }
}
