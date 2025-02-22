package com.splitwise.app.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitwise.app.dto.Expense;

public interface ExpenseRepo extends JpaRepository<Expense,Long>{
    
}
