package entitiys.person;

import entitiys.addres.Addres;
import entitiys.phone.Phone;
import interfaces.entitys.person.IPerson;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Person<K> implements IPerson<K> {

    private K id;
    private String name;
    private String lastName;
    private Integer age;
    private String ssn;
    private List<Addres> addres;
    private List<Phone> phone;
    
    @Override
    public K getId() {
        return id;
    }

    @Override
    public void setId(K id) {
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
    public String getSsn() {
        return ssn;
    }

    @Override
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Addres> getAddres() {
        return addres;
    }

    public void setAddres(List<Addres> addres) {
        this.addres = addres;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
