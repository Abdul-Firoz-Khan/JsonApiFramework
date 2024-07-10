package com.afk;

import com.afk.helpers.PersonServiceHelper;
import com.afk.model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class GETAllPerson {

    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    @Test
    public void testGetAllPerson() throws Exception {
        List<Person> personList = PersonServiceHelper.getAllPerson();
        assertNotNull(personList, "Person List is not empty");
        assertFalse(personList.isEmpty(), "Person List is not True");

    }
}
