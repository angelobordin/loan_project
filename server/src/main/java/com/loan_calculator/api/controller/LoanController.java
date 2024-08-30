package com.loan_calculator.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_calculator.api.domain.loan.Loan;
import com.loan_calculator.api.domain.loan.LoanRequestDTO;
import com.loan_calculator.api.domain.loan.LoanResponseDTO;
import com.loan_calculator.api.service.LoanService;
import com.loan_calculator.api.web.ApiResponse;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<ApiResponse<Loan>> create(@RequestBody LoanRequestDTO body) {
        Loan newLoan = this.loanService.create(body);
        ApiResponse<Loan> response = new ApiResponse<>("Loan created successfully", newLoan);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LoanResponseDTO>> getLoanById(@PathVariable Long id) {
        LoanResponseDTO loan = this.loanService.getLoanById(id);
        ApiResponse<LoanResponseDTO> response = new ApiResponse<>("Loan retrieved successfully", loan);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LoanResponseDTO>>> getLoanList() {
        List<LoanResponseDTO> loans = this.loanService.getLoanList();
        ApiResponse<List<LoanResponseDTO>> response = new ApiResponse<>("Loan list retrieved successfully", loans);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Loan>> updateLoanById(@PathVariable Long id, @RequestBody LoanRequestDTO loanDetails) {
        Loan loan = this.loanService.updateLoanById(id, loanDetails);
        ApiResponse<Loan> response = new ApiResponse<>("Loan updated successfully", loan);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteLoanById(@PathVariable Long id) {
        String message = this.loanService.deleteLoanById(id);
        ApiResponse<String> response = new ApiResponse<>(message, null);
        return ResponseEntity.ok(response);
    }
}
