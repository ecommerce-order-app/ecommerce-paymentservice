package com.ecommerce.payment.interfaces;

import com.ecommerce.payment.model.PaymentRequest;
import com.ecommerce.payment.model.PaymentResponse;

public interface PaymentService {
	public Long processPayment(PaymentRequest payReq);
	
	public PaymentResponse getPaymentDetailsByOrderId(Long orderId);
}
