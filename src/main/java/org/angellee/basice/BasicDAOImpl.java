package org.angellee.basice;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BasicDAOImpl<T, PK extends Serializable> implements BasicDAO<T, PK> {
	private SessionFactory factory;
	private Class<T> entityClass;
	
	public BasicDAOImpl(SessionFactory factory, Class<T> cl){
		this.factory = factory;
		this.entityClass = cl;
	}
	
	@Override
	public void save(T t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T t) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public T find(PK pk) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
//			T load = session.load(entityClass, pk);
			T load = session.get(entityClass, pk);
			tx.commit();
			return load;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<T> findAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query<T> query = session.createQuery(" FROM " + entityClass.getSimpleName(), entityClass);
			List<T> results = query.getResultList();
			tx.commit();
			return results;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return null;
	}

}
