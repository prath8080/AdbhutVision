package com.app.service;

import com.app.pojo.Payment;
import com.app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> updatePayment(Long id, Payment payment) {
        if (!paymentRepository.existsById(id)) {
            return Optional.empty();
        }
        payment.setId(id); // Ensure the ID matches the path variable ID
        return Optional.of(paymentRepository.save(payment));
    }

    public boolean deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            return false;
        }
        paymentRepository.deleteById(id);
        return true;
    }

}
