package entitiys.addres;

import interfaces.entitys.addres.IAddress;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Addres implements IAddress{

    String streetDirection;

    Integer streetNumber;

    String city;

    String state;

    Integer postalCode;

    @Override
    public String getStreetDirection() {
        return streetDirection;
    }

    @Override
    public void setStreetDirection(String streetDirection) {
        this.streetDirection = streetDirection;
    }

    @Override
    public Integer getStreetNumber() {
        return streetNumber;
    }

    @Override
    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Integer getPostalCode() {
        return postalCode;
    }

    @Override
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
