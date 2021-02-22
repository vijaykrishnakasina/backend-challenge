package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dto.Dependent;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}
