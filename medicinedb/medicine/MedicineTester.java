package com.xworkz.medicine;

import com.xworkz.medicine.dao.MedicineDAOImpl;
import com.xworkz.medicine.entity.MedicineEntity;

public class MedicineTester {

	public static void main(String[] args) {
		MedicineEntity entity = new MedicineEntity();
		MedicineDAOImpl medicine = new MedicineDAOImpl();
		// medicine.save(entity);
		medicine.getMedicineEntityById();

	}

}
