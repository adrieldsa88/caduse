package com.adrieldsa88.caduse.infrastructure.repository;

import com.adrieldsa88.caduse.infrastructure.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
