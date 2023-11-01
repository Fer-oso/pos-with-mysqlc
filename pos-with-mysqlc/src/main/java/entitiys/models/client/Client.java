package entitiys.models.client;

import interfaces.entitys.addres.Address;
import interfaces.entitys.clients.IClient;
import interfaces.entitys.phone.Phone;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client implements IClient, Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String ssn;
    private ArrayList<Address> address;
    private ArrayList<Phone> phone;
    private String clasification;
    private boolean availability;

   @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getSsn() {
        return ssn;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String getClasification() {
        return clasification;
    }

    @Override
    public void setClasification(String clasification) {
        this.clasification = clasification;
    }

    @Override
    public ArrayList<Address> getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
      this.address.add(address);
    }

    @Override
    public ArrayList<Phone> getPhone() {
       return phone;
    }

    @Override
    public void setPhone(Phone phone) {
       this.phone.add(phone);
    }

    @Override
    public boolean isAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}