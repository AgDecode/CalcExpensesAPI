package org.CalcExpenses.Service;

import org.CalcExpenses.DTO.Expense;
import org.CalcExpenses.DTO.Income;
import org.CalcExpenses.Repository.ExpenseRepository;
import org.CalcExpenses.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    public double getTotalIncome(LocalDate startDate, LocalDate endDate) {
        List<Income> incomes = incomeRepository.findByDateBetween(startDate, endDate);
        return incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
    }

    public double getTotalExpense(LocalDate startDate, LocalDate endDate) {
        List<Expense> expenses = expenseRepository.findByDateBetween(startDate, endDate);
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    public double getBalance(LocalDate startDate, LocalDate endDate) {
        double totalIncome = getTotalIncome(startDate, endDate);
        double totalExpense = getTotalExpense(startDate, endDate);
        return totalIncome - totalExpense;
    }

    public double getAverageExpense(LocalDate startDate, LocalDate endDate) {
        List<Expense> expenses = expenseRepository.findByDateBetween(startDate, endDate);
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .average()
                .orElse(0.0);
    }

    public double getAverageIncome(LocalDate startDate, LocalDate endDate) {
        List<Income> incomes = incomeRepository.findByDateBetween(startDate, endDate);
        return incomes.stream()
                .mapToDouble(Income::getAmount)
                .average()
                .orElse(0.0);
    }
}
