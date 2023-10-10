package interfaces.entitys.person;

import interfaces.entitys.entity.Entity;

public interface IPerson<K> extends Entity<K> {

    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    Integer getAge();

    void setAge(Integer age);

    String getSsn();

    void setSsn(String ssn);
}
