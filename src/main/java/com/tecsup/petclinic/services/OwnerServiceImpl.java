package com.tecsup.petclinic.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

import com.tecsup.petclinic.repositories.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	OwnerRepository ownerRepository;

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);
		
	}

	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	@Override
	public Iterable<Owner> findAll() {
		// TODO Auto-generated 
		return ownerRepository.findAll();
	}
}
