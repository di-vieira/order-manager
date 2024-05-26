package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
