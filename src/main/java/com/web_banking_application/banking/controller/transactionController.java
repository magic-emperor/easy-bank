package com.web_banking_application.banking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_banking_application.banking.dto.transactionDto;
import com.web_banking_application.banking.service.transactionService;

@CrossOrigin("https://chipper-vacherin-299a05.netlify.app/")
@RestController
@RequestMapping("/api/transaction")
public class transactionController {
	
	
	private final transactionService TransactionService;
	public transactionController( transactionService TransactionService) {
		this.TransactionService = TransactionService;
		// TODO Auto-generated constructor stub
	}
	@CrossOrigin(origins = "https://chipper-vacherin-299a05.netlify.app/")
	@PostMapping
	public ResponseEntity<transactionDto> createTransaction(@RequestBody transactionDto TransactionDto){
		transactionDto savedTransaction = TransactionService.createTransaction(TransactionDto);
		return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "https://chipper-vacherin-299a05.netlify.app/")
	@GetMapping
	public ResponseEntity<List<transactionDto>> getAllTransaction(){
		List<transactionDto> Transactions = TransactionService.getAlltransaction();
		return ResponseEntity.ok(Transactions);
	}
	
//    @GetMapping("/{userId}")
//    public ResponseEntity<transactionDto> getTransactionById(@PathVariable("userId") Long userId) {
//        transactionDto transactionDto = TransactionService.getAllTransctionById(userId);
//        if (transactionDto != null) {
//            return ResponseEntity.ok(transactionDto);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

	
	@GetMapping("/{userId}")
	public ResponseEntity<List<transactionDto>> getTransactionById(@PathVariable("userId") Long userId) {
	    List<transactionDto> transactionDtos = TransactionService.getAllTransctionById(userId);
	    if (!transactionDtos.isEmpty()) {
	        return ResponseEntity.ok(transactionDtos);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
    
	   @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionId) {
		   TransactionService.deleteTransaction(transactionId);
	        return ResponseEntity.ok("Transaction Deleted Successfully!");
	    }
}
