package com.xworkz.medicine.dao;

public interface MedicineDAO {
	public void saveMedicineEntity(Object entity);

	public void getMedicineEntityById();

	public void updateMedicineEntityById();

	public void deleteMedicineEntityById();

	public void getMedicinePriceByBrand(String brand);

	public void getManufactureDateAndExpireDateByMedicineName(String medicineName);

	public void getMedicineEntityByPrice(String price);

	public void updateMedicineNameByBrand(String medicineName, String brand);

	public void deleteMedicineEntityByBrand(String brand);

	public void getDistinctMedicineName();

	public void orderMedicineEntityByPrice();

	public void getMedicineEntityByPriceUsingBetween();
}
