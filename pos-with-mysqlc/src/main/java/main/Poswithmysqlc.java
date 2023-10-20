package main;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import entitiys.phone.Telephone;
import interfaces.entitys.phone.Phone;
import interfaces.persistences.repositorys.entitys.address.StandardAddressRepository;
import interfaces.persistences.repositorys.entitys.phones.PhoneRepository;
import persistence.dao.StandardAddressRepositoryImp;
import persistence.dao.PhoneRepositoryImp;
import services.address.StandardAddressServiceImp;
import interfaces.services.services.interfaces.PhoneService;
import persistence.dao.StandardClientRepositoryImp;
import services.client.StandarClientServiceImp;
import services.phone.PhoneServiceImp;
import interfaces.persistences.repositorys.entitys.clients.client.StandardClientRepository;
import interfaces.services.StandardAddressService;
import interfaces.services.StandardClientService;
import views.POS;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");
        
       // POS.main(args);
        

        StandardClientRepository standarClientRepository = new StandardClientRepositoryImp();

        StandardClientService standarClientService = new StandarClientServiceImp(standarClientRepository);
        
        
        StandardAddressRepository addressRepository = new StandardAddressRepositoryImp();
        
        StandardAddressService addressService = new StandardAddressServiceImp(addressRepository);
        
        PhoneRepository phoneRepository = new PhoneRepositoryImp();
        
        PhoneService phoneService = new PhoneServiceImp(phoneRepository);
        
        StandardAddress standarAddres = new StandardAddress();
        
        standarAddres.setStreetDirection("Islas Malvinas");
        
        standarAddres.setStreetNumber(2532);
        
        standarAddres.setCity("Isidro Casanova");
        
        standarAddres.setState("Buenos");
        
        standarAddres.setPostalCode(1765);
        
       
        
        addressService.save(standarAddres);
        
        
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
