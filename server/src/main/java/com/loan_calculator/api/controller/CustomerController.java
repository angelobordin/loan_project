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

import com.loan_calculator.api.domain.customer.Customer;
import com.loan_calculator.api.domain.customer.CustomerRequestDTO;
import com.loan_calculator.api.domain.customer.CustomerResponseDTO;
import com.loan_calculator.api.service.CustomerService;
import com.loan_calculator.api.web.ApiResponse;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<ApiResponse<Customer>> create(@RequestBody CustomerRequestDTO body) {
        Customer newCustomer = this.customerService.create(body);
        ApiResponse<Customer> response = new ApiResponse<>("Customer created successfully", newCustomer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerById(@PathVariable Long id) {
        CustomerResponseDTO customer = this.customerService.getCustomerById(id);
        ApiResponse<CustomerResponseDTO> response = new ApiResponse<>("Customer retrieved successfully", customer);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerResponseDTO>>> getCustomerList() {
        List<CustomerResponseDTO> customers = this.customerService.getCustomerList();
        ApiResponse<List<CustomerResponseDTO>> response = new ApiResponse<>("Customer list retrieved successfully", customers);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> updateCustomerById(@PathVariable Long id, @RequestBody CustomerRequestDTO loanDetails) {
        Customer customer = this.customerService.updateCustomerById(id, loanDetails);
        ApiResponse<Customer> response = new ApiResponse<>("Customer updated successfully", customer);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCustomerById(@PathVariable Long id) {
        String message = this.customerService.deleteCustomerById(id);
        ApiResponse<String> response = new ApiResponse<>(message, null);
        return ResponseEntity.ok(response);
    }
}
