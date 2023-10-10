package interfaces.persistences.crud;

public interface Crud<T,ID> extends Save<T>, Update<T, ID>, Delete<ID> {

}
