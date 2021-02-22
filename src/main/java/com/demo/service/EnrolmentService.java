package com.demo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.Enrolee;
import com.demo.repository.EnrolmentRepository;

@Service
public class EnrolmentService {
	
	@Autowired
	EnrolmentRepository enrolmentRepository;

	public Enrolee save(Enrolee enrolees) {
		
		return enrolmentRepository.save(enrolees);
	}

	public Enrolee findById(Integer id) {
		return enrolmentRepository.findById(id).get();
	}

	public Enrolee update(@Valid Enrolee enrolees) {
		return enrolmentRepository.save(enrolees);
	}

	public void delete(Integer enrolee_id) {
		enrolmentRepository.deleteById(enrolee_id);
	}
}
