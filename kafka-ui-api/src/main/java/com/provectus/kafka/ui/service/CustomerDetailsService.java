package com.provectus.kafka.ui.service;

import com.provectus.kafka.ui.entity.Customers;
import com.provectus.kafka.ui.entity.Users;
import com.provectus.kafka.ui.repository.CustomerRepository;
import com.provectus.kafka.ui.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CustomerDetailsService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private UsersRepository usersRepository;

  public Mono<Customers> getCustomerDetailsById(long id){
    return customerRepository.findById(id);
  }

  public Mono<Users> getUserDetailsByEmailId(String emailId){
    return usersRepository.findByUserEmail(emailId).switchIfEmpty(Mono.error(
        new ResponseStatusException(HttpStatus.OK,"User not found")
    ));
  }
}
