package org.angellee.basice;

import java.io.Serializable;
import java.util.List;

public interface BasicDAO<T, PK extends Serializable> {
	public void save(T t);
	public void update(T t);
	public T find(PK pk);
	public List<T> findAll();
}
