package entitiys.models.phone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import interfaces.entitys.phone.Phone;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Telephone implements Phone,Serializable {

    private static final long serialVersionUID = 1L;

    Integer id;
    
    Integer numberPhone;
    
    String typePhone;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public Integer getNumberPhone() {
        return numberPhone;
    }

    @Override
    public void setNumberPhone(Integer numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String getTypePhone() {
        return typePhone;
    }

    @Override
    public void setTypePhone(String typePhone) {
        this.typePhone = typePhone;
    } 

    @Override
    public String toString() {
        return String.valueOf(getNumberPhone());
    }
}