package entitys.models.client;

import interfaces.entitys.clients.IClient;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import interfaces.entitys.addres.IAddress;
import interfaces.entitys.phone.IPhone;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client implements IClient {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String ssn;
    private String clasification;
    private boolean availability;
    private ArrayList<IAddress> address = new ArrayList<>();
    private ArrayList<IPhone> phone = new ArrayList<>();

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
    public boolean isAvailability() {
        return availability;
    }

    @Override
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public ArrayList<IAddress> getAddress() {
        return address;
    }

    @Override
    public void setAddress(ArrayList<IAddress> address) {
        this.address = address;
    }

    @Override
    public ArrayList<IPhone> getPhone() {
        return phone;
    }

    @Override
    public void setPhone(ArrayList<IPhone> phone) {
        this.phone = phone;
    }
}
