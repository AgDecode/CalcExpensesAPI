package org.CalcExpenses.Config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public Counter expenseCreationCounter(MeterRegistry meterRegistry) {
        return Counter.builder("expenses.created")
                .description("Количество созданных расходов")
                .register(meterRegistry);
    }

    @Bean
    public Counter incomeCreationCounter(MeterRegistry meterRegistry) {
        return Counter.builder("incomes.created")
                .description("Количество созданных доходов")
                .register(meterRegistry);
    }
}