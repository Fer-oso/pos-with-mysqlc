package entitys.models.shop.checkout;

import entitys.models.shop.shoppingcart.ShoppingCart;
import entitys.models.shop.paymentmethod.Cash;
import entitys.models.shop.paymentmethod.CreditCard;
import interfaces.entitys.checkout.ICheckOut;
import interfaces.entitys.paymentMethod.PaymentMethod;
import java.util.ArrayList;
import java.util.Random;

public class CheckOut implements ICheckOut<Integer> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private ShoppingCart shoppingCart;

    private final ArrayList<PaymentMethod> paymentMethods = new ArrayList<>(2);

    private boolean state;

    public CheckOut() {

        this.id = new Random().nextInt(100);

        this.paymentMethods.add(new Cash());

        this.paymentMethods.add(new CreditCard());
    }

    public CheckOut(ShoppingCart shoppingCart) {

        this.id = new Random().nextInt(100);

        this.shoppingCart = shoppingCart;

        this.paymentMethods.add(new Cash());

        this.paymentMethods.add(new CreditCard());
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList<PaymentMethod> getPaymentMethod() {
        return paymentMethods;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Checking{" + "id=" + id + ", shoppingCart=" + shoppingCart + ", paymentMethod=" + paymentMethods + ", state=" + state + '}';
    }
}
