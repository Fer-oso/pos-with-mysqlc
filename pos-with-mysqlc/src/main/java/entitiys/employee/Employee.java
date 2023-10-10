package entitiys.employee;

import entitiys.addres.Addres;
import entitiys.person.Person;
import entitiys.phone.Phone;
import interfaces.entitys.employee.IEmployee;
import java.util.List;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Employee extends Person<Integer> implements IEmployee {

    private boolean active;
    private String rol;
    private Double salary;

    public Employee(Integer id, String name, String lastName, String ssn, Integer age, List<Addres> addres, List<Phone> phone,boolean active, String rol, Double salary) {
        super(id, name, lastName, age, ssn, addres, phone);
        this.active = active;
        this.rol = rol;
        this.salary = salary;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getRol() {
        return rol;
    }

    @Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
