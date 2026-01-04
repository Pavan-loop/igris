package com.madara.security.repository;

import com.madara.security.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByEmailOrPhoneNumber(
            String email,
            String phoneNumber
    );

    boolean existsByEmailOrPhoneNumberAndIdNot(
            String email,
            String phoneNumber,
            Long id
    );
}
