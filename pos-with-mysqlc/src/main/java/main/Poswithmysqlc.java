package main;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;
import interfaces.persistences.repositorys.entitys.address.StandardAddressRepository;
import persistence.dao.StandardAddressRepositoryImp;
import persistence.dao.TelephoneRepositoryImp;
import services.address.StandardAddressServiceImp;
import persistence.dao.StandardClientRepositoryImp;
import services.client.StandarClientServiceImp;
import services.phone.TelephoneServiceImp;
import interfaces.persistences.repositorys.entitys.clients.client.StandardClientRepository;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.StandardAddressService;
import interfaces.services.StandardClientService;
import interfaces.services.services.TelephoneService;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        // POS.main(args);
        StandardAddressRepository addressRepository = new StandardAddressRepositoryImp();

        StandardAddressService addressService = new StandardAddressServiceImp(addressRepository);

        TelephoneRepository phoneRepository = new TelephoneRepositoryImp();

        TelephoneService telephoneService = new TelephoneServiceImp(phoneRepository);

        StandardClientRepository standarClientRepository = new StandardClientRepositoryImp();

        StandardClientService standarClientService = new StandarClientServiceImp(standarClientRepository);

       // StandardAddress standarAddres = addressService.findById(12).get();
        
        //Telephone phone = telephoneService.findById(12).get();

        StandardClient standardClient = standarClientService.create(StandardClient.class);

        standardClient.setName("fer");
        standardClient.setLastName("Osorio");
        standardClient.setAge(29);
        standardClient.setClasification("normal");
        standardClient.setSsn("38128526");
        standardClient.setAvailability(true);

        standardClient = standarClientService.save(standardClient);
        
        
        
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
//        Phone telephone = phoneService.create(Telephone.class);
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
