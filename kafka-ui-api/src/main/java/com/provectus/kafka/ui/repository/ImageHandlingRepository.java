package com.provectus.kafka.ui.repository;

import com.provectus.kafka.ui.entity.Image;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageHandlingRepository extends ReactiveCrudRepository<Image,Integer> {
}
