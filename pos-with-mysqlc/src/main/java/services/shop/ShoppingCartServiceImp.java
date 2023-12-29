package services.shop;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;

import interfaces.services.ShoppingCartService;
import java.util.ArrayList;
import java.util.Optional;

public class ShoppingCartServiceImp implements ShoppingCartService {

    private static final long serialVersionUID = 1L;

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart createShoppingCart(Client client, ArrayList<SelectedProduct> listSelectedProducts, Double total){
    
    return new ShoppingCart(client, listSelectedProducts, total);
    
    }

    @Override
    public Optional<ShoppingCart> save(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ShoppingCart> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
