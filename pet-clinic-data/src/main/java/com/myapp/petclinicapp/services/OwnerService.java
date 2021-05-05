package com.myapp.petclinicapp.services;

import com.myapp.petclinicapp.model.Owner;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);
}
