package org.gradle;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class PersonTest {
    public Person person;

    @Before
    public void init() {
        person = new Person("Jin", "Kazama", 23,
                "LightBlue", "8001234", "70707070", "Princess", "Mi casa");
    }

    @Test
    public void canConstructAPersonWithAName() {
        assertEquals("Jin", person.getName());
    }

    @Test
    public void canConstructAPersonWithALastName() {
        assertEquals("Kazama", person.getLastName());
    }

    @Test
    public void testGetTheAgeOfAPerson() {
        assertEquals(23, person.getAge());
    }

    @Test
    public void testGetTheEyeColorOfAPerson() {
        assertEquals("LightBlue", person.getEyeColor());
    }

    @Test
    public void testGetCIOfAPerson() {
        assertEquals("8001234", person.getCi());
    }

    @Test
    public void testGetCellphoneOfAPerson() {
        assertEquals("70707070", person.getCellphone());
    }

    @Test
    public void testGetPetNameOfAPerson() {
        assertEquals("Princess", person.getPetname());
    }

    @Test
    public void testGetCompleteNameOfAPerson() {
        assertEquals("Jin Kazama", person.getCompleteName());
    }

    @Test
    public void testGetAdditionalDataOfAPerson() {
        assertEquals("23 LightBlue 8001234 70707070", person.getAddionalDataOfAperson());
    }

    @Test
    public void testGetAddressOfAPerson() {
        assertEquals("Mi casa", person.getAddress());
    }
}
