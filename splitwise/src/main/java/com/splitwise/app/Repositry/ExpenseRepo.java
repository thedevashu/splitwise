package com.splitwise.app.Repositry;
import com.splitwise.app.dto.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

}
