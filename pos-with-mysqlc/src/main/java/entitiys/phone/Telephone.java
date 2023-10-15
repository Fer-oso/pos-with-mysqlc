package entitiys.phone;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import interfaces.entitys.phone.Phone;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Telephone implements Phone {

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
}