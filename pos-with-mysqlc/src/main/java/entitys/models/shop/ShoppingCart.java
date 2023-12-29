package entitys.models.shop;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import interfaces.entitys.shoppingCart.IShoppingCart;
import java.util.ArrayList;

public class ShoppingCart implements IShoppingCart<Integer> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Client client;

    private ArrayList<SelectedProduct> products;
    
    private Double total;

    private static Integer countId = 0;


    public ShoppingCart(Client client, ArrayList<SelectedProduct> products, Double total) {

        countId++;

        this.id = countId;

        this.client = client;

        this.products = products;
        
        this.total = total;
    }

    @Override
    public Integer getId() {
       return id;
    }

    @Override
    public void setId(Integer id) {
       this.id = id;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public ArrayList<SelectedProduct> getProducts() {
        return products;
    }

    @Override
    public void setProducts(ArrayList<SelectedProduct> products) {
        this.products = products;
    }

    @Override
    public Double getFinalPrice() {
        return total;
    }

    @Override
    public void setFinalPrice(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", client=" + client + ", products=" + products + ", total=" + total + '}';
    }  
}
