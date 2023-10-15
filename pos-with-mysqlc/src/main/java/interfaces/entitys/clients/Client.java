package interfaces.entitys.clients;

import interfaces.entitys.person.Person;

public interface Client extends Person<Integer> {

    String getClasification();

    void setClasification(String clasification);
}

