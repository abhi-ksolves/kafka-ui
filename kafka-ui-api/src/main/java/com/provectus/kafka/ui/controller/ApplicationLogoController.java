package com.provectus.kafka.ui.controller;

import com.provectus.kafka.ui.entity.Customers;
import com.provectus.kafka.ui.entity.Users;
import com.provectus.kafka.ui.service.ApplicationLogoHandlingService;
import com.provectus.kafka.ui.service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApplicationLogoController {

  private final ApplicationLogoHandlingService applicationLogoService;

  private final CustomerDetailsService customerDetailsService;

  @GetMapping(value = "/{id}/view",produces = MediaType.IMAGE_JPEG_VALUE)
  public ResponseEntity<Mono<byte[]>> getApplicationLogo(@PathVariable Integer id, ServerWebExchange exchange) {
    return ResponseEntity.ok(applicationLogoService.getImageMono(id));
  }

  @GetMapping(value = "/{id}/metadata",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mono<Customers>> getCustomerDetails(@PathVariable Long id) {
    return ResponseEntity.ok(customerDetailsService.getCustomerDetailsById(id));
  }

  @GetMapping(value = "/logo/metadata",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Mono<Users>> getCustomerDetails(@RequestParam(name = "email") String emailId) {
    return ResponseEntity.ok(customerDetailsService.getUserDetailsByEmailId(emailId));
  }
}
