package org.CalcExpenses.Controllers;
import org.CalcExpenses.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/balance")
public class BalanceController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping
    public double getCurrentBalance() {
        LocalDate startDate = LocalDate.of(1970, 1, 1);
        LocalDate endDate = LocalDate.now();
        return statisticsService.getBalance(startDate, endDate);
    }
}
