package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.POS;
import views.clients.ClientFindByNameFormView;
import views.clients.ClientRegisterFormView;
import persistence.dao.StandardAddressRepositoryImp;
import persistence.dao.TelephoneRepositoryImp;
import services.address.StandardAddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import persistence.dao.ClientRepositoryImp;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.AddressService;
import interfaces.services.ClientService;

public class POSController implements ActionListener {

    POS pos;

    AddressRepository addressRepository = new StandardAddressRepositoryImp();

    AddressService addressService = new StandardAddressServiceImp(addressRepository);

    TelephoneRepository phoneRepository = new TelephoneRepositoryImp();

    TelephoneService phoneService = new TelephoneServiceImp(phoneRepository);

    ClientRepository clientRepository = new ClientRepositoryImp();

    ClientService clientService = new ClientServiceImp(clientRepository);

//    ShopFormView shopForm = new ShopFormView( clientService );
    // ProductRegisterFormView productRegisterFormView = new ProductRegisterFormView(productServiceImp);
    // ProductFindByPcFormView productFindByPcFormView = new ProductFindByPcFormView(productServiceImp);
    ClientRegisterFormView clientRegisterFormView = new ClientRegisterFormView(clientService, addressService, phoneService);

    ClientFindByNameFormView clientFindByNameFormView = new ClientFindByNameFormView(clientService,addressService,phoneService);

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

            //    pos.jTabbedPane1.addTab("", shopForm);     
        }

        if (e.getSource() == pos.jMenuItemProductByPC) {

            pos.jTabbedPane1.removeAll();

            //  pos.jTabbedPane1.addTab("", productFindByPcFormView);   
        }

        if (e.getSource() == pos.jMenuItemProductRegister) {

            pos.jTabbedPane1.removeAll();

            //   pos.jTabbedPane1.addTab("", productRegisterFormView); 
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
