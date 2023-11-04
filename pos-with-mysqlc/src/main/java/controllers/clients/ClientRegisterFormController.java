package controllers.clients;

import entitiys.models.addres.StandardAddress;
import entitiys.models.client.Client;
import entitiys.models.phone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import interfaces.services.StandardAddressService;
import views.clients.ClientRegisterFormView;
import interfaces.services.TelephoneService;
import interfaces.services.ClientService;

public class ClientRegisterFormController implements ActionListener {

    /*Services*/
    private final ClientService clientServiceImp;

    private final StandardAddressService addressServiceImp;

    private final TelephoneService phoneServiceImp;

    /*VIEWS*/
    private final ClientRegisterFormView clientRegisterFormView;

    private Client client;

    private StandardAddress address;

    private Telephone telephone;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientService clientServiceImp, StandardAddressService addressServiceImp, TelephoneService phoneServiceImp) {

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

                client = clientServiceImp.create(Client.class);

                client.setName(clientRegisterFormView.getTxtName().getText());

                client.setLastName(clientRegisterFormView.getTxtLastName().getText());

                client.setAge(Integer.valueOf(clientRegisterFormView.getTxtAge().getText()));

                client.setAvailability(clientRegisterFormView.getJcbAvailability().isSelected());

                client.setSsn(clientRegisterFormView.getTxtSsn().getText());

                client.setClasification(clientRegisterFormView.getTxtClasification().getText());

                client = clientServiceImp.save(client);

                address = addressServiceImp.create(StandardAddress.class);

                address.setStreetDirection(clientRegisterFormView.getTxtStreetDirection().getText());

                address.setStreetNumber(Integer.valueOf(clientRegisterFormView.getTxtStreetNumber().getText()));

                address.setCity(clientRegisterFormView.getTxtCity().getText());

                address.setState(clientRegisterFormView.getTxtState().getText());

                address.setPostalCode(Integer.valueOf(clientRegisterFormView.getTxtPostalCode().getText()));

                address = addressServiceImp.save(address);

                telephone = phoneServiceImp.create(Telephone.class);

                telephone.setNumberPhone(Integer.valueOf(clientRegisterFormView.getTxtNumberPhone().getText()));

                telephone.setTypePhone(clientRegisterFormView.getTxtTypePhone().getText());

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
