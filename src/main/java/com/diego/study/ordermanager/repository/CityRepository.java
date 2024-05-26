package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
