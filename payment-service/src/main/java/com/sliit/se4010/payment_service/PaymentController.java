package com.sliit.se4010.payment_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/payments") // [cite: 106]
public class PaymentController {

    // In-memory list to store payment records [cite: 108]
    private List<Map<String, Object>> payments = new ArrayList<>();
    private int idCounter = 1; // [cite: 108]

    // GET /payments - Returns all payments [cite: 109, 215]
    @GetMapping
    public List<Map<String, Object>> getPayments() {
        return payments; // [cite: 111]
    }

    // POST /payments/process - Process a payment [cite: 113, 215]
    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Map<String, Object> payment) {
        payment.put("id", idCounter++); // [cite: 116]
        payment.put("status", "SUCCESS"); // [cite: 117]
        payments.add(payment); // [cite: 118]
        return ResponseEntity.status(201).body(payment); // [cite: 119]
    }

    // GET /payments/{id} - Get payment status by ID [cite: 120, 215]
    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(@PathVariable int id) {
        return payments.stream()
                .filter(p -> p.get("id").equals(id)) // [cite: 124]
                .findFirst() // [cite: 125]
                .map(ResponseEntity::ok) // [cite: 126]
                .orElse(ResponseEntity.notFound().build()); // [cite: 127]
    }
}