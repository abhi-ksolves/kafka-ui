package com.provectus.kafka.ui.service;

import com.provectus.kafka.ui.entity.Image;
import com.provectus.kafka.ui.model.ApplicationLogoDTO;
import com.provectus.kafka.ui.repository.ImageHandlingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;

@Slf4j
@Service
public class ApplicationLogoHandlingService {

  @Autowired
  ImageHandlingRepository repository;




  public Mono<byte[]> getImageMono(@PathVariable Integer id) {
    return repository.findById(id)
        .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found")))
        .map(Image::getData);
  }

}
