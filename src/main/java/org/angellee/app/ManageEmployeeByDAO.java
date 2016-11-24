package org.angellee.app;

import java.util.List;

import org.angellee.bo.AnnotationEmployee;
import org.angellee.dao.EmployeeDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployeeByDAO {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		EmployeeDAO dao = new EmployeeDAO(factory);
		
		AnnotationEmployee find = dao.find(new Integer(1));
		System.out.println(find.getFirstName());

		List<AnnotationEmployee> findAll = dao.findAll();
		for (AnnotationEmployee annotationEmployee : findAll) {
			System.out.println(annotationEmployee.getSalary());
		}
		
		factory.close();
	}
}
