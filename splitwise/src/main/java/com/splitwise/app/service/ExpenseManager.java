package com.splitwise.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.splitwise.app.Repositry.ExpenseRepo;
import com.splitwise.app.dto.Expense;

public class ExpenseManager {

    @Autowired
    private ExpenseRepo expenceRepo;

    public void createExpense(Expense expence) {
        expenceRepo.save(expence);

    }
    
}
