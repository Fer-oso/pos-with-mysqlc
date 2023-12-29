package views.shop;

import controllers.shop.shopformcontroller.ShoppingCartFormController;
import entitys.models.shop.ShoppingCart;
import interfaces.services.ShoppingCartService;

public class ShoppingCartFormView extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

  
    public ShoppingCartFormView(ShoppingCart shoppingCart, ShoppingCartService shoppingCartService) {
        initComponents();
        ShoppingCartFormController shoppingCartFormController = new ShoppingCartFormController(this, shoppingCart, shoppingCartService );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevaVenta = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnGenerateOrder = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jpTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1020, 535));
        setResizable(false);

        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpNuevaVenta.setPreferredSize(new java.awt.Dimension(1034, 490));
        jpNuevaVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Cancel Order ");
        jpNuevaVenta.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 180, 50));

        lblSsn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblSsn.setText("SSN");
        jpNuevaVenta.add(lblSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        txtClientSsn.setEditable(false);
        txtClientSsn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtClientSsn.setFocusable(false);
        txtClientSsn.setOpaque(true);
        jpNuevaVenta.add(txtClientSsn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 30));

        txtClientName.setEditable(false);
        txtClientName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtClientName.setFocusable(false);
        txtClientName.setOpaque(true);
        jpNuevaVenta.add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 150, 30));

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblNameClient.setText("Name");
        jpNuevaVenta.add(lblNameClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        btnGenerateOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGenerateOrder.setText("Generate Order");
        jpNuevaVenta.add(btnGenerateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, 50));

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTotalPrice.setText("Total $");
        jpNuevaVenta.add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        lblTotal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTotal.setText("15000");
        jpNuevaVenta.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 170, 30));

        jpTitle.setPreferredSize(new java.awt.Dimension(1020, 57));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel2.setText("Shopping Cart");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(248, 248, 248)
                .addComponent(jLabel2)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpNuevaVenta.add(jpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        jTableProducts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product code", "Name", "Brand", "Quantity", "Price", "Final price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setFocusable(false);
        jTableProducts.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpNuevaVenta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1010, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpNuevaVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jpNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerateOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    public javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblNameClient;
    public javax.swing.JLabel lblSsn;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    public javax.swing.JTextField txtClientName;
    public javax.swing.JTextField txtClientSsn;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnGenerateOrder() {
        return btnGenerateOrder;
    }

    public void setBtnGenerateOrder(javax.swing.JButton btnGenerateOrder) {
        this.btnGenerateOrder = btnGenerateOrder;
    }

    public javax.swing.JTable getjTableProducts() {
        return jTableProducts;
    }

    public void setjTableProducts(javax.swing.JTable jTableProducts) {
        this.jTableProducts = jTableProducts;
    }

    public javax.swing.JLabel getLblNameClient() {
        return lblNameClient;
    }

    public void setLblNameClient(javax.swing.JLabel lblNameClient) {
        this.lblNameClient = lblNameClient;
    }

    public void setLblSsn(javax.swing.JLabel lblSsn) {
        this.lblSsn = lblSsn;
    }

    public javax.swing.JLabel getLblTotal() {
        return lblTotal;
    }

    public void setLblTotal(javax.swing.JLabel lblTotal) {
        this.lblTotal = lblTotal;
    }

    public javax.swing.JLabel getLblTotalPrice() {
        return lblTotalPrice;
    }

    public void setLblTotalPrice(javax.swing.JLabel lblTotalPrice) {
        this.lblTotalPrice = lblTotalPrice;
    }

    public javax.swing.JTextField getTxtClientName() {
        return txtClientName;
    }

    public void setTxtClientName(javax.swing.JTextField txtClientName) {
        this.txtClientName = txtClientName;
    }

    public javax.swing.JTextField getTxtClientSsn() {
        return txtClientSsn;
    }

    public void setTxtClientSsn(javax.swing.JTextField txtClientSsn) {
        this.txtClientSsn = txtClientSsn;
    }

    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

   
}
