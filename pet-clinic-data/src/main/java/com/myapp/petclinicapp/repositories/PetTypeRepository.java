package com.myapp.petclinicapp.repositories;

import com.myapp.petclinicapp.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
