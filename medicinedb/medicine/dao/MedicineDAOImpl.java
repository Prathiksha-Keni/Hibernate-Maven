package com.xworkz.medicine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.medicine.entity.MedicineEntity;

public class MedicineDAOImpl implements MedicineDAO {

	public void save(Object entity) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(MedicineEntity.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			MedicineEntity medentity = new MedicineEntity(4, "pan-40", "pan-40", 10.0, "1-2-2022", "1-6-2022");
			// session.save(medicine);
			session.persist(medentity);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("session Factory is  closed");
			} else {
				System.out.println("session Factory is not closed");
			}
		}

	}

	public void getMedicineEntityById() {

		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(MedicineEntity.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();

			MedicineEntity medentity = session.load(MedicineEntity.class, 1);
			System.out.println(medentity.toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
			if (sessionFactory != null) {
				sessionFactory.close();
				System.out.println("session Factory is  closed");
			} else {
				System.out.println("session Factory is not closed");
			}
		}
	}

}
