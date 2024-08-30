package com.loan_calculator.api.domain.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.loan_calculator.api.domain.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data_emprestimo;

    private String moeda;

    private BigDecimal valor_obtido;

    private BigDecimal valor_final;

    private LocalDateTime data_vencimento;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
