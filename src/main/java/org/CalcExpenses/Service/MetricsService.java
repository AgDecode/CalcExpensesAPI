package org.CalcExpenses.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MetricsService {

    private final Counter expenseCreationCounter;

    public MetricsService(MeterRegistry meterRegistry) {
        // Создаем кастомную метрику для подсчета созданных расходов
        this.expenseCreationCounter = meterRegistry.counter("expense.creation.count");
    }

    // Метод для увеличения счетчика
    public void incrementExpenseCreationCounter() {
        expenseCreationCounter.increment();
    }
}
