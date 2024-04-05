package com.provectus.kafka.ui.repository;

import com.provectus.kafka.ui.entity.Customers;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customers, Long> {
}
