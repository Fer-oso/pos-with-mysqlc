package interfaces.entitys.person;

import interfaces.entitys.entity.Entity;
import java.util.ArrayList;
import interfaces.entitys.addres.IAddress;
import interfaces.entitys.phone.IPhone;

public interface Person<K> extends Entity<K> {

    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    Integer getAge();

    void setAge(Integer age);

    String getSsn();

    void setSsn(String ssn);

    ArrayList<IAddress> getAddress();

    void setAddress(ArrayList<IAddress> address);

    ArrayList<IPhone> getPhone();

    void setPhone(ArrayList<IPhone> phone);

    boolean isAvailability();

    void setAvailability(boolean availability);

    String getClasification();

    void setClasification(String clasification);
}
