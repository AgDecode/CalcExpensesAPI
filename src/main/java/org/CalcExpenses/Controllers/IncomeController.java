package org.CalcExpenses.Controllers;

import org.CalcExpenses.DTO.Income;
import org.CalcExpenses.Repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Income getIncomeById(@PathVariable Long id) {
        return incomeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        if (incomeRepository.existsById(id)) {
            incomeRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found");
        }
    }

    @PutMapping("/{id}")
    public Income updateIncome(@PathVariable Long id, @RequestBody Income updatedIncome) {
        return incomeRepository.findById(id)
                .map(income -> {
                    income.setSource(updatedIncome.getSource());
                    income.setAmount(updatedIncome.getAmount());
                    return incomeRepository.save(income);
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found"));
    }
}
