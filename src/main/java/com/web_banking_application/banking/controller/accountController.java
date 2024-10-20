package com.web_banking_application.banking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web_banking_application.banking.dto.accountDto;
import com.web_banking_application.banking.service.accountService;


@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})

public class accountController {
//	@Autowired
    private final accountService AccountService;

    public accountController(accountService AccountService) {
        this.AccountService = AccountService;
    }
    
    // Build Add account Rest API
    
    @PostMapping
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<?> createAccount(@RequestBody accountDto AccountDto) {
        System.out.println("Received DTO in controller: " + AccountDto);
            if (AccountDto.getUserId() == null) {
        System.out.println("Error: User ID is null in the received DTO");
        return ResponseEntity.badRequest().body("User ID is required");
    }
    
    try {
        accountDto savedAccount = AccountService.createAccount(AccountDto);
        System.out.println("Created Account DTO: " + savedAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    } catch (Exception e) {
        System.out.println("Error creating account: " + e.getMessage());
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating account: " + e.getMessage());
    }
    }
    // Build get account by userId Rest API
    @GetMapping("/userid/{userId}")
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> getAccountByUserID(@PathVariable("userId") Long userId) {
        accountDto accountDto = AccountService.getAccountByuserId(userId);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //get account details using Account number
    @GetMapping("/{accNumber}")
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> getAccountByAccountNumber(@PathVariable("accNumber") Long accNumber) {
        accountDto accountDto = AccountService.getAccountByAccountNumber(accNumber);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Build get account by accId Rest API
    @GetMapping("/id/{id}")
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> getAccountByID(@PathVariable("id") Long accId) {
        accountDto AccountDto = AccountService.getAcountByID(accId);
        return ResponseEntity.ok(AccountDto);
    }

    // Build get all accounts Rest API
    @GetMapping
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<List<accountDto>> getAllAccounts() {
        List<accountDto> Accounts = AccountService.getAllAccounts();
        return ResponseEntity.ok(Accounts);
    }
    
    // Build Update account Rest API
    @PutMapping("/id/{id}")
     @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> updateAccount(@PathVariable("id") Long accId, @RequestBody accountDto updateAccounts) {
        accountDto AccountDto = AccountService.updateAccountDetails(accId, updateAccounts);
        return ResponseEntity.ok(AccountDto);
    }
    
    @PutMapping("user/{userId}")
    @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> updateAccountByuserId(@PathVariable("userId") Long accNumber,@RequestBody accountDto updatedAccounts) {
        accountDto accountDto = AccountService.updateAccountByuserId(accNumber,updatedAccounts);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("acc/{accNumber}")
    @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<accountDto> updateAccountByAccountNumber(@PathVariable("accNumber") Long accNumber,@RequestBody accountDto updateAccounts) {
        accountDto accountDto = AccountService.updateAccountByAccountNumber(accNumber,updateAccounts);
        if (accountDto != null) {
            return ResponseEntity.ok(accountDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    // Build Delete account Rest API
    @DeleteMapping("/id/{id}")
    @CrossOrigin(origins = {"https://easy-online-bank.netlify.app","https://localhost:3000","https://easy-bank-production.up.railway.app"})
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long accId) {
        AccountService.deleteAccount(accId);
        return ResponseEntity.ok("Account Deleted Successfully!");
    }
}
