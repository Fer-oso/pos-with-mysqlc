package controllers.clients;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.phone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;

import views.clients.ClientFindByNameFormView;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import interfaces.entitys.clients.IClient;
import interfaces.services.TelephoneService;
import java.io.Serializable;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientFindByNameController extends MouseAdapter implements ActionListener, Serializable {

    private static final long serialVersionUID = 1L;

    private final ClientFindByNameFormView clientFindByNameFormView;

    private final ClientService clientServiceImp;
    private final TelephoneService telephoneServiceImp;
    private final AddressService addressServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Client> listClients;

    private int row;
    private int id;
    private Client client;
    private Telephone telephone;
    private Address address;

    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameFormView clientFindByNameFormView, ClientService clientServiceImp, AddressService addressServiceImp, TelephoneService telephoneServiceImp) {

        this.clientFindByNameFormView = clientFindByNameFormView;

        this.clientServiceImp = clientServiceImp;

        this.telephoneServiceImp = telephoneServiceImp;

        this.addressServiceImp = addressServiceImp;

        addActionsListeners();
    }

    /*Actions*/
    private void addActionsListeners() {

        clientFindByNameFormView.getJtTableClients().addMouseListener(this);

        clientFindByNameFormView.getBtnSearch().addActionListener(this);

        clientFindByNameFormView.getBtnEdit().addActionListener(this);

        clientFindByNameFormView.getBtnDelete().addActionListener(this);

        clientFindByNameFormView.getBtnCancel().addActionListener(this);

        clientFindByNameFormView.getJcbPhones().addActionListener(this);
        
        clientFindByNameFormView.getJcbStreetDirection().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByNameFormView.getBtnSearch()) {

            try {

                if (!searchButton()) {

                    refreshTable();

                    String value = clientFindByNameFormView.getTxtSearch().getText().toLowerCase();

                    listClients = findAllBy(value);

                    listClients(listClients);
                }

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

        }

        if (e.getSource() == clientFindByNameFormView.getBtnEdit()) {

            try {

                if (setClientwithDataOfForm()) {

                    telephoneServiceImp.update(telephone.getId(), telephone);
                    
                    addressServiceImp.update(address.getId(), address);

                    editClient(id, client);

                    loadList();

                }

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

        }

        if (e.getSource() == clientFindByNameFormView.getBtnDelete()) {

            try {

                deleteClient(id);

                loadList();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == clientFindByNameFormView.getBtnCancel()) {

            try {

                loadList();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == clientFindByNameFormView.getJcbPhones()) {

            editTelephone();
        }
        
        if (e.getSource() == clientFindByNameFormView.getJcbStreetDirection()) {
            
           editAddress();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientFindByNameFormView.getJtTableClients()) {

            try {
                getClientSelectedOfTable();

                setFormWithSelectedClient();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }

    /*FUNCTIONS*/
 /*Load information*/
    public void loadList() {
        try {

            refreshTable();

            clearForm();

            listClients = clientServiceImp.findAll();

            listClients(listClients);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    /*Functions to setting data in Form and Table*/
    private void listClients(ArrayList<Client> listClients) throws Exception {

        try {

            model = (DefaultTableModel) clientFindByNameFormView.getJtTableClients().getModel();

            for (IClient cl : listClients) {

                Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                    cl.isAvailability(), cl.getSsn(), cl.getClasification()};

                model.addRow(clientObject);
            }

            this.clientFindByNameFormView.getJtTableClients().setModel(model);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void setModelJcbPhones() {

        try {

            ArrayList<Telephone> phoneList = clientServiceImp.getPhonesClients(client);

            clientFindByNameFormView.getJcbPhones().removeAllItems();

            clientFindByNameFormView.getJcbPhones().setEditable(true);

            for (Telephone telephone : phoneList) {

                clientFindByNameFormView.getJcbPhones().addItem(telephone);
            }

        } catch (Exception ex) {

            Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setModelJcbAddress() {

        try {

            ArrayList<Address> addressList = clientServiceImp.getAddressClients(client);

            clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

            clientFindByNameFormView.getJcbStreetDirection().setEditable(true);

            for (Address address : addressList) {

                clientFindByNameFormView.getJcbStreetDirection().addItem(address);
            }

        } catch (Exception ex) {

            Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean searchButton() {

        if (clientFindByNameFormView.getTxtSearch().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Insert Value");

            return true;
        }

        return false;
    }

    private ArrayList<Client> findAllBy(String value) {

        if (!(value.charAt(0) >= 97 && value.charAt(0) <= 122)) {

            return clientServiceImp.findAllBy(Integer.valueOf(value));
        }

        return clientServiceImp.findAllBy(value);
    }

    /*Functions to manipulate Client*/
    private void editClient(Integer id, Client client) throws Exception {

        try {

            clientServiceImp.update(id, client);

            JOptionPane.showMessageDialog(null, "Client edited succesfully");

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Error editing client");

            System.out.println(e.getMessage());
        }
    }

    private void deleteClient(Integer id) throws Exception {

        try {

            clientServiceImp.delete(id);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private boolean setClientwithDataOfForm() {

        if (clientFindByNameFormView.getTxtName().getText().equals("") || clientFindByNameFormView.getTxtLastname().getText().equals("")
                || clientFindByNameFormView.getTxtAge().getText().equals("") || clientFindByNameFormView.getTxtSsn().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        /*Edicion de entidad IClient*/
        client.setName(clientFindByNameFormView.getTxtName().getText());

        client.setLastName(clientFindByNameFormView.getTxtLastname().getText());

        client.setAge(Integer.valueOf(clientFindByNameFormView.getTxtAge().getText()));

        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        client.setSsn(clientFindByNameFormView.getTxtSsn().getText());

        client.setClasification(clientFindByNameFormView.getTxtClasification().getText());

        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        // editTelephone();
        telephone.setNumberPhone(Integer.valueOf(clientFindByNameFormView.getJcbPhones().getEditor().getItem().toString()));

        telephone.setTypePhone(clientFindByNameFormView.getTxtTypePhone().getText());

        client.getPhone().add(telephone);

        /*Edicion de la entidad StandarAddres para pasarle a la entidad Clients*/
        address.setStreetDirection(clientFindByNameFormView.getJcbStreetDirection().getEditor().getItem().toString());

        address.setStreetNumber(Integer.valueOf(clientFindByNameFormView.getTxtStreetNumber().getText()));

        address.setPostalCode(Integer.valueOf(clientFindByNameFormView.getTxtPostalCode().getText()));

        address.setCity(clientFindByNameFormView.getTxtCity().getText());

        address.setState(clientFindByNameFormView.getTxtState().getText());

        client.getAddress().add(address);

        return true;
    }

    private void editTelephone() {

        if (!clientFindByNameFormView.getJcbPhones().getEditor().getItem().toString().equals("")) {

            telephone = (Telephone) clientFindByNameFormView.getJcbPhones().getSelectedItem();

            clientFindByNameFormView.getTxtTypePhone().setText(telephone.getTypePhone());
        }
    }

    private void editAddress() {

        if (!clientFindByNameFormView.getJcbStreetDirection().getEditor().getItem().toString().equals("")) {

            address = (Address) clientFindByNameFormView.getJcbStreetDirection().getSelectedItem();

            clientFindByNameFormView.getTxtStreetNumber().setText(address.getStreetDirection());

            clientFindByNameFormView.getTxtPostalCode().setText(String.valueOf(address.getPostalCode()));

            clientFindByNameFormView.getTxtCity().setText(address.getCity());

            clientFindByNameFormView.getTxtState().setText(address.getState());
        }
    }

    /*Functions to manipulate UX*/
    private void getClientSelectedOfTable() {

        row = clientFindByNameFormView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();
    }

    private void setFormWithSelectedClient() {

        clientFindByNameFormView.getLblId().setText(String.valueOf(client.getId()));

        clientFindByNameFormView.getTxtName().setText(client.getName());

        clientFindByNameFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientFindByNameFormView.getTxtAge().setText(String.valueOf(client.getAge()));

        clientFindByNameFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindByNameFormView.getTxtClasification().setText(client.getClasification());

        setModelJcbPhones();

        setModelJcbAddress();

        

        clientFindByNameFormView.getTxtStreetNumber().setText(String.valueOf(address.getStreetNumber()));

        clientFindByNameFormView.getTxtPostalCode().setText(String.valueOf(address.getPostalCode()));

        clientFindByNameFormView.getTxtCity().setText(address.getCity());

        clientFindByNameFormView.getTxtState().setText(address.getState());

        clientFindByNameFormView.getJcbAvailability().setSelected(client.isAvailability());
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    private void clearForm() {

        clientFindByNameFormView.getLblId().setText("");

        clientFindByNameFormView.getTxtName().setText("");

        clientFindByNameFormView.getTxtLastname().setText("");

        clientFindByNameFormView.getTxtAge().setText("");

        clientFindByNameFormView.getTxtSsn().setText("");

        clientFindByNameFormView.getTxtClasification().setText("");

        clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

        clientFindByNameFormView.getTxtStreetNumber().setText("");

        clientFindByNameFormView.getTxtPostalCode().setText("");

        clientFindByNameFormView.getTxtCity().setText("");

        clientFindByNameFormView.getTxtState().setText("");

        clientFindByNameFormView.getJcbAvailability().setSelected(false);

        clientFindByNameFormView.getTxtTypePhone().setText("");

        clientFindByNameFormView.getJcbPhones().removeAllItems();

        clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

        clientFindByNameFormView.getTxtStreetNumber().setText("");

        clientFindByNameFormView.getTxtPostalCode().setText("");

        clientFindByNameFormView.getTxtCity().setText("");

        clientFindByNameFormView.getTxtState().setText("");

        clientFindByNameFormView.getJcbAvailability().setSelected(false);
    }
}
