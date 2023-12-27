package interfaces.entitys.checkout;

import interfaces.entitys.entity.Entity;

public interface ICheckOut<ID> extends Entity<ID>{

    @Override
    public void setId(ID id);

    @Override
    public ID getId();
  
}
