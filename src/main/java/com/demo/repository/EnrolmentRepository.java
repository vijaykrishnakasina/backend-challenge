package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dto.Enrolee;

public interface EnrolmentRepository extends JpaRepository<Enrolee, Integer>{

}
