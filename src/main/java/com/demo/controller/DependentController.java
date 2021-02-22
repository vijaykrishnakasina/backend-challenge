package com.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Dependent;
import com.demo.dto.Enrolee;
import com.demo.repository.EnrolmentRepository;
import com.demo.service.EnrolmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DependentController {
	
	@Autowired
	EnrolmentService enrolmentService;
	
	@GetMapping(path = "/enrolees/{enrolee_id}/dependents/{dependent_id}")
	public Dependent updateDependent(@PathVariable Integer enrolee_id, @PathVariable Integer dependent_id) {
		Enrolee enrolee = enrolmentService.findById(enrolee_id);
		List<Dependent> deps = enrolee.getDependents();
		return deps.stream().filter(dep->dep.getDependent_id().equals(dependent_id)).findFirst().get();
	}
	
	@PostMapping(path = "/enrolees/{enrolee_id}/dependents")
	public Enrolee updateDependent(@PathVariable Integer enrolee_id, @Valid @RequestBody Dependent dependent) {
		Enrolee enrolee = enrolmentService.findById(enrolee_id);
		List<Dependent> deps = enrolee.getDependents();
		if(CollectionUtils.isEmpty(deps)) {
			deps = new ArrayList<>();
		}
		deps.add(dependent);
		return enrolmentService.update(enrolee);
	}
	
	@DeleteMapping(path = "/enrolees/{enrolee_id}/dependents/{dependent_id}")
	public Enrolee deleteDependent(@PathVariable Integer enrolee_id, @PathVariable Integer dependent_id) {
		Enrolee enrolee = enrolmentService.findById(enrolee_id);
		List<Dependent> deps = enrolee.getDependents();
		deps = deps.stream().filter(dep -> dep.getDependent_id()!= dependent_id).collect(Collectors.toList());
		enrolee.setDependents(deps);
		return enrolmentService.update(enrolee);
	}
	
	@PutMapping(path = "/enrolees/{enrolee_id}/dependents/{dependent_id}")
	public Enrolee deleteDependent( @PathVariable Integer enrolee_id,  @PathVariable Integer dependent_id,  @Valid @RequestBody Dependent dependent) {
		Enrolee enrolee = enrolmentService.findById(enrolee_id);
		List<Dependent> deps = enrolee.getDependents();
		Dependent existingDependent = deps.stream().filter(dep->dep.getDependent_id().equals(dependent_id)).findFirst().get();
		existingDependent.setName(dependent.getName());
		existingDependent.setBirthDate(dependent.getBirthDate());
		return enrolmentService.update(enrolee);
	}
}
