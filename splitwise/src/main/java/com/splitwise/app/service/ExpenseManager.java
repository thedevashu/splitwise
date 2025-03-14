package com.splitwise.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.splitwise.app.Repositry.ExpenseRepo;
import com.splitwise.app.dto.Expense;
import com.splitwise.app.dto.Group;
import com.splitwise.app.dto.User;

@Service
public class ExpenseManager {
    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private GroupManager groupManager;

    public Expense createExpense( Expense expense) {
        Group group = groupManager.getGroup(expense.getGroup().getGroupId());
        
        List<User> users = new ArrayList<>(group.getUsers());

        expense.setParticipants(users);
        return expenseRepo.save(expense);
        
    }
    
}
