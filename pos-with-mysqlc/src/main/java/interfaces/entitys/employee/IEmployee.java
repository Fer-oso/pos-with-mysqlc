package interfaces.entitys.employee;

public interface IEmployee {
    
    boolean isActive();
    
    void setActive(boolean active);
    
    String getRol();
    
    void setRol(String rol);
    
    Double getSalary();
    
    void setSalary(Double salary);
    
}
