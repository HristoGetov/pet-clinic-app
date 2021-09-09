package com.myapp.petclinicapp.services.map;

import com.myapp.petclinicapp.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1,ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void savedExistingId() {

        Long id = 2L;
        Owner owner2 = new Owner();
        owner2.setId(id);
        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner owner = new Owner();
        Owner savedOwner = ownerServiceMap.save(owner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId() );
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {

        Owner ownerSmith = ownerServiceMap.findByLastName(lastName);
        assertNotNull(ownerSmith);
        assertEquals(ownerId,ownerSmith.getId());

    }

    @Test
    void findByLastNameNotFound() {

        Owner ownerSmith = ownerServiceMap.findByLastName("something");
        assertNull(ownerSmith);

    }
}