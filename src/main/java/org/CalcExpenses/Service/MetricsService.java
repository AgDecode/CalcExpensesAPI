package org.CalcExpenses.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetricsService {

    private final Counter expenseCreationCounter;
    private final Counter incomeCreationCounter;

    public void incrementExpenseCreationCounter() {
        expenseCreationCounter.increment();
    }

    public void incrementExpenseDeletionCounter() {
        incomeCreationCounter.increment();
    }
}
