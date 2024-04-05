package com.provectus.kafka.ui.service;

import com.provectus.kafka.ui.entity.Customers;
import com.provectus.kafka.ui.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CustomerDetailsService {

  @Autowired
  private CustomerRepository repository;

  public Mono<Customers> getCustomerDetailsById(long id){
    return repository.findById(id);
  }
}
