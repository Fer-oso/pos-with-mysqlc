package interfaces.entitys.person;

import interfaces.entitys.entity.Entity;
import java.util.ArrayList;
import interfaces.entitys.addres.Address;
import interfaces.entitys.phone.Phone;

public interface Person<K> extends Entity<K> {

    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    Integer getAge();

    void setAge(Integer age);

    String getSsn();

    void setSsn(String ssn);
    
    ArrayList<Address> getAddress();
    
    void setAddress(Address address);
    
    ArrayList<Phone> getPhone();
    
    void setPhone (Phone phone);
    
    boolean isAvailability();
    
    void setAvailability(boolean availability);
}
