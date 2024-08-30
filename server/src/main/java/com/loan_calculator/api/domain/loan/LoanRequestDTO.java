package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LoanRequestDTO(LocalDateTime data_emprestimo, String moeda, BigDecimal valor_obtido, LocalDateTime data_vencimento, BigDecimal valor_final, Long customer_id) {

}