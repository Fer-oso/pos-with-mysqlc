package interfaces.services;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import interfaces.persistences.crud.Save;
import interfaces.persistences.repositorys.FindById;
import java.io.Serializable;
import java.util.ArrayList;

public interface IShoppingCartService<T extends ShoppingCart,ID> extends Save<T>,FindById<T, ID>, Serializable{

    ShoppingCart createShoppingCart(Client client, ArrayList<SelectedProduct> listSelectedProducts, Double total);
}
