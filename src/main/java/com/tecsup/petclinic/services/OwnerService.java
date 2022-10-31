package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;


public interface OwnerService {
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * 
	 */

}
