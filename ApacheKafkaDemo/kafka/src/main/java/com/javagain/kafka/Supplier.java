package com.javagain.kafka;

import java.util.Date;

public class Supplier {
	
	private int supplierId;
	private String supplierName;
	private Date supplierStartDate;
	public Supplier(int id, String desserializeName, Date parse) {
		this.supplierId = id;
		this.supplierName = desserializeName;
		this.supplierStartDate = parse;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getSupplierStartDate() {
		return supplierStartDate;
	}
	public void setSupplierStartDate(Date supplierStartDate) {
		this.supplierStartDate = supplierStartDate;
	}
	
	

}
