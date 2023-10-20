package controllers;

import interfaces.persistences.repositorys.entitys.address.StandardAddressRepository;
import interfaces.persistences.repositorys.entitys.phones.PhoneRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaces.services.services.interfaces.PhoneService;

import views.POS;
import views.clients.ClientFindByNameFormView;
import views.clients.ClientRegisterFormView;
import persistence.dao.StandardAddressRepositoryImp;
import persistence.dao.PhoneRepositoryImp;
import persistence.dao.StandardClientRepositoryImp;
import services.address.StandardAddressServiceImp;
import services.client.StandarClientServiceImp;
import services.phone.PhoneServiceImp;
import interfaces.persistences.repositorys.entitys.clients.client.StandardClientRepository;
import interfaces.services.StandardAddressService;
import interfaces.services.StandardClientService;

public class POSController implements ActionListener {

    POS pos;

    StandardClientRepository standarClientRepository = new StandardClientRepositoryImp();

    StandardClientService normalClientService = new StandarClientServiceImp(standarClientRepository);

    StandardAddressRepository addressRepository = new StandardAddressRepositoryImp();

    StandardAddressService addressService = new StandardAddressServiceImp(addressRepository);

    PhoneRepository phoneRepository = new PhoneRepositoryImp();

    PhoneService phoneService = new PhoneServiceImp(phoneRepository);

//    ShopFormView shopForm = new ShopFormView( normalClientService );
    // ProductRegisterFormView productRegisterFormView = new ProductRegisterFormView(productServiceImp);
    // ProductFindByPcFormView productFindByPcFormView = new ProductFindByPcFormView(productServiceImp);
    ClientRegisterFormView clientRegisterFormView = new ClientRegisterFormView(normalClientService, addressService, phoneService);

    ClientFindByNameFormView clientFindByNameFormView = new ClientFindByNameFormView(normalClientService);

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
