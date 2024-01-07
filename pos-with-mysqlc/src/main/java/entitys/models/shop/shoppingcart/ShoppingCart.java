package entitys.models.shop.shoppingcart;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import interfaces.entitys.shoppingCart.IShoppingCart;
import java.util.ArrayList;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public class ShoppingCart implements IShoppingCart<Integer> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Client client;

    private ArrayList<SelectedProduct> products;
    
    private Double finalPrice;

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
        return finalPrice;
    }

    @Override
    public void setFinalPrice(Double total) {
        this.finalPrice = total;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", client=" + client + ", products=" + products + ", finalPrice=" + finalPrice + '}';
    }  
}
