package com.splitwise.app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.splitwise.app.dto.Expense;
import com.splitwise.app.dto.User;
import com.splitwise.app.service.ExpenseManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/expense")
public class ExpenseController {
    
    @Autowired
    ExpenseManager expenseManager;

    @PostMapping("/add")
    public ResponseEntity<?> addExpense( @RequestBody Expense expense) {
        //TODO: process POST request
        expenseManager.createExpense(expense);
        return ResponseEntity.ok(expense);
        
    }
    
  
}
