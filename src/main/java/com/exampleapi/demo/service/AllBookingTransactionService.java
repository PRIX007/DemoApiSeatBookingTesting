package com.exampleapi.demo.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleapi.demo.model.AllBookingTransaction;
import com.exampleapi.demo.repository.AllBookingTransactionRepo;
@Service

public class AllBookingTransactionService {
    
	@Autowired
	AllBookingTransactionRepo allBookingTransactionRepo;
	
	public Integer bookSeat(String code, AllBookingTransaction allBookingTransaction)
	{
		allBookingTransaction.setLocationCode(code);
		allBookingTransaction=allBookingTransactionRepo.save(allBookingTransaction);
	return allBookingTransaction.getTransactionId();
	}

	public void DeletebyId(Integer id) {
		allBookingTransactionRepo.deleteById(id);
		
	}

	public List<AllBookingTransaction> ListOfAllTransaction() {
		// TODO Auto-generated method stub
		return allBookingTransactionRepo.findAll();
	}
	
	public List<AllBookingTransaction>   ListOfAllBookingByCode(String Code)
	{
		return allBookingTransactionRepo.findByLocationCode(Code);
	}
	
	public Integer CountBookingByDateAndSlot(String code,Date date,String Slot)
	{
		List<AllBookingTransaction> list=allBookingTransactionRepo.findByDateOfTransactionAndSlotTimeAndLocationCode(date, Slot, code);
		
		return list.size();
	}
	public List<AllBookingTransaction> func()
	{String code="RJ14";
	 Integer empId=1007;
	 String slot="AM";
	 return allBookingTransactionRepo.findByEmpIdAndSlotTimeAndLocationCode(empId, slot, code);
	 
		
	}

}

