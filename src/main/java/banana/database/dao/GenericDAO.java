package banana.database.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E, Id extends Serializable> {

	public void create(E instance) throws Exception;
	public void delete(E instance) throws Exception;
	public void save(E instance) throws Exception;
	public E findById(Id id) throws Exception;
	public List<E> listAll() throws Exception;

}
