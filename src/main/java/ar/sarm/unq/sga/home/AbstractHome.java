package ar.sarm.unq.sga.home;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class AbstractHome<T> implements Home<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T find(Integer id) {
		Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractHome.class);
		return getSession().get(genericType, id);
	}
	@Override
	public void insert(T object) {
		this.getSession().save(object);

	}

	@Override
	public void update(T object) {
		this.getSession().update(object);
	}

	@Override
	public void delete(T object) {
		this.getSession().delete(object);
	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
