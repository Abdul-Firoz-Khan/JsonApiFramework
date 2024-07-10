package com.afk;

import com.afk.helpers.PersonServiceHelper;
import com.afk.model.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class POSTPerson {
    private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init(){personServiceHelper= new PersonServiceHelper();}

    @Test
    public void testPostCreatePerson() throws Exception {
      String id =personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println("id = " + id);
        assertNotNull(id, "Person id is not null");

    }
}
