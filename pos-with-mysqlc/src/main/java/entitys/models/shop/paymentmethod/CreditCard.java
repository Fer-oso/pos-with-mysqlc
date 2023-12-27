package entitys.models.shop.paymentmethod;

import interfaces.entitys.paymentMethod.PaymentMethod;

public class CreditCard implements PaymentMethod {

    private Integer id;
    
    private String name;
    
    private Integer SSN;
    
    private Integer quantity;
    
    private String cardNumber;
    
    private Integer secretCode;
    
    private static Integer countId = 0;

    public CreditCard() {

        countId++;

        this.id = countId;
    }

    public CreditCard(String name, Integer SSN, Integer quantity, String cardNumber, Integer secretCode) {

        countId++;

        this.id = countId;

        this.name = name;

        this.SSN = SSN;

        this.quantity = quantity;

        this.cardNumber = cardNumber;

        this.secretCode = secretCode;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSSN() {
        return SSN;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(Integer secretCode) {
        this.secretCode = secretCode;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "id=" + id + ", name=" + name + ", SSN=" + SSN + ", quantity=" + quantity + ", cardNumber=" + cardNumber + ", secretCode=" + secretCode + '}';
    }

}
