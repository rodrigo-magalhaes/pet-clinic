package org.spring.petclinic.services;

import org.spring.petclinic.model.Owner;

public interface OwnerService extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
