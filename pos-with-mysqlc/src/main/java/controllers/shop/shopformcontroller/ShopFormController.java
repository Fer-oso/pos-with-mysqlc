package controllers.Shop.shopformcontroller;

import entitys.models.client.Client;
import entitys.models.product.Product;
import entitys.models.product.SelectedProduct;
import interfaces.services.ClientService;
import interfaces.services.ProductService;
import interfaces.services.ShoppingCartService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import views.shop.ShopFormView;

public class ShopFormController extends MouseAdapter implements ActionListener {

    /*Services*/
    private final ProductService productServiceImp;

    private final ClientService clientServiceImp;

    private final ShoppingCartService shoppingCartServiceImp;

    /*Views*/
    private final ShopFormView shopFormView;
    
    /*Global variables*/
    
    private DefaultTableModel model = new DefaultTableModel();
    
    private final ArrayList<SelectedProduct> listSelectedProducts = new ArrayList<>();

    private Product product;

    private Client client;

    private SelectedProduct selectedProduct;

    private int productQuantityToSell;

    private int row;

    private Integer id;

    private Integer ssn;

    private Double total;

    //Constructors
    public ShopFormController(ShopFormView shopFormView, ProductService productServiceImp, ClientService clientServiceImp, ShoppingCartService shoppingCartServiceImp) {

        this.shopFormView = shopFormView;

        this.productServiceImp = productServiceImp;

        this.clientServiceImp = clientServiceImp;

        this.shoppingCartServiceImp = shoppingCartServiceImp;

        addACtionsListeners();
    }

    /*Actions Events*/
    private void addACtionsListeners() {

        shopFormView.getTxtProductCode().addActionListener(this);

        shopFormView.getTxtProductQuantityToSell().addActionListener(this);

        shopFormView.getBtnRemove().addActionListener(this);

        shopFormView.getTxtClientSsn().addActionListener(this);

        shopFormView.getBtnAddToShoppingCart().addActionListener(this);

        shopFormView.getjTableProducts().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shopFormView.getTxtProductCode()) {

            findProduct();
        }

        if (e.getSource() == shopFormView.getTxtProductQuantityToSell()) {

            checkQuantityLessStock();

            refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopFormView.getBtnRemove()) {

            removeProductToList(id);

            refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopFormView.getTxtClientSsn()) {

            findClient();
        }

