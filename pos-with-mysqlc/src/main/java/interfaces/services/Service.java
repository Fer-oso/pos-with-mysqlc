
package interfaces.services;

import java.lang.reflect.Constructor;
import services.exceptions.ClientServiceExceptions;

public interface Service<T> {
    
   default <S extends T> S create(Class<S> normalClientType) throws Exception{
    
       try {

            Constructor<S> normalClientContructor = normalClientType.getDeclaredConstructor();

            S normalClientInstance = normalClientContructor.newInstance();

            return normalClientInstance;

        } catch (SecurityException | IllegalArgumentException ex) {

            throw new ClientServiceExceptions(ex.getMessage());
        }
    
    }
    
}
