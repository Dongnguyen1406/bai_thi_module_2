package repository;

import java.util.List;

public interface IRepository<T> {
    List<T> getAll();
    void addNew(T t);
    boolean delete(String idMedical);
    boolean isExists(String idMedical, List<T> t);
}
