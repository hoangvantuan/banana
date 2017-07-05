package banana.database.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, Id extends Serializable> {

	public void delete(E instance) throws Exception;
	public void saveOrUpdate(E instance) throws Exception;
	public E findById(Id id) throws Exception;
	public List<E> listAll() throws Exception;

}
