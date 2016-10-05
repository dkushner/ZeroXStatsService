package com.zeroecks.core;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import org.hamcrest.beans.HasProperty;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

public class OperationsTest extends BaseTest {
    @Test
    public void testCreate() {
        final Map<String, Object> attributes = new ImmutableMap.Builder<String, Object>()
                .put("started", new Date())
                .put("map", "tanoa")
                .build();

        final Map<String, Object> data = ImmutableMap.of("data",
                ImmutableMap.of("type", "operations", "attributes", attributes));

        final ValidatableResponse response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("/api/operations")
                .then()
                .log().everything()
                .statusCode(CREATED.value());
    }
}
