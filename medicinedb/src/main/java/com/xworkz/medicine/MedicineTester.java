package com.xworkz.medicine;

import java.util.Scanner;

import com.xworkz.medicine.dao.MedicineDAOImpl;
import com.xworkz.medicine.entity.MedicineEntity;

public class MedicineTester {

	public static void main(String[] args) {

		MedicineDAOImpl medicine = new MedicineDAOImpl();
		MedicineEntity medentity = new MedicineEntity(6, "dart", "dart", 70.0, "05-02-2022", "05-03-2022");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the brand");
		String brand = scanner.next();

		System.out.println("Enter the medicine name");
		String medicineName = scanner.next();

		System.out.println("Enter the price");
		String price = scanner.next();

		medicine.saveMedicineEntity(medentity);
		medicine.getMedicineEntityById();
		medicine.updateMedicineEntityById();
		medicine.deleteMedicineEntityById();

		medicine.getMedicinePriceByBrand(brand);
		medicine.getManufactureDateAndExpireDateByMedicineName(medicineName);
		medicine.getMedicineEntityByPrice(price);
		medicine.updateMedicineNameByBrand(medicineName, brand);
		medicine.deleteMedicineEntityByBrand(brand);
		medicine.getDistinctMedicineName();
		medicine.orderMedicineEntityByPrice();
		medicine.getMedicineEntityByPriceUsingBetween();

		scanner.close();
	}
}
