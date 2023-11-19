package main;

import persistence.dao.AddressRepositoryImp;
import persistence.dao.TelephoneRepositoryImp;
import services.address.AddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import persistence.dao.ClientRepositoryImp;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import interfaces.services.ProductService;
import persistence.config.DbConnector;
import persistence.config.JdbcConnectorImp;
import persistence.dao.ProductRepositoryImp;
import services.products.ProductServiceImp;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        // POS.main(args);
        
        DbConnector dbConnector = new JdbcConnectorImp();
        
        AddressRepository addressRepository = new AddressRepositoryImp(dbConnector);

        AddressService addressService = new AddressServiceImp(addressRepository);

        TelephoneRepository phoneRepository = new TelephoneRepositoryImp(dbConnector);

        TelephoneService telephoneService = new TelephoneServiceImp(phoneRepository);

        ClientRepository ClientRepository = new ClientRepositoryImp(dbConnector);

        ClientService clientService = new ClientServiceImp(ClientRepository);
        
        ProductRepository productRepository = new ProductRepositoryImp(dbConnector);
        
        ProductService productService = new ProductServiceImp(productRepository);
 
         
       // FunctionalEjemplos functionalEjemplos = new FunctionalEjemplos();
        
       //  Product productToSave = new Product(1, "lupi", "asd", 100.00, 3, true, "fer");
//         
      //  productService.save(productToSave);
         
     // Product productDB = productService.findById(6);
//        
//        
//            
//         System.out.println(productDB);
//         productDB.setName("fer");
//         
      //  System.out.println(productService.update(5, productDB));
//                  
//        
//         System.out.println(productService.findAll());
        
       // productRepository.save(productDB);
       
//        Function<Product, Product> guardar = product ->  productService.save(product);
//                
//        Function<Product, Product> buscar = product -> productService.findById(product.getId());
//        
//        Consumer<Product> mostrar = product -> System.out.println("hello" + product ); 
      //  Function<Product, Product> mostrar = guardar.andThen(buscar);
        
    //    search.apply(productToSave);
        
       // Product product =guardar.andThen(buscar).apply(productToSave);
       
//       FunctionalEjemplos functionalEjemplos = new FunctionalEjemplos();
//       
//       
//      functionalEjemplos.guardarymostrar.accept(productToSave);
        
      //  functionalEjemplos.mostrar.accept(functionalEjemplos.guardar.andThen(functionalEjemplos.buscar).apply(productToSave));
        
//        Optional<Product> product4 = Optional.ofNullable(new Product());
//        
//        product4.ifPresent(functionalEjemplos.guardarymostrar);
        
    }
}