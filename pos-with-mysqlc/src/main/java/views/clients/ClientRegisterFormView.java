package views.clients;

import controllers.clients.ClientRegisterFormController;
import javax.swing.JTextField;
import interfaces.services.TelephoneService;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import interfaces.services.AddressService;
import interfaces.services.ClientService;

public class ClientRegisterFormView extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public ClientRegisterFormView(ClientService clientService, AddressService addressService, TelephoneService phoneService) {

        initComponents();

        ClientRegisterFormController clientRegisterFormController = new ClientRegisterFormController(this, clientService, addressService, phoneService);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblTitleForm = new javax.swing.JLabel();
        lblIconForm = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblStreetDirection = new javax.swing.JLabel();
        txtStreetDirection = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        lblClasification = new javax.swing.JLabel();
        txtClasification = new javax.swing.JTextField();
        lblStreetNumber = new javax.swing.JLabel();
        txtStreetNumber = new javax.swing.JTextField();
        txtTypePhone = new javax.swing.JTextField();
        lblTypePhone = new javax.swing.JLabel();
        lblSsn = new javax.swing.JLabel();
        txtSsn = new javax.swing.JTextField();
        lblNumberPhone = new javax.swing.JLabel();
        txtNumberPhone = new javax.swing.JTextField();
        lblPostalCode = new javax.swing.JLabel();
        txtPostalCode = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        lblAvailability = new javax.swing.JLabel();
        jcbAvailability = new javax.swing.JCheckBox();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblNumberPhone2 = new javax.swing.JLabel();
        txtNumberPhone2 = new javax.swing.JTextField();
        lblTypePhone2 = new javax.swing.JLabel();
        txtTypePhone2 = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setMaximumSize(new java.awt.Dimension(1020, 535));
        setMinimumSize(new java.awt.Dimension(1020, 535));
        setPreferredSize(new java.awt.Dimension(1020, 535));

        jPanel3.setPreferredSize(new java.awt.Dimension(1017, 39));

