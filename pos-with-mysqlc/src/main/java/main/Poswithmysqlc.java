package main;

import entitiys.client.NormalClient;
import persistence.dao.NormalClientRepository;
import services.NormalClientServiceImp;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        
        NormalClientRepository normalClientRepository = new NormalClientRepository();
        
        NormalClientServiceImp normalClientServiceImp = new NormalClientServiceImp(normalClientRepository);
        
       
        
        NormalClient normalClient = normalClientServiceImp.findById(14);

        
//        normalClient.setName("JEJEJE");
//        normalClient.setLastName("Osorio");
//        normalClient.setAge(29);
//        normalClient.setSsn("38128526");
//        normalClient.setClasification("Vip");
//        
//        normalClientServiceImp.save(normalClient);
        
//        normalClient = normalClientServiceImp.update(normalClient.getId(),normalClient);
//        
//         normalClientServiceImp.delete(13);
        
        System.out.println(normalClient);
     
//       Class<?> clientParameters = normalClient.getClass().getSuperclass();
//       Field[] campos = clientParameters.getDeclaredFields();
        
    
            
        
 
    
    }
}
