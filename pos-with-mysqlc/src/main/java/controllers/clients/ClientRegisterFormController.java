package controllers.clients;

import entitiys.addres.StandardAddress;
import entitiys.client.StandardClient;
import interfaces.entitys.clients.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import interfaces.services.StandardAddressService;
import interfaces.services.services.interfaces.PhoneService;
import views.clients.ClientRegisterFormView;
import interfaces.services.StandardClientService;

public class ClientRegisterFormController extends MouseAdapter implements ActionListener {
    
        /*Services*/
    private final StandardClientService clientServiceImp;

    private final StandardAddressService addressServiceImp;

    private final PhoneService phoneServiceImp;

    /*VIEWS*/
    private final ClientRegisterFormView clientRegisterFormView;

    private DefaultTableModel model = new DefaultTableModel();

    private ArrayList<Client> listClients;

    private Client client;
    
    

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, StandardClientService clientServiceImp, StandardAddressService addressServiceImp, PhoneService phoneServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        this.addressServiceImp = addressServiceImp;

        this.phoneServiceImp = phoneServiceImp;

        addACtionsListeners();
    }
    
 

    /*Actions*/
    private void addACtionsListeners() {

        clientRegisterFormView.getJtTableClients().addMouseListener(this);

        clientRegisterFormView.getBtnSave().addActionListener(this);

        clientRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == clientRegisterFormView.getBtnSave()) {
//
//            if (createNewClient()) {
//
//                save();
//
//                clearForm();
//
//                refreshTable();
//
//                listClients();
//            }
//
//            System.out.println(listClients);
//        }
//
//        if (e.getSource() == clientRegisterFormView.getBtnCancel()) {
//
//            clearForm();
//
//            refreshTable();
//
//            listClients = clientServiceImp.findAll();
//
//            listClients();
//        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientRegisterFormView.getJtTableClients()) {

            //  getClientSelectedOfTable();
            // setFormWithSelectedClient();
        }
    }

    /*Functions*/
    private boolean createNewClient() throws Exception {

        if (checkFields()) {

            client = clientServiceImp.create(StandardClient.class);
           
            client.setName(clientRegisterFormView.getTxtName().getText());

            client.setLastName(clientRegisterFormView.getTxtLastname().getText());

            client.setAge(Integer.valueOf(clientRegisterFormView.getTxtAge().getText()));

            client.setAvailability(clientRegisterFormView.getJcbAvailability().isSelected());

            client.setSsn(clientRegisterFormView.getTxtSsn().getText());

            client.setClasification(clientRegisterFormView.getTxtClasification().getText());

            StandardAddress address = addressServiceImp.create(StandardAddress.class);

            address.setStreetDirection(clientRegisterFormView.getTxtStreetDirection().getText());

            address.setStreetNumber(Integer.valueOf(clientRegisterFormView.getTxtStreetNumber().getText()));

            address.setCity(clientRegisterFormView.getTxtCity().getText());

            address.setState(clientRegisterFormView.getTxtState().getText());

            address.setPostalCode(Integer.valueOf(clientRegisterFormView.getTxtPostalCode().getText()));
            
            address = addressServiceImp.save(address);

        }

        return true;
    }

    private boolean checkFields() {

        if (clientRegisterFormView.getTxtName().getText().equals("") || clientRegisterFormView.getTxtLastname().getText().equals("")
                || clientRegisterFormView.getTxtAge().getText().equals("") || clientRegisterFormView.getTxtSsn().getText().equals("")
                || clientRegisterFormView.getTxtClasification().getText().equals("") || clientRegisterFormView.getTxtPhone().getText().equals("")
                || clientRegisterFormView.getTxtTypePhone().getText().equals("") || clientRegisterFormView.getTxtStreetDirection().getText().equals("")
                || clientRegisterFormView.getTxtStreetNumber().getText().equals("") || clientRegisterFormView.getTxtPostalCode().getText().equals("")
                || clientRegisterFormView.getTxtCity().getText().equals("") || clientRegisterFormView.getTxtState().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        return true;
    }

//    private Client save() {
//
//        return clientServiceImp.save(client);
//    }
//    public void listClients() {
//
//        this.listClients = clientServiceImp.findAll();
//
//        model = (DefaultTableModel) clientRegisterFormView.getJtTableClients().getModel();
//
//        this.clientRegisterFormView.getJtTableClients().setModel(model);
//
//        for (var cl : listClients) {
//
//            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
//                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};
//
//            model.addRow(clientObject);
//        }
//    }
//
//    private void getClientSelectedOfTable() {
//
//        int row = clientRegisterFormView.getJtTableClients().getSelectedRow();
//
//        client = listClients.get(row);
//    }
//
//    private void setFormWithSelectedClient() {
//
//        clientRegisterFormView.getLblId().setText(String.valueOf(client.getId()));
//
//        clientRegisterFormView.getTxtName().setText(client.getName());
//
//        clientRegisterFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));
//
//        clientRegisterFormView.getTxtAge().setText(String.valueOf(client.getAge()));
//
//        checkAvailability();
//
//        clientRegisterFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));
//
//        clientRegisterFormView.getTxtPhone().setText(client.getPhoneNumber());
//    }
//
//    private void checkAvailability() {
//
//        if (client.isAvailability()) {
//
//            this.clientRegisterFormView.getJcbAvailability().setSelected(true);
//
//        } else {
//
//            this.clientRegisterFormView.getJcbAvailability().setSelected(false);
//        }
//    }
//
//    private void clearForm() {
//
//        clientRegisterFormView.getLblId().setText("");
//
//        clientRegisterFormView.getTxtName().setText("");
//
//        clientRegisterFormView.getTxtLastname().setText("");
//
//        clientRegisterFormView.getTxtAge().setText("");
//
//        checkAvailability();
//
//        clientRegisterFormView.getTxtSsn().setText("");
//
//        clientRegisterFormView.getTxtPhone().setText("");
//    }
//
//    public void refreshTable() {
//
//        for (int i = 0; i < model.getRowCount(); i++) {
//
//            model.removeRow(i);
//
//            i = i - 1;
//
//        }
//    }
}
