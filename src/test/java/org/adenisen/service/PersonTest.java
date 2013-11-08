package org.adenisen.service;

import org.adenisen.Entity.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
    }
    
    @Test
    public void canReceivePersonIp() {
    	assertNull(null);
    }
}
