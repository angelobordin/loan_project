package com.loan_calculator.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan_calculator.api.domain.customer.Customer;
import com.loan_calculator.api.domain.loan.Loan;
import com.loan_calculator.api.domain.loan.LoanRequestDTO;
import com.loan_calculator.api.domain.loan.LoanResponseDTO;
import com.loan_calculator.api.repositories.CustomerRepository;
import com.loan_calculator.api.repositories.LoanRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoanService {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanRepository repository;

    public Loan create(LoanRequestDTO data) {
        Customer customer = this.customerRepository.findById(data.customer_id()).orElseThrow(() -> new EntityNotFoundException("Cliente não localizado!")); 

        Loan newLoan = new Loan();
        newLoan.setCustomer(customer);
        newLoan.setData_emprestimo(data.data_emprestimo());
        newLoan.setMoeda(data.moeda());
        newLoan.setValor_obtido(data.valor_obtido());
        newLoan.setValor_final(data.valor_final());
        newLoan.setData_vencimento(data.data_vencimento());

        this.repository.save(newLoan);

        return newLoan;
    }

    public LoanResponseDTO getLoanById(Long id) {
        Loan loan = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empréstimo não localizado")); 
        return new LoanResponseDTO(loan.getId(), loan.getData_emprestimo(), loan.getMoeda(), loan.getValor_obtido(), loan.getData_vencimento(), loan.getValor_final(), loan.getCustomer());
    }

    public List<LoanResponseDTO> getLoanList() {
        List<Loan> loans = this.repository.findAll();
        return loans.stream().map((Loan l) -> new LoanResponseDTO(l.getId(), l.getData_emprestimo(), l.getMoeda(), l.getValor_obtido(), l.getData_vencimento(), l.getValor_final(), l.getCustomer())).collect(Collectors.toList());
    }

    public String deleteLoanById(Long id) {
        this.repository.deleteById(id);
        return "Empréstimo deletado com sucesso!";
    }
    
    public Loan updateLoanById(Long id, LoanRequestDTO loanDetails) {
        Loan loan = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Empréstimo não localizado"));
        
        Loan updatedLoan = new Loan();
        updatedLoan.setId(loan.getId());
        updatedLoan.setData_emprestimo(loanDetails.data_emprestimo() != null ? loanDetails.data_emprestimo() : loan.getData_emprestimo());
        updatedLoan.setMoeda(loanDetails.moeda() != null ? loanDetails.moeda() : loan.getMoeda());
        updatedLoan.setValor_obtido(loanDetails.valor_obtido() != null ? loanDetails.valor_obtido() : loan.getValor_obtido());
        updatedLoan.setValor_final(loanDetails.valor_final() != null ? loanDetails.valor_final() : loan.getValor_final());
        updatedLoan.setData_vencimento(loanDetails.data_vencimento() != null ? loanDetails.data_vencimento() : loan.getData_vencimento());

        return this.repository.save(updatedLoan);
    }
}
