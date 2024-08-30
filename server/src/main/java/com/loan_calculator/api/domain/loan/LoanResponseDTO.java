package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.loan_calculator.api.domain.customer.Customer;

public record LoanResponseDTO(Long id, LocalDateTime data_emprestimo, String moeda, BigDecimal valor_obtido, LocalDateTime data_vencimento, BigDecimal valor_final, Customer customer) {

}
