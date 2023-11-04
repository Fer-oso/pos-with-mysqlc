package views;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import controllers.POSController;

public class POS extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    public POS() {

        initComponents();

        this.setLocationRelativeTo(this);

        POSController posController = new POSController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuShop = new javax.swing.JMenu();
        jMenuItemShopForm = new javax.swing.JMenuItem();
        jMenuShopCar = new javax.swing.JMenu();
        jMenuItemShopCarLast = new javax.swing.JMenuItem();
        jMenuItemShopCarHistory = new javax.swing.JMenuItem();
        jMenuClient = new javax.swing.JMenu();
        jMenuClientFind = new javax.swing.JMenu();
        jMenuItemClientByName = new javax.swing.JMenuItem();
        jMenuItemClientRegister = new javax.swing.JMenuItem();
        jMenuProduct = new javax.swing.JMenu();
        jMenuProductFind = new javax.swing.JMenu();
        jMenuItemProductByPC = new javax.swing.JMenuItem();
        jMenuItemProductRegister = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1057, 575));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -35, 1020, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuShop.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menushopicons\\shop icon.png")); // NOI18N
        jMenuShop.setText("Shop");

        jMenuItemShopForm.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menushopicons\\shopping cart form icon.png")); // NOI18N
        jMenuItemShopForm.setText("Shopping cart form");
        jMenuShop.add(jMenuItemShopForm);

        jMenuShopCar.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menushopicons\\shopping cart info icon.png")); // NOI18N
        jMenuShopCar.setText("Shopping cart info");

        jMenuItemShopCarLast.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menushopicons\\shopping cart last icon.png")); // NOI18N
        jMenuItemShopCarLast.setText("Last");
        jMenuShopCar.add(jMenuItemShopCarLast);

        jMenuItemShopCarHistory.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menushopicons\\shopping cart history icon.png")); // NOI18N
        jMenuItemShopCarHistory.setText("History");
        jMenuShopCar.add(jMenuItemShopCarHistory);

        jMenuShop.add(jMenuShopCar);

        jMenuBar1.add(jMenuShop);

        jMenuClient.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuclientsicons\\clients menu icon.png")); // NOI18N
        jMenuClient.setText("Client");

        jMenuClientFind.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuclientsicons\\find client icon.png")); // NOI18N
        jMenuClientFind.setText("Find");

        jMenuItemClientByName.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuproductsicons\\find all icon.png")); // NOI18N
        jMenuItemClientByName.setText("by name");
        jMenuClientFind.add(jMenuItemClientByName);

        jMenuClient.add(jMenuClientFind);

        jMenuItemClientRegister.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuclientsicons\\register client icon.png")); // NOI18N
        jMenuItemClientRegister.setText("Register");
        jMenuClient.add(jMenuItemClientRegister);

        jMenuBar1.add(jMenuClient);

        jMenuProduct.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuproductsicons\\menu product icon.png")); // NOI18N
        jMenuProduct.setText("Product");

        jMenuProductFind.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuproductsicons\\product find icon.png")); // NOI18N
        jMenuProductFind.setText("Find");

        jMenuItemProductByPC.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuproductsicons\\find all icon.png")); // NOI18N
        jMenuItemProductByPC.setText("by PC");
        jMenuProductFind.add(jMenuItemProductByPC);

        jMenuProduct.add(jMenuProductFind);

        jMenuItemProductRegister.setIcon(new javax.swing.ImageIcon("C:\\Users\\XFAO03\\Documents\\NetBeansProjects\\pos-with-mysqlc\\pos-with-mysqlc\\src\\main\\java\\img\\market icons\\menuproductsicons\\product register icon.png")); // NOI18N
        jMenuItemProductRegister.setText("Register");
        jMenuProduct.add(jMenuItemProductRegister);

        jMenuBar1.add(jMenuProduct);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new POS().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuClient;
    public javax.swing.JMenu jMenuClientFind;
    public javax.swing.JMenuItem jMenuItemClientByName;
    public javax.swing.JMenuItem jMenuItemClientRegister;
    public javax.swing.JMenuItem jMenuItemProductByPC;
    public javax.swing.JMenuItem jMenuItemProductRegister;
    public javax.swing.JMenuItem jMenuItemShopCarHistory;
    public javax.swing.JMenuItem jMenuItemShopCarLast;
    public javax.swing.JMenuItem jMenuItemShopForm;
    public javax.swing.JMenu jMenuProduct;
    public javax.swing.JMenu jMenuProductFind;
    public javax.swing.JMenu jMenuShop;
    public javax.swing.JMenu jMenuShopCar;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
