package interfaces.services;

import java.io.Serializable;

public interface Service<T, ID> extends Serializable {
    
    boolean checkDuplicateRegister(T t); // revisar si es necesario esta funcion
}
