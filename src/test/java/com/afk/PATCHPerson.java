package com.afk;

import com.afk.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class PATCHPerson {private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init(){personServiceHelper= new PersonServiceHelper();}

    @Test
    public void testPatchPerson() throws Exception {
String id =personServiceHelper.patchPerson(6).jsonPath().getString("id");
        System.out.println("id = " + id);
        assertNotNull(id, "Updated");
    }

}
