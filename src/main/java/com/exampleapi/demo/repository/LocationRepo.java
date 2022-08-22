package com.exampleapi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleapi.demo.model.Location;

public interface LocationRepo extends JpaRepository<Location, Integer>{

 public List<Location> findByLocationCode(String locationCode);
 
}
