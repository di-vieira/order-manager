package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
