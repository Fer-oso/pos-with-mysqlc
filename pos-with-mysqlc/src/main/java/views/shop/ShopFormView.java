package views.shop;

import controllers.Shop.shopformcontroller.ShopFormController;
import interfaces.services.ClientService;
import interfaces.services.ProductService;
import interfaces.services.ShoppingCartService;
import javax.swing.JButton;
import javax.swing.JTextField;


public class ShopFormView extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public ShopFormView(ProductService productServiceImp, ClientService clientServiceImp, ShoppingCartService shoppingCartServiceImp) {
        
        initComponents();
        
        var shopFormController = new ShopFormController(this, productServiceImp, clientServiceImp, shoppingCartServiceImp);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNuevaVenta = new javax.swing.JPanel();
        jpTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpProductFind = new javax.swing.JPanel();
        lblProductCode = new javax.swing.JLabel();
        txtProductCode = new javax.swing.JTextField();
        lblProductName = new javax.swing.JLabel();
        lblProductBrand = new javax.swing.JLabel();
        txtProductBrand = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        lblProductStock = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        lblProductPrice = new javax.swing.JLabel();
        lblProductQuantity = new javax.swing.JLabel();
        txtProductQuantityToSell = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        txtProductName = new javax.swing.JTextField();
        btnFindProduct = new javax.swing.JButton();
        jpTableShoppingForm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblSsn = new javax.swing.JLabel();
        txtClientSsn = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        lblNameClient = new javax.swing.JLabel();
        btnAddToShoppingCart = new javax.swing.JButton();
        lblTotalPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnFindClient = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1020, 535));
        setMinimumSize(new java.awt.Dimension(1020, 535));
        setPreferredSize(new java.awt.Dimension(1020, 535));

        jpNuevaVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpNuevaVenta.setPreferredSize(new java.awt.Dimension(1034, 490));
        jpNuevaVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpTitle.setPreferredSize(new java.awt.Dimension(1020, 57));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel2.setText("Shopping System");

        javax.swing.GroupLayout jpTitleLayout = new javax.swing.GroupLayout(jpTitle);
        jpTitle.setLayout(jpTitleLayout);
        jpTitleLayout.setHorizontalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(231, 231, 231)
                .addComponent(jLabel2)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jpTitleLayout.setVerticalGroup(
            jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jpNuevaVenta.add(jpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        jpProductFind.setPreferredSize(new java.awt.Dimension(1020, 57));

        lblProductCode.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductCode.setText("Product Code");

        lblProductName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductName.setText("Name");

        lblProductBrand.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductBrand.setText("Brand");

        txtProductBrand.setEditable(false);
        txtProductBrand.setFocusable(false);

        txtProductStock.setEditable(false);
        txtProductStock.setFocusable(false);

        lblProductStock.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductStock.setText("Stock");

        txtProductPrice.setEditable(false);
        txtProductPrice.setFocusable(false);

        lblProductPrice.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductPrice.setText("Price");

        lblProductQuantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProductQuantity.setText("Quantity");

        btnRemove.setText("remove");
        btnRemove.setFocusable(false);

        txtProductName.setEditable(false);
        txtProductName.setFocusable(false);

        btnFindProduct.setText("find");
        btnFindProduct.setFocusable(false);

        javax.swing.GroupLayout jpProductFindLayout = new javax.swing.GroupLayout(jpProductFind);
        jpProductFind.setLayout(jpProductFindLayout);
        jpProductFindLayout.setHorizontalGroup(
            jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductFindLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductCode)
                    .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductFindLayout.createSequentialGroup()
                        .addComponent(lblProductBrand)
                        .addGap(88, 88, 88)
                        .addComponent(lblProductStock))
                    .addGroup(jpProductFindLayout.createSequentialGroup()
                        .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductPrice)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductFindLayout.createSequentialGroup()
                        .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addComponent(lblProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jpProductFindLayout.setVerticalGroup(
            jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductFindLayout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProductCode)
                        .addComponent(lblProductName)
                        .addComponent(lblProductBrand))
                    .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProductStock)
                        .addComponent(lblProductPrice)
                        .addComponent(lblProductQuantity)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductQuantityToSell, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductFindLayout.createSequentialGroup()
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jpProductFindLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jpNuevaVenta.add(jpProductFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 80));

        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product code", "Name", "Brand", "Quantity", "Price", "Final price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.setFocusable(false);
        jTableProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableProducts.setShowGrid(true);
        jScrollPane1.setViewportView(jTableProducts);

        javax.swing.GroupLayout jpTableShoppingFormLayout = new javax.swing.GroupLayout(jpTableShoppingForm);
        jpTableShoppingForm.setLayout(jpTableShoppingFormLayout);
        jpTableShoppingFormLayout.setHorizontalGroup(
            jpTableShoppingFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jpTableShoppingFormLayout.setVerticalGroup(
            jpTableShoppingFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTableShoppingFormLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpNuevaVenta.add(jpTableShoppingForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 900, 230));

        lblSsn.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSsn.setText("SSN");

        txtClientSsn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtClientName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblNameClient.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNameClient.setText("Name");

        btnAddToShoppingCart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddToShoppingCart.setText("add to cart");

        lblTotalPrice.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTotalPrice.setText("Total a pagar: $");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnFindClient.setText("find ");
        btnFindClient.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSsn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNameClient)
                        .addContainerGap(691, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindClient)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddToShoppingCart)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSsn)
                            .addComponent(lblNameClient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFindClient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotalPrice))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddToShoppingCart)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );

        jpNuevaVenta.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 900, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   public javax.swing.JLabel getLblNameClient() {
        return lblNameClient;
    }

    public void setLblNameClient(javax.swing.JLabel lblNameClient) {
        this.lblNameClient = lblNameClient;
    }

    public javax.swing.JLabel getLblProductBrand() {
        return lblProductBrand;
    }

    public void setLblProductBrand(javax.swing.JLabel lblProductBrand) {
        this.lblProductBrand = lblProductBrand;
    }

    public javax.swing.JLabel getLblProductCode() {
        return lblProductCode;
    }

    public void setLblProductCode(javax.swing.JLabel lblProductCode) {
        this.lblProductCode = lblProductCode;
    }

    public javax.swing.JLabel getLblProductPrice() {
        return lblProductPrice;
    }

    public void setLblProductPrice(javax.swing.JLabel lblProductPrice) {
        this.lblProductPrice = lblProductPrice;
    }

    public javax.swing.JLabel getLblProductQuantity() {
        return lblProductQuantity;
    }

    public void setLblProductQuantity(javax.swing.JLabel lblProductQuantity) {
        this.lblProductQuantity = lblProductQuantity;
    }

    public javax.swing.JLabel getLblProductStock() {
        return lblProductStock;
    }

    public void setLblProductStock(javax.swing.JLabel lblProductStock) {
        this.lblProductStock = lblProductStock;
    }

    public javax.swing.JLabel getLblSsn() {
        return lblSsn;
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

    public javax.swing.JTextField getTxtProductBrand() {
        return txtProductBrand;
    }

    public void setTxtProductBrand(javax.swing.JTextField txtProductBrand) {
        this.txtProductBrand = txtProductBrand;
    }

    public javax.swing.JTextField getTxtProductCode() {
        return txtProductCode;
    }

    public void setTxtProductCode(javax.swing.JTextField txtProductCode) {
        this.txtProductCode = txtProductCode;
    }

    public JButton getBtnFindClient() {
        return btnFindClient;
    }

    public void setBtnFindClient(JButton btnFindClient) {
        this.btnFindClient = btnFindClient;
    }

    public JButton getBtnFindProduct() {
        return btnFindProduct;
    }

    public void setBtnFindProduct(JButton btnFindProduct) {
        this.btnFindProduct = btnFindProduct;
    }

    public JTextField getTxtProductName() {
        return txtProductName;
    }

    public void setTxtProductName(JTextField txtProductName) {
        this.txtProductName = txtProductName;
    }

    public javax.swing.JTextField getTxtProductPrice() {
        return txtProductPrice;
    }

    public void setTxtProductPrice(javax.swing.JTextField txtProductPrice) {
        this.txtProductPrice = txtProductPrice;
    }

    public javax.swing.JTextField getTxtProductQuantityToSell() {
        return txtProductQuantityToSell;
    }

    public void setTxtProductQuantityToSell(javax.swing.JTextField txtProductQuantityToSell) {
        this.txtProductQuantityToSell = txtProductQuantityToSell;
    }

    public javax.swing.JTextField getTxtProductStock() {
        return txtProductStock;
    }

    public void setTxtProductStock(javax.swing.JTextField txtProductStock) {
        this.txtProductStock = txtProductStock;
    }

    public javax.swing.JLabel getLblProductName() {
        return lblProductName;
    }

    public void setLblProductName(javax.swing.JLabel lblProductName) {
        this.lblProductName = lblProductName;
    }

    public javax.swing.JTable getjTableProducts() {
        return jTableProducts;
    }

    public void setjTableProducts(javax.swing.JTable jTableProducts) {
        this.jTableProducts = jTableProducts;
    }

    public javax.swing.JButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(javax.swing.JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public javax.swing.JButton getBtnAddToShoppingCart() {
        return btnAddToShoppingCart;
    }

    public void setBtnAddToShoppingCart(javax.swing.JButton btnAddToShoppingCart) {
        this.btnAddToShoppingCart = btnAddToShoppingCart;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddToShoppingCart;
    private javax.swing.JButton btnFindClient;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProducts;
    public javax.swing.JPanel jpNuevaVenta;
    private javax.swing.JPanel jpProductFind;
    private javax.swing.JPanel jpTableShoppingForm;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblNameClient;
    public javax.swing.JLabel lblProductBrand;
    public javax.swing.JLabel lblProductCode;
    public javax.swing.JLabel lblProductName;
    public javax.swing.JLabel lblProductPrice;
    public javax.swing.JLabel lblProductQuantity;
    public javax.swing.JLabel lblProductStock;
    public javax.swing.JLabel lblSsn;
    public javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPrice;
    public javax.swing.JTextField txtClientName;
    public javax.swing.JTextField txtClientSsn;
    private javax.swing.JTextField txtProductBrand;
    private javax.swing.JTextField txtProductCode;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantityToSell;
    private javax.swing.JTextField txtProductStock;
    // End of variables declaration//GEN-END:variables
}
