package com.maxi.iPayback.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.iPayback.entities.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findById(Long id);

    List<Transaction> findByTimestemp(LocalDate timestemp);
}
