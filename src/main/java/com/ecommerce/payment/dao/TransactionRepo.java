package com.ecommerce.payment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.payment.entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long>{
	List<Transaction> findByOrderId(Long orderId);
}
