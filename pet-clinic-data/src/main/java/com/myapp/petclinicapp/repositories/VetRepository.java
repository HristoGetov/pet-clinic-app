package com.myapp.petclinicapp.repositories;

import com.myapp.petclinicapp.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
