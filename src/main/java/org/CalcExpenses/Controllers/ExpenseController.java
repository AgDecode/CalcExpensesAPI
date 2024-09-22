package org.CalcExpenses.Controllers;

import org.CalcExpenses.DTO.Expense;
import org.CalcExpenses.Repository.ExpenseRepository;
import org.CalcExpenses.Service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private MetricsService metricsService;  // Инъекция сервиса для метрик

    @PostMapping("/api/expenses")
    public Expense createExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseRepository.save(expense);
        metricsService.incrementExpenseCreationCounter();  // Увеличиваем кастомную метрику
        return savedExpense;
    }
}

