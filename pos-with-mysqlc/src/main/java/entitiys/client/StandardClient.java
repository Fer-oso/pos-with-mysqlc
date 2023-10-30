package entitiys.client;

import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import interfaces.entitys.addres.Address;
import interfaces.entitys.clients.Client;
import interfaces.entitys.phone.Phone;

@NoArgsConstructor
@ToString
public class StandardClient implements Client, Serializable {

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

    public StandardClient(Integer id, String name, String lastName, Integer age, String ssn, ArrayList<Address> address, ArrayList<Phone> phone, String clasification, boolean availability) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.address = address;
        this.phone = phone;
        this.clasification = clasification;
        this.availability = availability;
    }

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
