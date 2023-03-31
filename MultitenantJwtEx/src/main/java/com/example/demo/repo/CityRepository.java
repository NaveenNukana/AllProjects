package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;
@Repository
public interface CityRepository extends JpaRepository<City,Long> {

    City findByName(String name);

    void deleteByName(String name);
}
