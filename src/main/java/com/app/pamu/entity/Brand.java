package com.app.pamu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "brand_tab")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="code")
	private String code;
	
	@Column(name ="tagLine")
	private String tagLine;
	
	@Column(name ="imageBrand")
	private String imageBrand;
	
	@Column(name ="note")
	private String note;
	
}
