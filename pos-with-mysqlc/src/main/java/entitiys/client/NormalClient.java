package entitiys.client;

import entitiys.addres.Addres;
import entitiys.person.Person;
import entitiys.phone.Phone;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.ToString;
import interfaces.entitys.clients.Client;

@NoArgsConstructor
@ToString(callSuper = true)
public class NormalClient extends Person<Integer> implements Client {

    private String clasification;

    public NormalClient(Integer id, String name, String lastName, Integer age, String ssn, List<Addres> addres, List<Phone> phone, String clasification) {
        super(id, name, lastName, age, ssn, addres, phone);
        this.clasification = clasification;
    }

    @Override
    public String getClasification() {
        return clasification;
    }

    @Override
    public void setClasification(String clasification) {
        this.clasification = clasification;
    } 
}
