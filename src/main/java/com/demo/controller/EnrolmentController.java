package com.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Enrolee;
import com.demo.service.EnrolmentService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class EnrolmentController {

	@Autowired
	EnrolmentService enrolmentService;
	
	@GetMapping
	public String healthCheck() {
		return "200 OK";
	}
	
	@PostMapping(path = "/enrolees")
	public Enrolee addEnrolee(@Valid @RequestBody Enrolee enrolee) {
		log.info(" from addEnrolee "+ enrolee);
		return enrolmentService.save(enrolee);
	}
	
	@GetMapping(path = "/enrolees/{enrolee_id}")
	public Enrolee getEnrolee(@PathVariable Integer enrolee_id) {
		log.info(" from getEnrolee "+ enrolee_id);
		return enrolmentService.findById(enrolee_id);
	}
	
	@PutMapping(path = "/enrolees/{enrolee_id}")
	public Enrolee updateEnrolee(@PathVariable Integer enrolee_id, @Valid @RequestBody Enrolee enrolee) {
		log.info(" from updateEnrolee "+ enrolee);
		enrolee.setEnrolee_id(enrolee_id);
		return enrolmentService.update(enrolee);
	}
	
	@DeleteMapping(path = "/enrolees/{enrolee_id}")
	public void deleteEnrolee(@PathVariable Integer enrolee_id) {
		log.info(" from deleteEnrolee "+ enrolee_id);
		enrolmentService.delete(enrolee_id);
	}
	
}
