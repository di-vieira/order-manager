package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
}
