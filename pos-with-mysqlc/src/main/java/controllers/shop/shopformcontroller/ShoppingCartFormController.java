package controllers.shop.shopformcontroller;

import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import interfaces.services.CheckOutService;
import interfaces.services.ShoppingCartService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.shop.CheckOutFormView;
import views.shop.ShoppingCartFormView;

public class ShoppingCartFormController extends MouseAdapter implements ActionListener {

    /*Views*/
    private final ShoppingCartFormView shoppingCartFormView;

    /*Entitys*/
    private ShoppingCart shoppingCart;

    /*Services*/
    ShoppingCartService shoppingCartService;

    CheckOutService checkOutService;

    /*Global variables*/
    private final ArrayList<SelectedProduct> listShoppingCartProducts;

    /*Constructors*/
    public ShoppingCartFormController(ShoppingCartFormView shoppingCartFormView, ShoppingCart shoppingCart, ShoppingCartService shoppingCartService) {

        this.shoppingCartFormView = shoppingCartFormView;

        this.shoppingCart = shoppingCart;

        this.shoppingCartService = shoppingCartService;

        addActionsListeners();

        listShoppingCartProducts = shoppingCart.getProducts();

        listProductsCarshop();
    }

    /*Actions Events*/
    private void addActionsListeners() {

        shoppingCartFormView.getBtnGenerateOrder().addActionListener(this);

        shoppingCartFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == shoppingCartFormView.getBtnCancel()) {

            shoppingCartFormView.setVisible(false);

            shoppingCartFormView.setDefaultCloseOperation(2);
        }

        if (e.getSource() == shoppingCartFormView.getBtnGenerateOrder()) {

            shoppingCart = shoppingCartService.save(shoppingCart).get();
            
            System.out.println("este es el findbyid "+ shoppingCartService.findById(shoppingCart.getId()));

            CheckOutFormView checkOutFormView = new CheckOutFormView(shoppingCart, checkOutService);

            shoppingCartFormView.setVisible(false);

            checkOutFormView.setVisible(true);
        }
    }

    /*Functions*/
    private void listProductsCarshop() {

        DefaultTableModel model = (DefaultTableModel) shoppingCartFormView.getjTableProducts().getModel();

        for (SelectedProduct sp : listShoppingCartProducts) {

            Object[] objectProduct = {sp.getProductCode(), sp.getProductName(), sp.getProductBrand(),
                sp.getProductQuantity(), sp.getProductPrice(), sp.getFinalPrice()};

            model.addRow(objectProduct);
        }

        shoppingCartFormView.getjTableProducts().setModel(model);

        shoppingCartFormView.getLblTotal().setText("" + shoppingCart.getFinalPrice());

        shoppingCartFormView.getTxtClientName().setText("" + shoppingCart.getClient().getName());

        shoppingCartFormView.getTxtClientSsn().setText("" + shoppingCart.getClient().getSsn());
    }
}
