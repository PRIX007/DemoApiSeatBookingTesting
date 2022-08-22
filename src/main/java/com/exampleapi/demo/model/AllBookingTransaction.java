package com.exampleapi.demo.model;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="all_booking_transaction")
public class AllBookingTransaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="location_code")
	private String locationCode;
	
	@Column (name="date_of_transaction")
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfTransaction;
	
	@Column(name="slot_time")
	private String slotTime; // "AM" "PM"

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
     
	public AllBookingTransaction() {
		super();
	}

	public AllBookingTransaction(Integer empId, String locationCode, Date dateOfTransaction, String slotTime) {
		super();
		this.empId = empId;
		this.locationCode = locationCode;
		this.dateOfTransaction = dateOfTransaction;
		this.slotTime = slotTime;
	}
	
	
}
