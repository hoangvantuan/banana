package banana.database.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import banana.database.dao.GenericDAO;

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
		List<E> listAll = this.getSession().createQuery("FROM " + this.getEntityName()).list();
		return listAll;
	}

	@Override
	public E findById(Id id) throws Exception {

		E instance =(E) this.getSession().load(this.getFormClass(), id);
		return instance;
	}


}

