package entitys.models.employee;

import interfaces.entitys.employee.IEmployee;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString(callSuper = true)
public class Employee implements IEmployee {

    private boolean active;
    private String rol;
    private Double salary;

    public Employee(boolean active, String rol, Double salary) {
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
