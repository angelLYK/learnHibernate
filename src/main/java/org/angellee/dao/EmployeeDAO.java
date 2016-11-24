package org.angellee.dao;

import org.angellee.basice.BasicDAOImpl;
import org.angellee.bo.AnnotationEmployee;
import org.hibernate.SessionFactory;

public class EmployeeDAO extends BasicDAOImpl<AnnotationEmployee, Integer> {

	public EmployeeDAO(SessionFactory factory) {
		super(factory, AnnotationEmployee.class);
	}
	
}
