package com.zeroecks.core;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

public class PlayersTest extends BaseTest {

    @Test
    public void testCreate() {
        final Map<String, Object> attributes = new ImmutableMap.Builder<String, Object>()
                .put("handle", "123451234512345")
                .put("name", "Guy Dude")
                .put("human", true)
                .build();

        final Map<String, Object> data = ImmutableMap.of("data",
                ImmutableMap.of("type", "players", "attributes", attributes));

        final ValidatableResponse response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("/api/players")
                .then()
                .statusCode(CREATED.value());

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(response.extract().body().as(Map.class)));
    }
}
