package com.greg.banking_app.repository;

import com.greg.banking_app.domain.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
