package com.ecommerce.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.payment.interfaces.PaymentService;
import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.model.PaymentResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest payload){
		Long id = paymentService.processPayment(payload);
		return new ResponseEntity<>(id,HttpStatus.CREATED);
	}
	@GetMapping("/{orderid}")
	public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable("orderid") Long orderId){
		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
	} 
	
	
}
