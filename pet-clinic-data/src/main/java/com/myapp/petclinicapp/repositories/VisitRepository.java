package com.myapp.petclinicapp.repositories;

import com.myapp.petclinicapp.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
