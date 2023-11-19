package controllers.clients;

import entitiys.models.addres.Address;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import interfaces.entitys.addres.IAddress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.clients.ClientRegisterFormView;
import interfaces.services.TelephoneService;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import java.util.ArrayList;
import java.util.List;

public class ClientRegisterFormController implements ActionListener {

    /*Services*/
    private final ClientService clientServiceImp;

    private final AddressService addressServiceImp;

    private final TelephoneService phoneServiceImp;

    /*VIEWS*/
    private final ClientRegisterFormView clientRegisterFormView;

    private Client client;

    private Address address;

    private Telephone telephone;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientService clientServiceImp, AddressService addressServiceImp, TelephoneService phoneServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        this.addressServiceImp = addressServiceImp;

        this.phoneServiceImp = phoneServiceImp;

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

                client = clientServiceImp.save(client);

                address = new Address(null,
                        clientRegisterFormView.getTxtStreetDirection().getText(),
                        Integer.valueOf(clientRegisterFormView.getTxtStreetNumber().getText()),
                        clientRegisterFormView.getTxtCity().getText(),
                        clientRegisterFormView.getTxtState().getText(),
                        Integer.valueOf(clientRegisterFormView.getTxtPostalCode().getText()));

                address = addressServiceImp.save(address);

                telephone = new Telephone(null, 
                        Integer.valueOf(clientRegisterFormView.getTxtNumberPhone().getText()),
                        clientRegisterFormView.getTxtTypePhone().getText());

                telephone = phoneServiceImp.save(telephone);

                clientServiceImp.insertClientAddressPhone(client, address, telephone);

                JOptionPane.showMessageDialog(clientRegisterFormView, "Client created succesfully");
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());
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
