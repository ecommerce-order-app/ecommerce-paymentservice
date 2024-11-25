package com.ecommerce.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.payment.dao.TransactionRepo;
import com.ecommerce.payment.interfaces.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private TransactionRepo transactionRepo;
	
}
