package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
