package com.tecsup.petclinic.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;

public class OwnerServiceImpl implements OwnerService {
	
	
	
	@Autowired
	OwnerRepository OwnerRepository;

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return OwnerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		return OwnerRepository.save(owner);
	}

}
