package services.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import entitys.models.shop.ShoppingCart;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;

import interfaces.services.ShoppingCartService;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.SneakyThrows;

public class ShoppingCartServiceImp implements ShoppingCartService {

    private static final long serialVersionUID = 1L;

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImp(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    @SneakyThrows
    public Optional<ShoppingCart> save(ShoppingCart shoppingCart) {

        try {

            shoppingCart = shoppingCartRepository.save(shoppingCart).orElse(null);

            new ObjectMapper().writeValue(new File("shopping-cart-created.json"), shoppingCart);
            
        } catch (IOException ex) {

            Logger.getLogger(ShoppingCartServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return Optional.ofNullable(shoppingCart);
    }

    @Override
    @SneakyThrows
    public Optional<ShoppingCart> findById(Integer id) {
        return shoppingCartRepository.findById(id);
    }
}
