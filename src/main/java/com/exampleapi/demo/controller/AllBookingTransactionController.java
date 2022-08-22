package com.exampleapi.demo.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleapi.demo.model.AllBookingTransaction;
import com.exampleapi.demo.repository.AllBookingTransactionRepo;
import com.exampleapi.demo.repository.LocationRepo;
import com.exampleapi.demo.service.AllBookingTransactionService;

@RestController
@RequestMapping("/user")
public class AllBookingTransactionController {
	@Autowired
	AllBookingTransactionService allBookingTransactionService;
	@Autowired
	LocationRepo locationRepo;
	
	
    @Transactional
	@PostMapping("book/{Code}")
	public String BookSeatAtLocationCode(@PathVariable("Code") String code,
			@RequestParam(name = "empid", required = true, defaultValue = "****") Integer empId,
			@RequestBody AllBookingTransaction allBookingTransaction) {
		
		allBookingTransaction.setEmpId(empId);
		
		allBookingTransactionService.bookSeat(code, allBookingTransaction);
		return "success";
	}

	@PostMapping("/cancel/{id}")

	public String CancelSeat(@PathVariable("id") Integer id) {
		allBookingTransactionService.DeletebyId(id);
		return "success";
	}

	@GetMapping("/booked")

	public List<AllBookingTransaction> ListOfBooked() {
		return allBookingTransactionService.ListOfAllTransaction();
	}

	@GetMapping("/bookedlist/{code}")

	public List<AllBookingTransaction> listOfBookedByCode(@PathVariable("code") String code) {
		return allBookingTransactionService.ListOfAllBookingByCode(code);
	}

	@GetMapping("countbookingbydateslot/{code}")
    
    public Integer CountBookingByDateSlot(@PathVariable("code")String code,@RequestBody AllBookingTransaction allBookingTransaction)
    {
    	Date date=allBookingTransaction.getDateOfTransaction();
    	String slotTimeString=allBookingTransaction.getSlotTime();
    //	Integer n= locationRepo.
    	return  allBookingTransactionService.CountBookingByDateAndSlot(code, date, slotTimeString);
    }

	
	// Debug purpose
	@GetMapping("/test")
	public List<AllBookingTransaction> Helper()
	{
		return allBookingTransactionService.func();
	}
	
}
