package com.exampleapi.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleapi.demo.model.AllBookingTransaction;

public interface AllBookingTransactionRepo extends JpaRepository<AllBookingTransaction, Integer> {

	public List<AllBookingTransaction> findByLocationCode(String locationCode);
    public List<AllBookingTransaction> findByDateOfTransactionAndEmpIdAndSlotTimeAndLocationCode(Date dateOfTransaction,Integer empId,String slotTime,String LocationCode);
public List<AllBookingTransaction>   findByDateOfTransactionAndSlotTimeAndLocationCode(Date dateOfTransaction,String slotTime,String locationCode);
    // public List<AllBookingTransaction>findByDateOfTransactionAndSlotTimeAndLocationCode(Date dateOfTransaction,String slotTime,String locationCode);
public  List<AllBookingTransaction>  findByEmpIdAndSlotTimeAndLocationCode(Integer empId,String slotTime,String locationCode);
}
