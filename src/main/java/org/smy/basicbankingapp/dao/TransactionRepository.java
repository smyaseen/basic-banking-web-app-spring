package org.smy.basicbankingapp.dao;

import org.smy.basicbankingapp.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Override
    List<Transaction> findAll();
}
