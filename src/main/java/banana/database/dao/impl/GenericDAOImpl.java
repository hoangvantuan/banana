package banana.database.dao.impl;

import banana.database.dao.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOImpl<E, Id extends Serializable> implements GenericDAO<E, Id> {

  @Autowired
  protected SessionFactory sessionFactory;

  abstract Class<?> getFormClass();

  abstract String getEntityName();

  public Session getSession() {
    return this.sessionFactory.getCurrentSession();
  }

  @Override
  public void saveOrUpdate(E instance) throws Exception {
    this.getSession().saveOrUpdate(instance);
  }

  @Override
  public void delete(E instance) throws Exception {
    this.getSession().delete(instance);
  }

  @Override
  public List<E> listAll() throws Exception {
    List<E> listAll = this.getSession().createQuery("FROM " + this.getEntityName() + "AS A ORDER BY A.id ASC").list();
    return listAll;
  }

  @Override
  public E findById(Id id) throws Exception {

    List<E> instances = (List<E>) this.getSession().createQuery("FROM " + this.getEntityName() + " AS A WHERE A.id = " + "\'" + id + "\'").list();
    if (instances.size() == 1) {
      return instances.get(0);
    }
    return null;
  }

}
