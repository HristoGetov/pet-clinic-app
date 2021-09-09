package com.myapp.petclinicapp.services.springdatajpa;

import com.myapp.petclinicapp.model.Owner;
import com.myapp.petclinicapp.repositories.OwnerRepository;
import com.myapp.petclinicapp.repositories.PetRepository;
import com.myapp.petclinicapp.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;
    String lastName = "Smith";

    @BeforeEach
    void setUp() {
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(lastName);

    }

    @Test
    void findAll() {

        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        owner1.setId(1L);
        owner2.setId(2L);

        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());

    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner =ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner =ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        //default times is 1, but it can be specified more times for verify() to be executed
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner smith = ownerSDJpaService.findByLastName(lastName);
        assertEquals(lastName,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}