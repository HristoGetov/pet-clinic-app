package com.myapp.petclinicapp.repositories;

import com.myapp.petclinicapp.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
