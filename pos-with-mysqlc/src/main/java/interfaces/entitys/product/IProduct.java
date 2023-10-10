package interfaces.entitys.product;

public interface IProduct {
    
    String getName();
    
    void setName(String name);
    
    Double getPrice();
    
    void setPrice(Double price);
    
    boolean isAvailabity();
    
    void setAvailability(boolean availability);
    
    Integer getStock();
    
    void setStock(Integer stock);
    
    String getBrand();
    
    void setBrand(String brand);
    
    String getProductCode();
    
    void setProductCode(String productCode);
    
    Integer getQuantity();
    
    void setQuantity(Integer quantity);
    
}
