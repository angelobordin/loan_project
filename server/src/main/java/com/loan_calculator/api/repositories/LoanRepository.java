package com.loan_calculator.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loan_calculator.api.domain.loan.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    long countByCustomerId(Long customerId);
}
