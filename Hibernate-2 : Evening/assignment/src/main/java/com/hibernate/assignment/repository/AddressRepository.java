package com.hibernate.assignment.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hibernate.assignment.Address;

@Repository
@Transactional
public class AddressRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void addAddress(Address address) {
		entityManager.persist(address);
	}
	
	public Address getAddressbyId(Integer id) {
		return entityManager.find(Address.class,id);
	}
	
	public Address getAddressbyLocation(String location) {
		return entityManager.find(Address.class,location);
	}
	
	public Address getAddressbyCity(String city) {
		return entityManager.find(Address.class,city);
	}
	
	public Address getAddressbyState(String state) {
		return entityManager.find(Address.class,state);
	}
	
	public Address getAddressbyPincode(Integer pincode) {
		return entityManager.find(Address.class,pincode);
	}
	
}
