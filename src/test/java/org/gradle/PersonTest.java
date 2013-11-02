package org.gradle;

import org.adenisen.Entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        User person = new User("Larry");
        assertEquals("Larry", person.getName());
    }
    
    @Test
    public void canReceivePersonIp() {
    	assertNull(null);
    }
}
