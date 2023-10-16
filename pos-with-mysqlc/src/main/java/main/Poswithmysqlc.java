package main;

import entitiys.client.RegularClient;
import entitiys.phone.Telephone;
import interfaces.entitys.phone.Phone;
import interfaces.persistences.repositorys.entitys.clients.normalclient.NormalClientRepository;
import persistence.dao.NormalClientRepositoryImp;
import services.client.NormalClientServiceImp;
import services.interfaces.NormalClientService;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.phones.PhoneRepository;
import persistence.dao.AddressRepositoryImp;
import persistence.dao.PhoneRepositoryImp;
import services.interfaces.AddressService;
import services.address.AddressServiceImp;
import services.interfaces.PhoneService;
import services.phone.PhoneServiceImp;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        NormalClientRepository norClientRepository = new NormalClientRepositoryImp();

        NormalClientService normalClientServiceImp = new NormalClientServiceImp(norClientRepository);
        
        
        AddressRepository addressRepository = new AddressRepositoryImp();
        
        AddressService addressService = new AddressServiceImp(addressRepository);
        
        
        PhoneRepository phoneRepository = new PhoneRepositoryImp();
        
        PhoneService phoneService = new PhoneServiceImp(phoneRepository);
        
        
        
        
        Phone telephone = phoneService.create(Telephone.class);
        
        System.out.println(phoneService.findById(1));
        
        
        RegularClient regularClient = normalClientServiceImp.create(RegularClient.class);
        
        System.out.println(regularClient);
        
        //normalClientServiceImp.save(normalClient);
        
        
        
      //  System.out.println(normalClientServiceImp.createNormalClient(RegularClient.class));

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
