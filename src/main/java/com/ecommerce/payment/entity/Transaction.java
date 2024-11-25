package com.ecommerce.payment.entity;

import java.sql.Time;
import java.sql.Timestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "payments",name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long orderId;
	
	private String paymentMode;
	
	private String transactionNumber;
	
	private Timestamp paymentDate;
	
	private String paymentStatus;
	
	private Long amount;
	
	
	
}
