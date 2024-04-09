package com.provectus.kafka.ui.repository;

import com.provectus.kafka.ui.entity.Users;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UsersRepository extends ReactiveCrudRepository<Users, Integer> {

  @Query("SELECT u.id, u.email, u.full_name, u.active, " +
      "r.name as role_name, c.company, c.logo " +
      "FROM users u " +
      "JOIN roles r ON u.role_id = r.id " +
      "JOIN customers c ON u.customer_id = c.id " +
      "WHERE u.email = :emailId")
  Mono<Users> findByUserEmail(@Param("emailId") String email);
}
