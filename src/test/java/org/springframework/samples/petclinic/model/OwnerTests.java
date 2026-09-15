package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.i18n.LocaleContextHolder;

import jakarta.validation.Validator;


public class OwnerTests {

    Owner owner;

    @BeforeEach 
    public void setup(){
        owner = new Owner();
        Pet pet = new Pet();
        pet.setName("pat");
        owner.addPet(pet);          
    }

    @ParameterizedTest
    @ValueSource(strings= {"PAT","pat", "PaT", "pAT"})
    // @Test
    public void verifierExistancePetDansOwner(String nom) {
        // act
        Pet pat = owner.getPet(nom);

        // assert
        assertNotNull(pat);
        assertEquals("pat", pat.getName());
        
    }

    @Test
    public void verifierPetNExistePasDansOwner() {
        // act
        Pet pat = owner.getPet("");
        //assert
        assertNull(pat);
    }
    // beforeeach + cycle de vie



    // mock 
}
