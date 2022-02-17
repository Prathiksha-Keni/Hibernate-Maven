package com.xworkz.medicine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine_details")
@NamedQuery(name = "getMedicinePriceByBrand", query = "select price from MedicineEntity where brand=:BrandName")
@NamedQuery(name = "getManufactureDateAndExpireDateByMedicineName", query = "SELECT medicineName, manufactureDate,expireDate FROM MedicineEntity WHERE medicineName=:MedicineName")
@NamedQuery(name = "getMedicineEntityByPrice", query = "")
@NamedQuery(name = "getMedicineEntityByPrice", query = "FROM MedicineEntity WHERE price IN (:Price)")
@NamedQuery(name = "updateMedicineNameByBrand", query = "UPDATE MedicineEntity SET medicineName=:MedicineName WHERE brand=:Brand")
@NamedQuery(name = "deleteMedicineEntityByBrand", query = "DELETE FROM MedicineEntity WHERE brand=:Brand")
@NamedQuery(name = "getDistinctMedicineName", query = "SELECT DISTINCT medicineName FROM MedicineEntity")
@NamedQuery(name = "orderMedicineEntityByPrice", query = "FROM MedicineEntity ORDER BY price")
@NamedQuery(name = "getMedicineEntityByPriceUsingBetween", query = "FROM MedicineEntity WHERE price BETWEEN 40 AND 70")
public class MedicineEntity {
	@Column(name = "MEDICINE_ID")
	@Id
	private int medicineId;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "MEDICINE_NAME")
	private String medicineName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "MANUFACTURE_DATE")
	private String manufactureDate;

	@Column(name = "EXPIRE_DATE")
	private String expireDate;

	public MedicineEntity() {
		super();

	}

	public MedicineEntity(int medicineId, String brand, String medicineName, double price, String manufactureDate,
			String expireDate) {
		super();
		this.medicineId = medicineId;
		this.brand = brand;
		this.medicineName = medicineName;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.expireDate = expireDate;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getmName() {
		return medicineName;
	}

	public void setmName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getmDate() {
		return manufactureDate;
	}

	public void setmDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String geteDate() {
		return expireDate;
	}

	public void seteDate(String expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "MedicineEntity [medicineId=" + medicineId + ", brand=" + brand + ", medicineName=" + medicineName
				+ ", price=" + price + ", manufactureDate=" + manufactureDate + ", expireDate=" + expireDate + "]";
	}

}
