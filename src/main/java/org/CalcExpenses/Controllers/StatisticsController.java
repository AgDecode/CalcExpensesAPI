package org.CalcExpenses.Controllers;

import org.CalcExpenses.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/income")
    public double getTotalIncome(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getTotalIncome(startDate, endDate);
    }

    @GetMapping("/expense")
    public double getTotalExpense(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getTotalExpense(startDate, endDate);
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getBalance(startDate, endDate);
    }

    @GetMapping("/expense/average")
    public double getAverageExpense(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getAverageExpense(startDate, endDate);
    }

    @GetMapping("/income/average")
    public double getAverageIncome(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getAverageIncome(startDate, endDate);
    }
}

