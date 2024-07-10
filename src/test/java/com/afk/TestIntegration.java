package com.afk;

import com.afk.helpers.PersonServiceHelper;
import com.afk.model.Person;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestIntegration {
    private PersonServiceHelper personServiceHelper;

    // Initialize PersonServiceHelper before running the tests
    @BeforeClass
    @Description("Initialize PersonServiceHelper before running the tests")
    public void init() {
        personServiceHelper = new PersonServiceHelper();
    }

    // Test to verify that getting all persons returns a non-null and non-empty list
    @Test(priority = 0)
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that getting all persons returns a non-null and non-empty list")
    public void testGetAllPerson() throws Exception {
        List<Person> personList = PersonServiceHelper.getAllPerson();
        assertNotNull(personList, "Person List is not empty");
        assertFalse(personList.isEmpty(), "Person List is not True");
    }

    // Test to verify that creating a new person returns a valid non-null id
    @Test(priority = 1)
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that creating a new person returns a valid non-null id")
    public void testPostCreatePerson() throws Exception {
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println("id = " + id);
        assertNotNull(id, "Person id is not null");
    }

    // Test to verify the retrieval of a single person by id
    @Test(priority = 2)
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify the retrieval of a single person by id")
    public void testGetSinglePerson() {
        personServiceHelper.getSinglePerson(7);
    }

    // Test to verify that updating a person returns a valid non-null id
    @Test(priority = 3)
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify that updating a person returns a valid non-null id")
    public void testPatchPerson() throws Exception {
        String id = personServiceHelper.patchPerson(7).jsonPath().getString("id");
        System.out.println("id = " + id);
        assertNotNull(id, "Updated");
    }

    // Test to verify the deletion of a person by id
    @Test(priority = 4)
    @Owner("AFK")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test to verify the deletion of a person by id")
    public void testDeletePerson() {
        personServiceHelper.deletePerson(7);
    }
}
