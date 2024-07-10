package com.afk.helpers;

import com.afk.constants.Endpoints;
import com.afk.model.Person;
import com.afk.utils.ConfigManger;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import io.qameta.allure.Step;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PersonServiceHelper {
    private static final String BASE_URL = ConfigManger.getInstance().getString("baseurl");
    private static final String PORT = ConfigManger.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Step("Get all persons")
    public static List<Person> getAllPerson() throws Exception {
        Response response = RestAssured.given()
                .log().all()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_PERSON)
                .andReturn();

        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
        String jsonResponse = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Person>> typeRef = new TypeReference<List<Person>>() {
        };
        List<Person> personList = objectMapper.readValue(jsonResponse, typeRef);
        return personList;
    }

    @Step("Create a new person")
    public Response createPerson() {
        Person person = new Person();
        person.setId("7");
        person.setFirstName("Mohan");
        person.setLastName("Bagaan");
        person.setAge(30);
        person.setPhoneNumbers("9929928922");
        person.setAddress("jakdsjA JSAHDSAK KajdkA");

        Response response = RestAssured.given().contentType(ContentType.JSON).when()
                .body(person).post(Endpoints.CREATE_PERSON)
                .andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Created");
        return response;
    }

    @Step("Update person with id {id}")
    public Response patchPerson(Integer id) {
        Person person = new Person();
        person.setFirstName("Dev");
        person.setLastName("Batista");
        person.setAge(50);
        person.setPhoneNumbers("89832993");
        person.setAddress("New York USA");

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParams("id", id).when().body(person).patch(Endpoints.UPDATE_PERSON).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
        return response;
    }

    @Step("Delete person with id {id}")
    public Response deletePerson(Integer id) {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParams("id", id)
                .log().all()
                .when().delete(Endpoints.DELETE_PERSON).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
        return response;
    }

    @Step("Get single person with id {id}")
    public Response getSinglePerson(Integer id) {
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParams("id", id)
                .log().all()
                .when().get(Endpoints.GET_SINGLE_PERSON).andReturn();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
        return response;
    }
}