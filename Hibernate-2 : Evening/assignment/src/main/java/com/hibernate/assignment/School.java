package com.hibernate.assignment;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set<Quiz> quizes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Quiz> getQuizes() {
		return quizes;
	}

	public void setQuizes(Set<Quiz> quizes) {
		this.quizes = quizes;
	}

}
