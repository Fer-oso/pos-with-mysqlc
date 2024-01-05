package controllers.Shop.shopformcontroller;

import controllers.utils.RefreshTable;
import entitys.models.client.Client;
import entitys.models.product.Product;
import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import interfaces.services.ClientService;
import interfaces.services.ProductService;
import interfaces.services.ShoppingCartService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import views.shop.ShopFormView;
import views.shop.ShoppingCartFormView;

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

    private Double total;

    //Constructors
    public ShopFormController(ShopFormView shopFormView, ProductService productService, ClientService clientService, ShoppingCartService shoppingCartService) {

        this.shopFormView = shopFormView;

        this.productServiceImp = productService;

        this.clientServiceImp = clientService;

        this.shoppingCartServiceImp = shoppingCartService;

        addACtionsListeners();
    }

    /*Actions Events*/
    private void addACtionsListeners() {

        shopFormView.getTxtProductCode().addActionListener(this);

        shopFormView.getBtnFindProduct().addActionListener(this);

        shopFormView.getTxtProductQuantityToSell().addActionListener(this);

        shopFormView.getBtnRemove().addActionListener(this);

        shopFormView.getTxtClientSsn().addActionListener(this);

        shopFormView.getBtnFindClient().addActionListener(this);

        shopFormView.getBtnAddToShoppingCart().addActionListener(this);

        shopFormView.getjTableProducts().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shopFormView.getTxtProductCode() || (e.getSource() == shopFormView.getBtnFindProduct())) {

            findProduct();
        }

        if (e.getSource() == shopFormView.getTxtProductQuantityToSell()) {

            checkQuantityLessStock();

            RefreshTable.refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopFormView.getBtnRemove()) {

            removeProductToList();

            RefreshTable.refreshTable(model);

            listProductsCarshop();
        }

        if (e.getSource() == shopFormView.getTxtClientSsn() || e.getSource() == shopFormView.getBtnFindClient()) {

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

            product = productServiceImp.findByProductCode(shopFormView.getTxtProductCode().getText());

            if (product != null) {

                shopFormView.getTxtProductName().setText("" + product.getName());

                shopFormView.getTxtProductBrand().setText("" + product.getBrand());

                shopFormView.getTxtProductPrice().setText("" + product.getPrice());

                shopFormView.getTxtProductStock().setText("" + product.getStock());

                shopFormView.getTxtProductQuantityToSell().requestFocus();

            } else {

                JOptionPane.showMessageDialog(null, "Cant find with that product code, try again");

                shopFormView.getTxtProductCode().requestFocus();

                shopFormView.getTxtProductName().setText("");

                shopFormView.getTxtProductBrand().setText("");

                shopFormView.getTxtProductStock().setText("");

                shopFormView.getTxtProductPrice().setText("");

                shopFormView.getTxtProductQuantityToSell().setText("");
            }

        } else {

            JOptionPane.showMessageDialog(null, "Insert product code");

            shopFormView.getTxtProductCode().requestFocus();

            shopFormView.getTxtProductQuantityToSell().setText("");
        }
    }

    private void checkQuantityLessStock() {

        if (!"".equals(shopFormView.getTxtProductQuantityToSell().getText())) {

            int productStock = Integer.parseInt(shopFormView.getTxtProductStock().getText());

            productQuantityToSell = Integer.parseInt(shopFormView.getTxtProductQuantityToSell().getText());

            if (productStock >= productQuantityToSell) { // si el producto se puede vender

                selectedProduct = createSelectedProduct(); // crea un producto seleccionado

                shopFormView.getTxtProductQuantityToSell().setText("");

                addProductToList(); // añade a la lista el producto seleccionado

                int actualStock = (productStock - productQuantityToSell);

                shopFormView.getTxtProductStock().setText(String.valueOf(actualStock));

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

        String productCode = shopFormView.getTxtProductCode().getText();

        String productName = shopFormView.getTxtProductName().getText();

        String productBrand = shopFormView.getTxtProductBrand().getText();

        double productPrice = Double.parseDouble(shopFormView.getTxtProductPrice().getText());

        double finalPrice = productQuantityToSell * productPrice;

        return new SelectedProduct(productCode, productName, productBrand, productPrice, productQuantityToSell, finalPrice);
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

            shopFormView.getLblTotal().setText(String.valueOf(total));
        }
    }

    private void getProductSelectedOfTable() {

        row = shopFormView.getjTableProducts().getSelectedRow();

        selectedProduct = listSelectedProducts.get(row);
    }

    private void addProductToList() {

        boolean existDuplicate = false; //Flag to check duplicate existence

        if (listSelectedProducts.isEmpty()) { // if the list is empty 

            listSelectedProducts.add(selectedProduct); //add directly the product

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

    private void removeProductToList() {

        Iterator<SelectedProduct> iteratorList = listSelectedProducts.iterator();

        while (iteratorList.hasNext()) {

            if (iteratorList.next().getProductCode().equals(selectedProduct.getProductCode())) {

                shopFormView.getTxtProductStock().setText(String.valueOf(product.getStock()));

                iteratorList.remove();

                shopFormView.getLblTotal().setText("" + (total - selectedProduct.getFinalPrice() * 1.21));

                break;
            }
        }
    }

    private void findClient() {

        if (!"".equals(shopFormView.getTxtClientSsn().getText())) {

            String ssn = shopFormView.getTxtClientSsn().getText();

            client = clientServiceImp.findBySsn(ssn).orElse(null);

            if (client != null) {

                shopFormView.getTxtClientName().setText(client.getName() + " " + client.getLastName());

            } else {

                JOptionPane.showMessageDialog(null, "Client not found, try again");

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
        }

        ShoppingCart shoppingCart = ShoppingCart.builder().id(new Random().nextInt(1000)).client(client).products(listSelectedProducts).finalPrice(total).build();

        ShoppingCartFormView shoppingCartFormView = new ShoppingCartFormView(shoppingCart, shoppingCartServiceImp);

        shoppingCartFormView.setVisible(true);
    }
}
