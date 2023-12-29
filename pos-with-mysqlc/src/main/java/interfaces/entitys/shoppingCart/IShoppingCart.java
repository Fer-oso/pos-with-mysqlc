package interfaces.entitys.shoppingCart;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import interfaces.entitys.entity.Entity;
import java.util.ArrayList;

public interface IShoppingCart<ID> extends Entity<ID> {

    public Client getClient();

    public void setClient(Client client);

    public ArrayList<SelectedProduct> getProducts();

    public void setProducts(ArrayList<SelectedProduct> products);

    public Double getFinalPrice();

    public void setFinalPrice(Double total);

}