        jPanel1.setFocusable(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(1020, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(1020, 80));

        lblTitleForm.setBackground(new java.awt.Color(255, 255, 255));
        lblTitleForm.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        lblTitleForm.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleForm.setText("Client register form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconForm)
                .addGap(293, 293, 293)
                .addComponent(lblTitleForm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleForm)
                    .addComponent(lblIconForm))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblName.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblName.setText(" Name");

        lblLastname.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblLastname.setText(" Lastname");

        lblAge.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAge.setText(" Age");

        lblStreetDirection.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblStreetDirection.setText("Street Direction");

        lblClasification.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblClasification.setText("Clasification");

        lblStreetNumber.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblStreetNumber.setText("Street Number");

        lblTypePhone.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblTypePhone.setText("Type phone");

        lblSsn.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSsn.setText("SSN");

        lblNumberPhone.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblNumberPhone.setText("Number Phone");

        lblPostalCode.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPostalCode.setText("Postal Code");

        lblCity.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblCity.setText("City");

        lblState.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblState.setText("State");

        lblAvailability.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblAvailability.setText(" Availability");

        jcbAvailability.setText("YES/NO");

        btnEdit.setText("Edit");

        btnDelete.setText("Delete");

        btnCancel.setText("Cancel");

        btnSave.setText("Save");

        lblId.setEnabled(false);

        lblNumberPhone2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblNumberPhone2.setText("Number Phone");

        lblTypePhone2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblTypePhone2.setText("Type phone");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStreetDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStreetDirection))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStreetNumber)
                            .addComponent(txtStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCity)
                            .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAge)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtAge)
                                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                    .addComponent(lblName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblClasification)
                                    .addComponent(txtClasification))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumberPhone)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblId)
                                        .addGap(160, 160, 160)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblAvailability)
                                        .addGap(46, 46, 46)
                                        .addComponent(jcbAvailability)
                                        .addGap(26, 26, 26)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSsn)
                                    .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTypePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTypePhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumberPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumberPhone2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTypePhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTypePhone2)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPostalCode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblState)
                                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLastname)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblSsn)
                                .addGap(6, 6, 6)
                                .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblNumberPhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumberPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblClasification, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtClasification, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblTypePhone)
                                .addGap(3, 3, 3)
                                .addComponent(txtTypePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblNumberPhone2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumberPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTypePhone2)
                        .addGap(3, 3, 3)
                        .addComponent(txtTypePhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStreetDirection)
                            .addComponent(lblStreetNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStreetDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStreetNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCity)
                        .addGap(6, 6, 6)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblPostalCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblState)
                        .addGap(6, 6, 6)
                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblId)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAvailability)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblAvailability)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete))
                        .addGap(36, 36, 36))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 194, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(JButton btnEdit) {
        this.btnEdit = btnEdit;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JCheckBox getJcbAvailability() {
        return jcbAvailability;
    }

    public void setJcbAvailability(JCheckBox jcbAvailability) {
        this.jcbAvailability = jcbAvailability;
    }

    public JLabel getLblAge() {
        return lblAge;
    }

    public void setLblAge(JLabel lblAge) {
        this.lblAge = lblAge;
    }

    public JLabel getLblAvailability() {
        return lblAvailability;
    }

    public void setLblAvailability(JLabel lblAvailability) {
        this.lblAvailability = lblAvailability;
    }

    public JLabel getLblCity() {
        return lblCity;
    }

    public void setLblCity(JLabel lblCity) {
        this.lblCity = lblCity;
    }

    public JLabel getLblClasification() {
        return lblClasification;
    }

    public void setLblClasification(JLabel lblClasification) {
        this.lblClasification = lblClasification;
    }

    public JLabel getLblIconForm() {
        return lblIconForm;
    }

    public void setLblIconForm(JLabel lblIconForm) {
        this.lblIconForm = lblIconForm;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblLastname() {
        return lblLastname;
    }

    public void setLblLastname(JLabel lblLastname) {
        this.lblLastname = lblLastname;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JLabel getLblNumberPhone() {
        return lblNumberPhone;
    }

    public void setLblNumberPhone(JLabel lblNumberPhone) {
        this.lblNumberPhone = lblNumberPhone;
    }

    public JLabel getLblNumberPhone2() {
        return lblNumberPhone2;
    }

    public void setLblNumberPhone2(JLabel lblNumberPhone2) {
        this.lblNumberPhone2 = lblNumberPhone2;
    }

    public JLabel getLblPostalCode() {
        return lblPostalCode;
    }

    public void setLblPostalCode(JLabel lblPostalCode) {
        this.lblPostalCode = lblPostalCode;
    }

    public JLabel getLblSsn() {
        return lblSsn;
    }

    public void setLblSsn(JLabel lblSsn) {
        this.lblSsn = lblSsn;
    }

    public JLabel getLblState() {
        return lblState;
    }

    public void setLblState(JLabel lblState) {
        this.lblState = lblState;
    }

    public JLabel getLblStreetDirection() {
        return lblStreetDirection;
    }

    public void setLblStreetDirection(JLabel lblStreetDirection) {
        this.lblStreetDirection = lblStreetDirection;
    }

    public JLabel getLblStreetNumber() {
        return lblStreetNumber;
    }

    public void setLblStreetNumber(JLabel lblStreetNumber) {
        this.lblStreetNumber = lblStreetNumber;
    }

    public JLabel getLblTitleForm() {
        return lblTitleForm;
    }

    public void setLblTitleForm(JLabel lblTitleForm) {
        this.lblTitleForm = lblTitleForm;
    }

    public JLabel getLblTypePhone() {
        return lblTypePhone;
    }

    public void setLblTypePhone(JLabel lblTypePhone) {
        this.lblTypePhone = lblTypePhone;
    }

    public JLabel getLblTypePhone2() {
        return lblTypePhone2;
    }

    public void setLblTypePhone2(JLabel lblTypePhone2) {
        this.lblTypePhone2 = lblTypePhone2;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(JTextField txtAge) {
        this.txtAge = txtAge;
    }

    public JTextField getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(JTextField txtCity) {
        this.txtCity = txtCity;
    }

    public JTextField getTxtClasification() {
        return txtClasification;
    }

    public void setTxtClasification(JTextField txtClasification) {
        this.txtClasification = txtClasification;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(JTextField txtLastName) {
        this.txtLastName = txtLastName;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtNumberPhone() {
        return txtNumberPhone;
    }

    public void setTxtNumberPhone(JTextField txtNumberPhone) {
        this.txtNumberPhone = txtNumberPhone;
    }

    public JTextField getTxtNumberPhone2() {
        return txtNumberPhone2;
    }

    public void setTxtNumberPhone2(JTextField txtNumberPhone2) {
        this.txtNumberPhone2 = txtNumberPhone2;
    }

    public JTextField getTxtPostalCode() {
        return txtPostalCode;
    }

    public void setTxtPostalCode(JTextField txtPostalCode) {
        this.txtPostalCode = txtPostalCode;
    }

    public JTextField getTxtSsn() {
        return txtSsn;
    }

    public void setTxtSsn(JTextField txtSsn) {
        this.txtSsn = txtSsn;
    }

    public JTextField getTxtState() {
        return txtState;
    }

    public void setTxtState(JTextField txtState) {
        this.txtState = txtState;
    }

    public JTextField getTxtStreetDirection() {
        return txtStreetDirection;
    }

    public void setTxtStreetDirection(JTextField txtStreetDirection) {
        this.txtStreetDirection = txtStreetDirection;
    }

    public JTextField getTxtStreetNumber() {
        return txtStreetNumber;
    }

    public void setTxtStreetNumber(JTextField txtStreetNumber) {
        this.txtStreetNumber = txtStreetNumber;
    }

    public JTextField getTxtTypePhone() {
        return txtTypePhone;
    }

    public void setTxtTypePhone(JTextField txtTypePhone) {
        this.txtTypePhone = txtTypePhone;
    }

    public JTextField getTxtTypePhone2() {
        return txtTypePhone2;
    }

    public void setTxtTypePhone2(JTextField txtTypePhone2) {
        this.txtTypePhone2 = txtTypePhone2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JCheckBox jcbAvailability;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblClasification;
    private javax.swing.JLabel lblIconForm;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberPhone;
    private javax.swing.JLabel lblNumberPhone2;
    private javax.swing.JLabel lblPostalCode;
    private javax.swing.JLabel lblSsn;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStreetDirection;
    private javax.swing.JLabel lblStreetNumber;
    private javax.swing.JLabel lblTitleForm;
    private javax.swing.JLabel lblTypePhone;
    private javax.swing.JLabel lblTypePhone2;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtClasification;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberPhone;
    private javax.swing.JTextField txtNumberPhone2;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtSsn;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtStreetDirection;
    private javax.swing.JTextField txtStreetNumber;
    private javax.swing.JTextField txtTypePhone;
    private javax.swing.JTextField txtTypePhone2;
    // End of variables declaration//GEN-END:variables
}
