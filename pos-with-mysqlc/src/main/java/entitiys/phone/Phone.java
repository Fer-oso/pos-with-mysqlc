package entitiys.phone;

import interfaces.entitys.phone.IPhone;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone implements IPhone{

    Integer numberPhone;
    
    Phone typePhone;

    @Override
    public Integer getNumberPhone() {
        return numberPhone;
    }

    @Override
    public void setNumberPhone(Integer numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public Phone getTypePhone() {
        return typePhone;
    }

    @Override
    public void setTypePhone(Phone typePhone) {
        this.typePhone = typePhone;
    }
}