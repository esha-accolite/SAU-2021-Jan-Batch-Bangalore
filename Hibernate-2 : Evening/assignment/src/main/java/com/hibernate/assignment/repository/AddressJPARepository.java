package com.hibernate.assignment.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.assignment.Address;

public interface AddressJPARepository extends CrudRepository<Address, Integer>{
	
	public Address findAddressById(Integer id);
	
	public ArrayList<Address> findAddressGroupByCity();

}
