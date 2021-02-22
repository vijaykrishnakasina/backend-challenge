package com.demo.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Dependent {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Integer dependent_id;
	
		
	@NotBlank
	String name;
	
	@NotNull
	@JsonFormat(pattern="yyyy/MM/dd")
	Date birthDate;
}
