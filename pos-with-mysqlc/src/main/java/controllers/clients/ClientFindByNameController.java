package controllers.clients;

import interfaces.entitys.clients.Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.table.DefaultTableModel;


import views.clients.ClientFindByNameFormView;
import interfaces.services.StandardClientService;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientFindByNameFormView clientFindByNameFormView;

    private final StandardClientService clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;
    private int row;
    private int id;
    private Client client;

    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameFormView clientFindByNameFormView, StandardClientService clientServiceImp) {

        this.clientFindByNameFormView = clientFindByNameFormView;

        this.clientServiceImp = clientServiceImp;

      //  addActionsListeners();
    }
    
//    /*Actions*/
   private void addActionsListeners() {
//
//        clientFindByNameFormView.getJtTableClients().addMouseListener(this);
//
//        clientFindByNameFormView.getBtnSearch().addActionListener(this);
//
//        clientFindByNameFormView.getBtnEdit().addActionListener(this);
//
//        clientFindByNameFormView.getBtnDelete().addActionListener(this);
//
//        clientFindByNameFormView.getBtnCancel().addActionListener(this);
    }
//
//    @Override
    public void actionPerformed(ActionEvent e){
//
//        if (e.getSource() == clientFindByNameFormView.getBtnSearch()) {
//
//            if (searchButton()) {
//
//                refreshTable();
//                
//                try {
//                    listClients = findAllByName();
//                } catch (Exception ex) {
//                    Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                listClients();
//
//                System.out.println(listClients);
//                
//                return;
//            }
//
//            System.out.println(listClients);
//        }
//
//        if (e.getSource() == clientFindByNameFormView.getBtnEdit()) {
//
//            if (setClientwithDataOfForm()) {
//
//                editClient();
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
//        if (e.getSource() == clientFindByNameFormView.getBtnDelete()) {
//
//            deleteClient();
//
//            refreshTable();
//
//            listClients();
//
//            System.out.println(listClients);
//        }
//
//        if (e.getSource() == clientFindByNameFormView.getBtnCancel()) {
//
//            clearForm();
//            
//            refreshTable();
//            
//            try {
//                listClients = clientServiceImp.findAll();
//            } catch (Exception ex) {
//                Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            listClients();
//        }
   }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//        if (e.getSource() == clientFindByNameFormView.getJtTableClients()) {
//
//            getClientSelectedOfTable();
//
//            setFormWithSelectedClient();
//        }
//    }
//
//    /*Functions*/
//    public void listClients() {
//        
//        this.listClients = clientServiceImp.findAll();
//
//        model = (DefaultTableModel) clientFindByNameFormView.getJtTableClients().getModel();
//        
//        for (Client cl : listClients) {
//
//            Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
//                cl.isAvailability(), cl.getSsn(), cl.getPhoneNumber()};
//
//            model.addRow(clientObject);
//        }
//
//        this.clientFindByNameFormView.getJtTableClients().setModel(model);
//    }
//
//    private List<NormalClient> findAllByName() throws Exception{
//
//        String clientName = clientFindByNameFormView.getTxtSearch().getText();
//
//        return clientServiceImp.findAllByName(clientName);
//    }
//
//    private NormalClient editClient() {
//
//        return clientServiceImp.update(row, client);
//    }
//
//    private void deleteClient() {
//
//        clientServiceImp.delete(id);
//    }
//    
//    private boolean searchButton() {
//
//        if (clientFindByNameFormView.getTxtSearch().getText().equals("")) {
//
//            JOptionPane.showMessageDialog(null, "Input search value");
//
//            return false;
//        }
//
//        return true;
//    }
//
//    private void getClientSelectedOfTable() {
//
//        row = clientFindByNameFormView.getJtTableClients().getSelectedRow();
//
//        client = listClients.get(row);
//
//        id = client.getId();
//    }
//
//    private boolean setClientwithDataOfForm() {
//
//        if (clientFindByNameFormView.getTxtName().getText().equals("") || clientFindByNameFormView.getTxtLastname().getText().equals("")
//                || clientFindByNameFormView.getTxtAge().getText().equals("") || clientFindByNameFormView.getTxtSsn().getText().equals("") || clientFindByNameFormView.getTxtPhone().getText().equals("")) {
//
//           JOptionPane.showMessageDialog(null, "All fields required");
//
//            return false;
//        }
//
//        client.setName(clientFindByNameFormView.getTxtName().getText());
//
//        client.setLastName(clientFindByNameFormView.getTxtLastname().getText());
//
//        client.setAge(Integer.valueOf(clientFindByNameFormView.getTxtAge().getText()));
//
//        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());
//
//        client.setSsn(Integer.valueOf(clientFindByNameFormView.getTxtSsn().getText()));
//
//        client.setPhoneNumber(clientFindByNameFormView.getTxtPhone().getText());
//
//        return true;
//    }
//
//    private void setFormWithSelectedClient() {
//
//        clientFindByNameFormView.getLblId().setText(String.valueOf(client.getId()));
//
//        clientFindByNameFormView.getTxtName().setText(client.getName());
//
//        clientFindByNameFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));
//
//        clientFindByNameFormView.getTxtAge().setText(String.valueOf(client.getAge()));
//
//        checkAvailability();
//
//        clientFindByNameFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));
//
//        clientFindByNameFormView.getTxtPhone().setText(client.getPhoneNumber());
//
//    }
//
//    private void checkAvailability() {
//
//        if (client.isAvailability()) {
//
//            clientFindByNameFormView.getJcbAvailability().setSelected(true);
//
//        } else {
//
//            clientFindByNameFormView.getJcbAvailability().setSelected(false);
//
//        }
//    }
//
//    public void refreshTable() {
//
//        for (int i = 0; i < model.getRowCount(); i++) {
//
//            model.removeRow(i);
//
//            i = i - 1;
//        }
//    }
//
//    private void clearForm() {
//
//        clientFindByNameFormView.getLblId().setText("");
//
//        clientFindByNameFormView.getTxtName().setText("");
//
//        clientFindByNameFormView.getTxtLastname().setText("");
//
//        clientFindByNameFormView.getTxtAge().setText("");
//
//        clientFindByNameFormView.getJcbAvailability().setSelected(false);
//
//        clientFindByNameFormView.getTxtSsn().setText("");
//
//        clientFindByNameFormView.getTxtPhone().setText("");
//    }

}
