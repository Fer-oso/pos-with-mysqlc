package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.POS;
import views.clients.ClientFindByNameFormView;
import views.clients.ClientRegisterFormView;
import persistence.dao.persistence.AddressRepositoryImp;
import persistence.dao.persistence.TelephoneRepositoryImp;
import services.address.AddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.telephone.TelephoneService;
import persistence.dao.persistence.ClientRepositoryImp;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;
import interfaces.services.address.AddressService;
import interfaces.services.client.ClientService;
import interfaces.services.product.ProductService;
import interfaces.services.shoppingcart.ShoppingCartService;
import persistence.config.DbConnector;
import persistence.config.JdbcConnectorImp;
import persistence.dao.persistence.ProductRepositoryImp;
import persistence.dao.persistence.ShoppingCartRepositoryImp;
import services.products.ProductServiceImp;
import services.shop.ShoppingCartServiceImp;
import views.products.ProductFindByPcFormView;
import views.products.ProductRegisterFormView;
import views.shop.ShopFormView;

public class POSController implements ActionListener {

    POS pos;

    DbConnector dbConnector = new JdbcConnectorImp();

    AddressRepository addressRepository = new AddressRepositoryImp(dbConnector);
    AddressService addressService = new AddressServiceImp(addressRepository);

    TelephoneRepository phoneRepository = new TelephoneRepositoryImp(dbConnector);
    TelephoneService phoneService = new TelephoneServiceImp(phoneRepository);

    ClientRepository clientRepository = new ClientRepositoryImp(dbConnector);
    ClientService clientService = new ClientServiceImp(clientRepository);

    ProductRepository productRepository = new ProductRepositoryImp(dbConnector);
    ProductService productService = new ProductServiceImp(productRepository);
    
    
    ShoppingCartRepository shoppingCartRepository = new ShoppingCartRepositoryImp(dbConnector);
    ShoppingCartService shoppingCartService = new ShoppingCartServiceImp(shoppingCartRepository);
    

    ShopFormView shopForm = new ShopFormView(productService, clientService, shoppingCartService);
    
    ProductRegisterFormView productRegisterFormView = new ProductRegisterFormView(productService);
    ProductFindByPcFormView productFindByPcFormView = new ProductFindByPcFormView(productService);
    
    ClientRegisterFormView clientRegisterFormView = new ClientRegisterFormView(clientService, addressService, phoneService);
    ClientFindByNameFormView clientFindByNameFormView = new ClientFindByNameFormView(clientService, addressService, phoneService);

    ShopFormView shopFormView = new ShopFormView(productService, clientService, shoppingCartService);
    
    public POSController(POS pos) {

        this.pos = pos;

        initActions();
    }

    private void initActions() {

        /*Shopping Views*/
        this.pos.jMenuItemShopForm.addActionListener(this);
        
        /*Product Views*/
        this.pos.jMenuItemProductRegister.addActionListener(this);
        this.pos.jMenuItemProductByPC.addActionListener(this);

        /*Client Views*/
        this.pos.jMenuItemClientRegister.addActionListener(this);
        this.pos.jMenuItemClientByName.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == pos.jMenuItemShopForm) {

            pos.jTabbedPane1.removeAll();

            pos.jTabbedPane1.addTab("", shopForm);     
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {

            pos.jTabbedPane1.removeAll();

            pos.jTabbedPane1.addTab("", productFindByPcFormView);
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {

            pos.jTabbedPane1.removeAll();

            pos.jTabbedPane1.addTab("", productRegisterFormView);
        }

        if (e.getSource() == pos.jMenuItemClientRegister) {

            pos.jTabbedPane1.removeAll();

            pos.jTabbedPane1.addTab("", clientRegisterFormView);
        }

        if (e.getSource() == pos.jMenuItemClientByName) {

            pos.jTabbedPane1.removeAll();

            pos.jTabbedPane1.addTab("", clientFindByNameFormView);
        }
    }
}
