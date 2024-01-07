package controllers.clients;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.phone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.clients.ClientRegisterFormView;
import interfaces.services.telephone.TelephoneService;
import interfaces.services.address.AddressService;
import interfaces.services.client.ClientService;
import java.awt.HeadlessException;
import java.util.ArrayList;
import lombok.SneakyThrows;

public class ClientRegisterFormController implements ActionListener {

    /*Services*/
    private final ClientService clientServiceImp;

    private final AddressService addressServiceImp;

    private final TelephoneService telehponeServiceImp;

    Client client;

    Address address;

    Telephone telephone;
    
    Telephone telephone2;

    /*VIEWS*/
    private final ClientRegisterFormView clientRegisterFormView;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientService clientServiceImp, AddressService addressServiceImp, TelephoneService telehponeServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        this.addressServiceImp = addressServiceImp;

        this.telehponeServiceImp = telehponeServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        clientRegisterFormView.getBtnSave().addActionListener(this);

        clientRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientRegisterFormView.getBtnSave()) {

            try {

                createNewClient();

                save(client, address, telephone);

                clearForm();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

            if (e.getSource() == clientRegisterFormView.getBtnCancel()) {

                clearForm();
            }
        }
    }

    /*Functions*/
    private void createNewClient() throws Exception {

        try {

            if (checkFields()) {

                client = new Client(null,
                        clientRegisterFormView.getTxtName().getText(),
                        clientRegisterFormView.getTxtLastName().getText(),
                        Integer.valueOf(clientRegisterFormView.getTxtAge().getText()),
                        clientRegisterFormView.getTxtSsn().getText(),
                        clientRegisterFormView.getTxtClasification().getText(),
                        clientRegisterFormView.getJcbAvailability().isSelected(),
                        new ArrayList<>(),
                        new ArrayList<>());

                address = new Address(null,
                        clientRegisterFormView.getTxtStreetDirection().getText(),
                        Integer.valueOf(clientRegisterFormView.getTxtStreetNumber().getText()),
                        clientRegisterFormView.getTxtCity().getText(),
                        clientRegisterFormView.getTxtState().getText(),
                        Integer.valueOf(clientRegisterFormView.getTxtPostalCode().getText()));

                telephone = new Telephone(null,
                        Integer.valueOf(clientRegisterFormView.getTxtNumberPhone().getText()),
                        clientRegisterFormView.getTxtTypePhone().getText());
                
                telephone2 = new Telephone(null,
                        Integer.valueOf(clientRegisterFormView.getTxtNumberPhone2().getText()),
                        clientRegisterFormView.getTxtTypePhone2().getText());
            }

        } catch (HeadlessException | NumberFormatException e) {

            throw new Exception(e.getMessage());
        }
    }

    @SneakyThrows
    private void save(Client client, Address address, Telephone telephone) {

        if (clientServiceImp.checkDuplicateRegister(client)) {

            JOptionPane.showMessageDialog(null, "Client already registered, can find him with SSN " + client.getSsn());

        } else {

            client = clientServiceImp.save(client);

            address = addressServiceImp.save(address);

            telephone = telehponeServiceImp.save(telephone);
            
            telephone2 = telehponeServiceImp.save(telephone2);

            clientServiceImp.insertClientAddress(client, address);
            
            clientServiceImp.insertClientPhones(client, telephone,telephone2);

            JOptionPane.showMessageDialog(clientRegisterFormView, "Client registered succesfully");
        }

    }

    private boolean checkFields() {

        if (clientRegisterFormView.getTxtName().getText().equals("") || clientRegisterFormView.getTxtLastName().getText().equals("")
                || clientRegisterFormView.getTxtAge().getText().equals("") || clientRegisterFormView.getTxtSsn().getText().equals("")
                || clientRegisterFormView.getTxtClasification().getText().equals("") || clientRegisterFormView.getTxtNumberPhone().getText().equals("")
                || clientRegisterFormView.getTxtTypePhone().getText().equals("") || clientRegisterFormView.getTxtStreetDirection().getText().equals("")
                || clientRegisterFormView.getTxtStreetNumber().getText().equals("") || clientRegisterFormView.getTxtPostalCode().getText().equals("")
                || clientRegisterFormView.getTxtCity().getText().equals("") || clientRegisterFormView.getTxtState().getText().equals("")) {

            JOptionPane.showMessageDialog(clientRegisterFormView, "All fields required");

            return false;
        }

        return true;
    }

    private void clearForm() {

        clientRegisterFormView.getLblId().setText("");

        clientRegisterFormView.getTxtName().setText("");

        clientRegisterFormView.getTxtLastName().setText("");

        clientRegisterFormView.getTxtAge().setText("");
        
        clientRegisterFormView.getTxtClasification().setText("");

        clientRegisterFormView.getJcbAvailability().setSelected(false);

        clientRegisterFormView.getTxtSsn().setText("");

        clientRegisterFormView.getTxtNumberPhone().setText("");

        clientRegisterFormView.getTxtTypePhone().setText("");

        clientRegisterFormView.getTxtStreetDirection().setText("");

        clientRegisterFormView.getTxtStreetNumber().setText("");

        clientRegisterFormView.getTxtCity().setText("");

        clientRegisterFormView.getTxtPostalCode().setText("");

        clientRegisterFormView.getTxtState().setText("");
    }

}
