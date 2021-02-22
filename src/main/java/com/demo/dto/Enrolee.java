package com.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Enrolee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Integer enrolee_id;
	
	@NotBlank
	String name;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	Date birthDate;
	
	@NotNull
	Boolean activationStatus;
	
	String phoneNumber;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "enrolee_id")
	List<Dependent> dependents;
}
