package com.afk;

import com.afk.helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GETSinglePerson { private PersonServiceHelper personServiceHelper;
    @BeforeClass
    public void init(){personServiceHelper= new PersonServiceHelper();}

    @Test
    public void testGetSinglePerson(){personServiceHelper.getSinglePerson(6);}
}
