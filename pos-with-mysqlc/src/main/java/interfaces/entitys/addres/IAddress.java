package interfaces.entitys.addres;

import interfaces.entitys.entity.Entity;

public interface IAddress extends Entity<Integer>{

    String getStreetDirection();
    
    void setStreetDirection(String streetDirection);
    
    Integer getStreetNumber();
    
    void setStreetNumber(Integer streetNumber);
    
    String getCity();
    
    void setCity(String city);
    
    String getState();
    
    void setState(String state);
    
    Integer getPostalCode();
    
    void setPostalCode(Integer postalCode);
}
