package controllers.products;

import entitys.models.product.Product;
import interfaces.services.ProductService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.SneakyThrows;
import views.products.ProductFindByPcFormView;

public class ProductFindByPcController extends MouseAdapter implements ActionListener,Serializable {

    private static final long serialVersionUID = 1L;

    private final ProductFindByPcFormView productFindByPcFormView;

    private final ProductService productServiceImp;

    private DefaultTableModel model = new DefaultTableModel();

    private ArrayList<Product> listProducts;
    private int row;
    private int id;
    private Product product;

    /*Constructors*/
    public ProductFindByPcController(ProductFindByPcFormView productFindByPcFormView, ProductService productServiceImp) {

        this.productFindByPcFormView = productFindByPcFormView;

        this.productServiceImp = productServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        this.productFindByPcFormView.getJtTableProducts().addMouseListener(this);

        this.productFindByPcFormView.getBtnSearch().addActionListener(this);

        this.productFindByPcFormView.getBtnEdit().addActionListener(this);

        this.productFindByPcFormView.getBtnDelete().addActionListener(this);

        this.productFindByPcFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productFindByPcFormView.getBtnSearch()) {

            if (searchButton()) {

                refreshTable();

                listProducts = findByPc();

                listProducts();

                System.out.println(listProducts);
            }

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcFormView.getBtnEdit()) {
            
            if (setProductWithDataOfForm()) {

                try {
                    editProduct();
                } catch (Exception ex) {
                    Logger.getLogger(ProductFindByPcController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                clearForm();

                refreshTable();

                listProducts();
            }

            System.out.println(listProducts);
        }

        if (e.getSource() == productFindByPcFormView.getBtnDelete()) {

            deleteProduct();

            refreshTable();

            listProducts();

            System.out.println(listProducts);
        }
      
        if (e.getSource() == productFindByPcFormView.getBtnCancel()) {

            clearForm();

            refreshTable();

            try {
                listProducts = productServiceImp.findAll();
            } catch (Exception ex) {
                Logger.getLogger(ProductFindByPcController.class.getName()).log(Level.SEVERE, null, ex);
            }

            listProducts();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productFindByPcFormView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct(product);
        }
    }
@SneakyThrows
    public void listProducts() {
        
        listProducts = productServiceImp.findAll();

        model = (DefaultTableModel) this.productFindByPcFormView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(), pr.isAvailabity(),
                pr.getStock(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }
        
        this.productFindByPcFormView.getJtTableProducts().setModel(model);
    }
@SneakyThrows
    private Product editProduct() throws Exception{

        setProductWithDataOfForm();

        return productServiceImp.update(row, product);
    }
    
    
    @SneakyThrows
    private void deleteProduct() {

        productServiceImp.delete(id);
    }

    private ArrayList<Product> findByPc() {

        String productCode = this.productFindByPcFormView.getTxtSearch().getText();

      //  product = productServiceImp.findByPc(productCode).get();

        ArrayList<Product> listProductByName = new ArrayList<>();

        listProductByName.add(product);

        return listProductByName;
    }

    private void getProductSelectedOfTable() {

        row = this.productFindByPcFormView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);

        id = product.getId();
    }

    private boolean setProductWithDataOfForm() {

        if (productFindByPcFormView.getTxtName().getText().equals("") || productFindByPcFormView.getTxtPrice().getText().equals("")
                || productFindByPcFormView.getTxtStock().getText().equals("") || productFindByPcFormView.getTxtBrand().getText().equals("") || productFindByPcFormView.getTxtCode().getText().equals("")) {

           JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        product.setName(productFindByPcFormView.getTxtName().getText());

        product.setPrice(Double.valueOf(productFindByPcFormView.getTxtPrice().getText()));

        product.setStock(Integer.valueOf(productFindByPcFormView.getTxtStock().getText()));

        product.setAvailability(productFindByPcFormView.getJcbAvailability().isSelected());

        product.setBrand(productFindByPcFormView.getTxtBrand().getText());

        product.setProductCode(productFindByPcFormView.getTxtCode().getText());

        return true;
    }

    private void setFormWithSelectedProduct(Product product) {

        this.productFindByPcFormView.getLblId().setText(String.valueOf(product.getId()));

        this.productFindByPcFormView.getTxtName().setText(product.getName());

        this.productFindByPcFormView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productFindByPcFormView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        this.productFindByPcFormView.getTxtBrand().setText(product.getBrand());

        this.productFindByPcFormView.getTxtCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailabity()) {

            this.productFindByPcFormView.getJcbAvailability().setSelected(true);

        } else {

            this.productFindByPcFormView.getJcbAvailability().setSelected(false);
        }
    }

    public void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i = i - 1;
        }
    }

    public void clearForm() {

        this.productFindByPcFormView.getLblId().setText("");

        this.productFindByPcFormView.getTxtName().setText("");

        this.productFindByPcFormView.getTxtPrice().setText("");

        this.productFindByPcFormView.getTxtStock().setText("");

        this.productFindByPcFormView.getJcbAvailability().setSelected(false);

        this.productFindByPcFormView.getTxtBrand().setText("");

        this.productFindByPcFormView.getTxtCode().setText("");
    }

    private boolean searchButton() {

        if (productFindByPcFormView.getTxtSearch().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Input search value");

            return false;
        }

        return true;
    }

}
