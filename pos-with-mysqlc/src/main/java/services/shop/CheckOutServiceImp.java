package services.shop;

import entitys.models.shop.checkout.CheckOut;
import interfaces.persistences.repositorys.entitys.shop.checkout.CheckOutRepository;
import interfaces.services.checkout.CheckOutService;
import java.util.ArrayList;

public class CheckOutServiceImp implements CheckOutService {

    private static final long serialVersionUID = 1L;

    private final CheckOutRepository CheckOutRepository;

    public CheckOutServiceImp(CheckOutRepository CheckOutRepository) {
        this.CheckOutRepository = CheckOutRepository;
    }

    @Override
    public CheckOut save(CheckOut object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CheckOut update(Integer id, CheckOut object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CheckOut> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CheckOut findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkDuplicateRegister(CheckOut t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
