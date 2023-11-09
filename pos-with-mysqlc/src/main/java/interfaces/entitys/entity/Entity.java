package interfaces.entitys.entity;

import java.io.Serializable;

public interface Entity<ID> extends Serializable{
    
    ID getId();
    
    void setId(ID id);
}
