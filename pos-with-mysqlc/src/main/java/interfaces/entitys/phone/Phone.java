package interfaces.entitys.phone;

import interfaces.entitys.entity.Entity;

public interface Phone extends Entity<Integer>{
    
    Integer getNumberPhone();
    
    void setNumberPhone(Integer numberPhone);
    
    String getTypePhone();
    
    void setTypePhone(String phone);
    
}
