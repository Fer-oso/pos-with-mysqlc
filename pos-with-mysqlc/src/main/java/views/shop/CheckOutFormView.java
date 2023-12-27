package views.shop;

import controllers.Shop.checkoutformcontroller.CheckOutFormController;
import entitys.models.shop.ShoppingCart;
import interfaces.services.CheckOutService;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;


public class CheckOutFormView extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public CheckOutFormView(ShoppingCart shoppingCart, CheckOutService checkOutService) {

        initComponents();
        
        CheckOutFormController checkOutFormController = new CheckOutFormController(this, shoppingCart, checkOutService);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCheckOut = new javax.swing.JTable();
        lblDateValue = new javax.swing.JLabel();
        lblCheckOutNumberValue = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblSelectPaymentMethodText = new javax.swing.JLabel();
        lblCreditCardText = new javax.swing.JLabel();
        lblCashText = new javax.swing.JLabel();
        jrbCash = new javax.swing.JRadioButton();
        jrbCreditCard = new javax.swing.JRadioButton();
        jcbCuotes = new javax.swing.JComboBox<>();
        txtFinalPriceCc = new javax.swing.JTextField();
        txtCash = new javax.swing.JTextField();
        txtCreditCardQuantity = new javax.swing.JTextField();
        lblCheckOutNumberText = new javax.swing.JLabel();
        lblClientNameText = new javax.swing.JLabel();
        lblClientNameValue = new javax.swing.JLabel();
        lblTotalPriceText = new javax.swing.JLabel();
        lblTotalPriceValue = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCheckOut.setAutoCreateRowSorter(true);
        jTableCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Brand", "Quantity", "Price", "FinalPrice"
            }
        ));
        jTableCheckOut.setAutoscrolls(false);
        jTableCheckOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCheckOut.setGridColor(new java.awt.Color(255, 255, 255));
        jTableCheckOut.setShowGrid(true);
        jScrollPane1.setViewportView(jTableCheckOut);
        if (jTableCheckOut.getColumnModel().getColumnCount() > 0) {
            jTableCheckOut.getColumnModel().getColumn(0).setMinWidth(0);
            jTableCheckOut.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableCheckOut.getColumnModel().getColumn(1).setMaxWidth(400);
            jTableCheckOut.getColumnModel().getColumn(2).setMaxWidth(100);
            jTableCheckOut.getColumnModel().getColumn(3).setMaxWidth(50);
            jTableCheckOut.getColumnModel().getColumn(4).setMaxWidth(100);
            jTableCheckOut.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 200));

        lblDateValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDateValue.setText("Saturday 9/2/2023");
        jPanel1.add(lblDateValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        lblCheckOutNumberValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCheckOutNumberValue.setText("435232");
        jPanel1.add(lblCheckOutNumberValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 5, -1, -1));

        lblSelectPaymentMethodText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSelectPaymentMethodText.setText("SELECT PAYMENT METHOD");
        jPanel2.add(lblSelectPaymentMethodText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        lblCreditCardText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCreditCardText.setText("CREDIT CARD");
        jPanel2.add(lblCreditCardText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        lblCashText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCashText.setText("CASH");
        jPanel2.add(lblCashText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));
        jPanel2.add(jrbCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 40));
        jPanel2.add(jrbCreditCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 20, 30));

        jcbCuotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1  6%", "2  11%", "6  18%", "12 24%" }));
        jPanel2.add(jcbCuotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, 30));

        txtFinalPriceCc.setEditable(false);
        txtFinalPriceCc.setVisible(false);
        jPanel2.add(txtFinalPriceCc, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, 30));
        jPanel2.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, -1));

        txtCreditCardQuantity.setEditable(true);
        txtFinalPriceCc.setVisible(false);
        jPanel2.add(txtCreditCardQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 590, 150));

        lblCheckOutNumberText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCheckOutNumberText.setText("CHECKOUT N°: ");
        jPanel1.add(lblCheckOutNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        lblClientNameText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClientNameText.setText("Client name:");
        jPanel1.add(lblClientNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        lblClientNameValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblClientNameValue.setText("Fernando Osorio");
        jPanel1.add(lblClientNameValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        lblTotalPriceText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalPriceText.setText("Total price: $ ");
        jPanel1.add(lblTotalPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, -1));

        lblTotalPriceValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalPriceValue.setText("1500.00");
        jPanel1.add(lblTotalPriceValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        btnPay.setText("PAY");
        jPanel1.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOutFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCheckOut;
    private javax.swing.JComboBox<String> jcbCuotes;
    private javax.swing.JRadioButton jrbCash;
    private javax.swing.JRadioButton jrbCreditCard;
    private javax.swing.JLabel lblCashText;
    private javax.swing.JLabel lblCheckOutNumberText;
    private javax.swing.JLabel lblCheckOutNumberValue;
    private javax.swing.JLabel lblClientNameText;
    private javax.swing.JLabel lblClientNameValue;
    private javax.swing.JLabel lblCreditCardText;
    private javax.swing.JLabel lblDateValue;
    private javax.swing.JLabel lblSelectPaymentMethodText;
    private javax.swing.JLabel lblTotalPriceText;
    private javax.swing.JLabel lblTotalPriceValue;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtCreditCardQuantity;
    private javax.swing.JTextField txtFinalPriceCc;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnPay() {
        return btnPay;
    }

    public void setBtnPay(JButton btnPay) {
        this.btnPay = btnPay;
    }

    public JTable getjTableCheckOut() {
        return jTableCheckOut;
    }

    public void setjTableCheckOut(JTable jTableCheckOut) {
        this.jTableCheckOut = jTableCheckOut;
    }

    public JComboBox<String> getJcbCuotes() {
        return jcbCuotes;
    }

    public void setJcbCuotes(JComboBox<String> jcbCuotes) {
        this.jcbCuotes = jcbCuotes;
    }

    public JRadioButton getJrbCash() {
        return jrbCash;
    }

    public void setJrbCash(JRadioButton jrbCash) {
        this.jrbCash = jrbCash;
    }

    public JRadioButton getJrbCreditCard() {
        return jrbCreditCard;
    }

    public void setJrbCreditCard(JRadioButton jrbCreditCard) {
        this.jrbCreditCard = jrbCreditCard;
    }

    public JLabel getLblCashText() {
        return lblCashText;
    }

    public void setLblCashText(JLabel lblCashText) {
        this.lblCashText = lblCashText;
    }

    public JLabel getLblCheckOutNumber() {
        return lblCheckOutNumberValue;
    }

    public void setLblCheckOutNumber(JLabel lblCheckOutNumber) {
        this.lblCheckOutNumberValue = lblCheckOutNumber;
    }

    public JLabel getLblCheckOutNumberText() {
        return lblCheckOutNumberText;
    }

    public void setLblCheckOutNumberText(JLabel lblCheckOutNumberText) {
        this.lblCheckOutNumberText = lblCheckOutNumberText;
    }

    public JLabel getLblClientName() {
        return lblClientNameValue;
    }

    public void setLblClientName(JLabel lblClientName) {
        this.lblClientNameValue = lblClientName;
    }

    public JLabel getLblClientNameText() {
        return lblClientNameText;
    }

    public void setLblClientNameText(JLabel lblClientNameText) {
        this.lblClientNameText = lblClientNameText;
    }

    public JLabel getLblCreditCardText() {
        return lblCreditCardText;
    }

    public void setLblCreditCardText(JLabel lblCreditCardText) {
        this.lblCreditCardText = lblCreditCardText;
    }

    public JLabel getLblDate() {
        return lblDateValue;
    }

    public void setLblDate(JLabel lblDate) {
        this.lblDateValue = lblDate;
    }

    public JLabel getLblSelectPaymentMethodText() {
        return lblSelectPaymentMethodText;
    }

    public void setLblSelectPaymentMethodText(JLabel lblSelectPaymentMethodText) {
        this.lblSelectPaymentMethodText = lblSelectPaymentMethodText;
    }

    public JLabel getLblTotalPrice() {
        return lblTotalPriceValue;
    }

    public void setLblTotalPrice(JLabel lblTotalPrice) {
        this.lblTotalPriceValue = lblTotalPrice;
    }

    public JLabel getLblTotalPriceText() {
        return lblTotalPriceText;
    }

    public void setLblTotalPriceText(JLabel lblTotalPriceText) {
        this.lblTotalPriceText = lblTotalPriceText;
    }

    public JTextField getTxtCash() {
        return txtCash;
    }

    public void setTxtCash(JTextField txtCash) {
        this.txtCash = txtCash;
    }

    public JTextField getTxtFinalPriceCc() {
        return txtFinalPriceCc;
    }

    public void setTxtFinalPriceCc(JTextField txtFinalPriceCc) {
        this.txtFinalPriceCc = txtFinalPriceCc;
    }

    public javax.swing.JTextField getTxtCreditCardQuantity() {
        return txtCreditCardQuantity;
    }

    public void setTxtCreditCardQuantity(javax.swing.JTextField txtCreditCardQuantity) {
        this.txtCreditCardQuantity = txtCreditCardQuantity;
    }

 
}
