package controllers.clients;

import entitiys.models.addres.StandardAddress;
import entitiys.dto.clientdto.StandardClient;
import entitiys.models.phone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import views.clients.ClientFindByNameFormView;
import interfaces.services.StandardClientService;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import interfaces.entitys.clients.IClient;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientFindByNameFormView clientFindByNameFormView;

    private final StandardClientService clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<StandardClient> listClients;
    private int row;
    private int id;
    private StandardClient client;
    private Telephone telephone;
    private StandardAddress address;


    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameFormView clientFindByNameFormView, StandardClientService clientServiceImp) {

        this.clientFindByNameFormView = clientFindByNameFormView;

        this.clientServiceImp = clientServiceImp;

        addActionsListeners();
    }

//    /*Actions*/
    private void addActionsListeners() {

        clientFindByNameFormView.getJtTableClients().addMouseListener(this);

        clientFindByNameFormView.getBtnSearch().addActionListener(this);

        clientFindByNameFormView.getBtnEdit().addActionListener(this);

        clientFindByNameFormView.getBtnDelete().addActionListener(this);

        clientFindByNameFormView.getBtnCancel().addActionListener(this);
    }
//

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByNameFormView.getBtnSearch()) {

            if (searchButton()) {

                try {
                    refreshTable();

                    listClients = findAllByName();

                    listClients();

                } catch (Exception ex) {

                    System.out.println(ex.getMessage());
                }

                System.out.println(listClients);

                return;
            }

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByNameFormView.getBtnEdit()) {

            try {
                if (setClientwithDataOfForm()) {

                 //   editClient();

                 //   clearForm();

                 //   refreshTable();

                 //   listClients();
                }
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

            System.out.println(listClients);
        }

        if (e.getSource() == clientFindByNameFormView.getBtnDelete()) {

            try {
                deleteClient();

                refreshTable();

                listClients();

                System.out.println(listClients);

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == clientFindByNameFormView.getBtnCancel()) {

            try {

                clearForm();

                refreshTable();

                listClients = clientServiceImp.findAll();

                listClients();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }
//

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
//    /*Functions*/

    public void listClients() throws Exception {

        try {
            this.listClients = clientServiceImp.findAll();
            System.out.println(listClients);

            model = (DefaultTableModel) clientFindByNameFormView.getJtTableClients().getModel();

            for (IClient cl : listClients) {

                Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                    cl.isAvailability(), cl.getSsn()};

                model.addRow(clientObject);
            }

            this.clientFindByNameFormView.getJtTableClients().setModel(model);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private List<StandardClient> findAllByName() throws Exception {

        String clientName = clientFindByNameFormView.getTxtSearch().getText();

        return clientServiceImp.findAllByName(clientName);
    }

    private StandardClient editClient() throws Exception {

        try {
            return clientServiceImp.update(row, client);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    private void deleteClient() throws Exception {

        try {
            clientServiceImp.delete(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    private boolean searchButton() {

        if (clientFindByNameFormView.getTxtSearch().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Input search value");

            return false;
        }

        return true;
    }

    private void getClientSelectedOfTable() {

        row = clientFindByNameFormView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();
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
        
        /*Edicion de la entidad Telephone para pasarlo a la entidad IClient*/
        
        telephone.setNumberPhone(Integer.valueOf(clientFindByNameFormView.getJcbPhones().getEditor().getItem().toString()));
        
        telephone.setTypePhone(clientFindByNameFormView.getTxtTypePhone().getText());
        
        client.setPhone(telephone);
        
        address.setStreetDirection(clientFindByNameFormView.getJcbStreetDirection().getEditor().getItem().toString());
        
        address.setStreetNumber(Integer.valueOf(clientFindByNameFormView.getTxtStreetNumber().getText()));
        
        address.setPostalCode(Integer.valueOf(clientFindByNameFormView.getTxtPostalCode().getText()));
        
        address.setCity(clientFindByNameFormView.getTxtCity().getText());
        
        address.setState(clientFindByNameFormView.getTxtState().getText());
        
        client.setAddress(address);
        
        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        return true;
    }

    private void setFormWithSelectedClient() throws Exception {

        clientFindByNameFormView.getLblId().setText(String.valueOf(client.getId()));

        clientFindByNameFormView.getTxtName().setText(client.getName());

        clientFindByNameFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientFindByNameFormView.getTxtAge().setText(String.valueOf(client.getAge()));

        clientFindByNameFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindByNameFormView.getTxtClasification().setText(client.getClasification());

        setModelJcbPhones();

        telephone = clientFindByNameFormView.getJcbPhones().getItemAt(clientFindByNameFormView.getJcbPhones().getSelectedIndex());

        clientFindByNameFormView.getTxtTypePhone().setText(telephone.getTypePhone());

        setModelJcbAddress();

        address = clientFindByNameFormView.getJcbStreetDirection().getItemAt(clientFindByNameFormView.getJcbStreetDirection().getSelectedIndex());

        clientFindByNameFormView.getTxtStreetNumber().setText(String.valueOf(address.getStreetNumber()));

        clientFindByNameFormView.getTxtPostalCode().setText(String.valueOf(address.getPostalCode()));

        clientFindByNameFormView.getTxtCity().setText(address.getCity());

        clientFindByNameFormView.getTxtState().setText(address.getState());

        checkAvailability();

    }

    private void setModelJcbPhones() throws Exception {

        ArrayList<Telephone> phoneList = new ArrayList<>();

        phoneList = clientServiceImp.getPhonesClients(client);

        clientFindByNameFormView.getJcbPhones().removeAllItems();

        clientFindByNameFormView.getJcbPhones().setEditable(true);

        for (Telephone telephone : phoneList) {

            clientFindByNameFormView.getJcbPhones().addItem(telephone);
        }
    }

    private void setModelJcbAddress() throws Exception {

        ArrayList<StandardAddress> addressList = new ArrayList<>();

        addressList = clientServiceImp.getAddressClients(client);

        clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

        clientFindByNameFormView.getJcbStreetDirection().setEditable(true);

        for (StandardAddress address : addressList) {

            clientFindByNameFormView.getJcbStreetDirection().addItem(address);
        }
    }

    private void checkAvailability() {

        if (client.isAvailability()) {

            clientFindByNameFormView.getJcbAvailability().setSelected(true);

        } else {

            clientFindByNameFormView.getJcbAvailability().setSelected(false);

        }
    }

    public void refreshTable() {

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

        clientFindByNameFormView.getJcbAvailability().setSelected(false);

        clientFindByNameFormView.getTxtSsn().setText("");

        clientFindByNameFormView.getJcbPhones().removeAllItems();
    }

}
