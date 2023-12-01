package ra.demo.model.dao;

import java.util.List;

public interface IGenericDAO <T,ID>{
    List<T> findAll();
    boolean saveOrUpdate(T t);
    T findById(ID id);

}
