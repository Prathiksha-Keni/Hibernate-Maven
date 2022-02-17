package com.xworkz.medicine.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.*;
import com.xworkz.medicine.entity.MedicineEntity;
import com.xworkz.medicine.util.SessionFactoryProvider;

public class MedicineDAOImpl implements MedicineDAO {

	public void saveMedicineEntity(Object entity) {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;

		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println(entity);
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
			sessionFactory = SessionFactoryProvider.getSessionFactory();
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

	public void updateMedicineEntityById() {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			MedicineEntity medicineentity = session.get(MedicineEntity.class, 6);
			System.out.println(medicineentity);

			medicineentity.setBrand("Rantac");
			medicineentity.setmName("Cipla");
			medicineentity.setmDate("03-03-2022");
			medicineentity.seteDate("03-03-2023");
			medicineentity.setPrice(40.0);
			session.update(medicineentity);
			transaction.commit();
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

	@Override
	public void deleteMedicineEntityById() {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			MedicineEntity medicineentity = session.get(MedicineEntity.class, 6);
			System.out.println(medicineentity);
			transaction = session.beginTransaction();
			session.delete(medicineentity);
			transaction.commit();
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

	@Override
	public void getMedicinePriceByBrand(String brand) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getMedicinePriceByBrand");
			query.setParameter("BrandName", brand);
			Object result = query.uniqueResult();
			System.out.println(result);
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

	@Override
	public void getManufactureDateAndExpireDateByMedicineName(String medicineName) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getManufactureDateAndExpireDateByMedicineName");
			query.setParameter("MedicineName", medicineName);
			// Object result=query.uniqueResult();
			// MedicineEntity medicine=(MedicineEntity)result;
			List<MedicineEntity> list = query.list();
			for (MedicineEntity entity : list) {
				System.out.println(entity);
			}
		} catch (Exception e) {
			System.out.println(e);
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

	@Override
	public void getMedicineEntityByPrice(String price) {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("getMedicineEntityByPrice");
			query.setParameter("Price", price);
			List<MedicineEntity> list = query.list();
			for (MedicineEntity entity : list) {
				System.out.println(entity);
			}

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

	@Override
	public void updateMedicineNameByBrand(String medicineName, String brand) {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("updateMedicineNameByBrand");
			query.setParameter("MedicineName", medicineName);
			query.setParameter("Brand", brand);
			query.executeUpdate();
			transaction.commit();
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

	@Override
	public void deleteMedicineEntityByBrand(String brand) {
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("deleteMedicineEntityByBrand");
			query.setParameter("Brand", brand);
			query.executeUpdate();
			transaction.commit();
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

	@Override
	public void getDistinctMedicineName() {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getDistinctMedicineName");
			List<MedicineEntity> list = query.list();
			for (MedicineEntity entity : list) {
				System.out.println(entity);
			}
		} catch (Exception e) {
			System.out.println(e);
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

	@Override
	public void orderMedicineEntityByPrice() {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("orderMedicineEntityByPrice");
			List<MedicineEntity> list = query.list();
			for (MedicineEntity entity : list) {
				System.out.println(entity);
			}
		} catch (Exception e) {
			System.out.println(e);
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

	@Override
	public void getMedicineEntityByPriceUsingBetween() {
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = SessionFactoryProvider.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("getMedicineEntityByPriceUsingBetween");
			List<MedicineEntity> list = query.list();
			for (MedicineEntity entity : list) {
				System.out.println(entity);
			}
		} catch (Exception e) {
			System.out.println(e);
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