        if (e.getSource() == shopFormView.getBtnAddToShoppingCart()) {

            addToShoppingCart();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == shopFormView.getjTableProducts()) {

            getProductSelectedOfTable();
        }
    }

    /*Function o business logic*/
    private void findProduct() {

        if (!"".equals(shopFormView.getTxtProductCode().getText())) {

            String productCode = shopFormView.getTxtProductCode().getText();

            product = productServiceImp.findByProductCode(productCode);

            System.out.println(product);

            if (product.getName() != null) {

                shopFormView.getTxtProductName().setText("" + product.getName());

                shopFormView.getTxtProductBrand().setText("" + product.getBrand());

                shopFormView.getTxtProductPrice().setText("" + product.getPrice());

                shopFormView.getTxtProductStock().setText("" + product.getStock());

                shopFormView.getTxtProductQuantityToSell().requestFocus();

            } else {

                shopFormView.getTxtProductName().setText("");

                shopFormView.getTxtProductBrand().setText("");

                shopFormView.getTxtProductPrice().setText("");

                shopFormView.getTxtProductStock().setText("");

                shopFormView.getTxtProductCode().requestFocus();

                shopFormView.getTxtProductQuantityToSell().setText("");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Insert product code");

            shopFormView.getTxtProductCode().requestFocus();

            shopFormView.getTxtProductQuantityToSell().setText("");
        }
    }

    private void checkQuantityLessStock() {

        int actualStock;

        if (!"".equals(shopFormView.getTxtProductQuantityToSell().getText())) {

            int productStock = Integer.parseInt(shopFormView.getTxtProductStock().getText());

            productQuantityToSell = Integer.parseInt(shopFormView.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantityToSell) { // si el producto se puede vender

                selectedProduct = createSelectedProduct(); // crea un producto seleccionado

                shopFormView.getTxtProductQuantityToSell().setText("");

                addProductToList(); // añade a la lista el producto seleccionado

                actualStock = (productStock - productQuantityToSell);

                shopFormView.getTxtProductStock().setText("" + actualStock);

            } else {

                JOptionPane.showMessageDialog(null, "Stock no disponible");
            }
            
        } else {

            JOptionPane.showMessageDialog(null, "Insert quantity ");

            shopFormView.getTxtProductQuantityToSell().requestFocus();

            shopFormView.getTxtProductQuantityToSell().setText("");
        }
    }

    private SelectedProduct createSelectedProduct() {

        id = product.getId();

        String productCode = product.getProductCode();

        String productName = product.getName();

        String productBrand = product.getBrand();

        double productPrice = product.getPrice();

        double finalPrice = productQuantityToSell * productPrice;

        return new SelectedProduct(id, productCode, productName, productBrand, productPrice, productQuantityToSell, finalPrice);
    }

    private void addProductToList() {

        boolean existDuplicate = false; //Flag to check duplicate existence

        if (listSelectedProducts.isEmpty()) { // if the list is empty 

            listSelectedProducts.add(selectedProduct); //add directly the product

            System.out.println("producto añadido por que estaba vacia" + listSelectedProducts);

        } else {

            for (SelectedProduct p : listSelectedProducts) {

                if (p.getProductCode().equals(selectedProduct.getProductCode())) {

                    JOptionPane.showMessageDialog(null, "producto ya esta en la lista");

                    p.setProductQuantity(p.getProductQuantity() + productQuantityToSell);

                    p.setFinalPrice(p.getProductQuantity() * selectedProduct.getProductPrice());

                    existDuplicate = true; // change the value to true  if the product exist

                    break;
                }
            }

            if (!existDuplicate) {

                listSelectedProducts.add(selectedProduct);
            }
        }
    }

    private void listProductsCarshop() {

        model = (DefaultTableModel) shopFormView.getjTableProducts().getModel();

        for (SelectedProduct sp : listSelectedProducts) {

            Object[] objectProduct = {sp.getProductCode(), sp.getProductName(), sp.getProductBrand(),
                sp.getProductQuantity(), sp.getProductPrice(), sp.getFinalPrice()};

            model.addRow(objectProduct);
        }

        shopFormView.getjTableProducts().setModel(model);

        calculateFinalPrice();
    }

    private void calculateFinalPrice() {

        total = 0.0;

        double finalPrice;

        for (var sp : listSelectedProducts) {

            finalPrice = sp.getFinalPrice() * 1.21;

            total += finalPrice;

            shopFormView.getLblTotal().setText("" + total);

            System.out.println(finalPrice);

            System.out.println(total);
        }
    }

    private void getProductSelectedOfTable() {

        row = shopFormView.getjTableProducts().getSelectedRow();

        selectedProduct = listSelectedProducts.get(row);

        id = selectedProduct.getId();

        System.out.println(id);
    }

    private void refreshTable(DefaultTableModel modelo) {

        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);

            i = i - 1;
        }
    }

    private void removeProductToList(Integer id) {

        Iterator<SelectedProduct> iteratorList = listSelectedProducts.iterator();

        while (iteratorList.hasNext()) {

            selectedProduct = iteratorList.next();

            if (selectedProduct.getId().equals(id)) {

                System.out.println("" + selectedProduct);

                iteratorList.remove();
                
                shopFormView.getLblTotal().setText("" + (total - selectedProduct.getFinalPrice()*1.21));

                break;
            }
        }

        System.out.println(listSelectedProducts);
    }

    private void findClient() {

        if (!"".equals(shopFormView.getTxtClientSsn().getText())) {

            ssn = Integer.valueOf(shopFormView.getTxtClientSsn().getText());

            client = clientServiceImp.findById(id);

            if (client.getName() != null) {

                shopFormView.getTxtClientName().setText("" + client.getName());

            } else {

                JOptionPane.showMessageDialog(null, "Client not found");

                shopFormView.getTxtClientSsn().setText("");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Ssn required");
        }
    }

    private void addToShoppingCart() {

        if (client == null || shopFormView.getTxtClientName().getText().equals("") || shopFormView.getTxtClientSsn().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "client required");

            return;
        }
        
        if (shopFormView.getjTableProducts().getRowCount() == 0) {
            
            JOptionPane.showMessageDialog(null, "Need add products");

            return;
        }

      //  ShoppingCart shoppingCart = shoppingCartServiceImp.createShoppingCart(client, listSelectedProducts, total);

       // ShoppingCartFormView shoppingCartFormView = new ShoppingCartFormView(shoppingCart, shoppingCartServiceImp);

     //   shoppingCartFormView.setVisible(true);
    }
}
