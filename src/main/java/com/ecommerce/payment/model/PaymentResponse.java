package com.ecommerce.payment.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentResponse {
	
	private Long orderId;

	private String paymentMode;

	private String transactionNumber;

	private Float amount;

	private Timestamp paymentDate;
	
	private String status;
	
}
