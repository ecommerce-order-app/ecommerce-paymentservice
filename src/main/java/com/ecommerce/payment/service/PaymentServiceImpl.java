package com.ecommerce.payment.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.payment.dao.TransactionRepo;
import com.ecommerce.payment.entity.Transaction;
import com.ecommerce.payment.interfaces.PaymentService;
import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.model.PaymentResponse;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private TransactionRepo transactionRepo;
	
	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class);


	@Override
	public Long processPayment(PaymentRequest payReq) {
		
		Transaction transaction = Transaction.builder()
				.amount(payReq.getAmount())
				.orderId(payReq.getOrderId())
				.paymentDate(Timestamp.from(Instant.now()))
				.paymentMode(payReq.getPaymentMode())
				.paymentStatus("SUCCESS")
				.transactionNumber(payReq.getTransactionNumber())
				.build();
		Long id = transactionRepo.save(transaction).getId();
		//log id
		return id;
	}
	@Override
	public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
		log.trace("start");
		
		PaymentResponse pr = new PaymentResponse();
		List<Transaction> transList = transactionRepo.findByOrderId(orderId);
		if(transList.isEmpty()) {
			return new PaymentResponse();
		}
		Transaction trans = transList.get(0);
		pr.setAmount(trans.getAmount());
		pr.setOrderId(orderId);
		pr.setPaymentDate(trans.getPaymentDate());
		pr.setStatus(trans.getPaymentStatus());
		pr.setPaymentMode(trans.getPaymentMode());
		pr.setTransactionNumber(trans.getTransactionNumber());
		return pr;
	}
	
}
