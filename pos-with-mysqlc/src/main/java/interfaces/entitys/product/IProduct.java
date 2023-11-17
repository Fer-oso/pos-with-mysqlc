package interfaces.entitys.product;

import interfaces.entitys.entity.Entity;

public interface IProduct extends Entity<Integer> {
    
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
}
