package main;

import entitiys.models.product.Product;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import interfaces.services.ProductService;
import interfaces.services.TelephoneService;
import java.util.function.Consumer;
import java.util.function.Function;
import persistence.config.DbConnector;
import persistence.config.JdbcConnectorImp;
import persistence.dao.AddressRepositoryImp;
import persistence.dao.ClientRepositoryImp;
import persistence.dao.ProductRepositoryImp;
import persistence.dao.TelephoneRepositoryImp;
import services.address.AddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;
import services.products.ProductServiceImp;

public class FunctionalEjemplos {
    
    public  FunctionalEjemplos(){}

    DbConnector dbConnector = new JdbcConnectorImp();

    AddressRepository addressRepository = new AddressRepositoryImp(dbConnector);

    AddressService addressService = new AddressServiceImp(addressRepository);

    TelephoneRepository phoneRepository = new TelephoneRepositoryImp(dbConnector);

    TelephoneService telephoneService = new TelephoneServiceImp(phoneRepository);

    ClientRepository ClientRepository = new ClientRepositoryImp(dbConnector);

    ClientService clientService = new ClientServiceImp(ClientRepository);

    ProductRepository productRepository = new ProductRepositoryImp(dbConnector);

    ProductService productService = new ProductServiceImp(productRepository);

    Product productToSave = new Product(1, "raul", "asd", 100.00, 3, true, "fer");

    Function<Product, Product> guardar = product -> productService.save(product);
    
    Function<Product, Integer> obtenerId = Product::getId;

    Function<Integer, Product> buscar = id -> productService.findById(id);

    Consumer<Product> guardarymostrar = (product) ->  guardar.andThen(obtenerId).andThen(buscar).apply(product);
    
    
}
