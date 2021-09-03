package com.myapp.petclinicapp.repositories;

import com.myapp.petclinicapp.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
