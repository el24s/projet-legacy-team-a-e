package org.springframework.samples.petclinic.model;

import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTests {
    private Owner owner;

    @BeforeEach
    void setup() {
        owner = new Owner();
        Pet pet = new Pet();
        pet.setName("Bob");
        owner.addPet(pet);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bob", "BOB", "bob", "bOb"})
    void shouldReturnPet(String expected) {
        // Act
        Pet foundPet = owner.getPet(expected);

        // Assert
        assertAll("test Owner.getPet",
            () -> assertNotNull(foundPet),
            () -> assertEquals("Bob", foundPet.getName())
        );
    }

    @Test
    void shouldBeNull() {
        assertNull(owner.getPet("None"));
    }

    @Test
    void shouldThrowExceptionMessage() {
        String bait = null;
        NullPointerException exception = assertThrows(NullPointerException.class,
            () -> owner.getPet(bait));
        assertNotNull(exception.getMessage());
    }
}
