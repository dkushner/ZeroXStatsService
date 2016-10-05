package com.zeroecks.core;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

public class HitsTest extends BaseTest {
    @Test
    public void testCreate() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final Map<String, Object> targetAttributes = new ImmutableMap.Builder<String, Object>()
                .put("handle", "123451234512345")
                .put("name", "Guy Dude")
                .put("human", true)
                .build();

        final Map<String, Object> targetData = ImmutableMap.of("data",
                ImmutableMap.of("type", "players", "attributes", targetAttributes));

        ValidatableResponse targetResponse = RestAssured.given()
                .contentType("application/json")
                .body(targetData)
                .when()
                .post("/api/players")
                .then()
                .statusCode(CREATED.value());

        final Map<String, Object> shooterAttributes = new ImmutableMap.Builder<String, Object>()
                .put("handle", "Fake Man")
                .put("name", "Fake Man")
                .put("human", false)
                .build();

        final Map<String, Object> shooterData = ImmutableMap.of("data",
                ImmutableMap.of("type", "players", "attributes", shooterAttributes));

        ValidatableResponse shooterResponse = RestAssured.given()
                .contentType("application/json")
                .body(shooterData)
                .when()
                .post("/api/players")
                .then()
                .statusCode(CREATED.value());

        final Map<String, Object> relationships = new ImmutableMap.Builder<String, Object>()
                .put("target", ImmutableMap.of("data",
                        ImmutableMap.of("type", "players", "id", targetResponse.extract().body().jsonPath().get("data.id"))))
                .put("shooter", ImmutableMap.of("data",
                        ImmutableMap.of("type", "players", "id", shooterResponse.extract().body().jsonPath().get("data.id"))))
                .build();

        final Map<String, Object> attributes = new ImmutableMap.Builder<String, Object>()
                .put("targetTag", "Target Tag")
                .put("targetStance", "STAND")
                .put("targetSide", "EAST")
                .put("targetPosition", ImmutableMap.of("x", 1.0, "y", 1.0, "z", 1.0))
                .put("targetAim", ImmutableMap.of("x", 1.0, "y", 1.0, "z", 1.0))
                .put("shooterTag", "Shooter Tag")
                .put("shooterStance", "PRONE")
                .put("shooterSide", "WEST")
                .put("shooterPosition", ImmutableMap.of("x", 2.0, "y", 2.0, "z", 2.0))
                .put("shooterAim", ImmutableMap.of("x", 2.0, "y", 2.0, "z", 2.0))
                .put("cause", "boomies")
                .put("impact", ImmutableMap.of("x", 3.0, "y", 3.0, "z", 3.0))
                .put("velocity", ImmutableMap.of("x", 4.0, "y", 4.0, "z", 4.0))
                .put("normal", ImmutableMap.of("x", 5.0, "y", 5.0, "z", 5.0))
                .put("float", 10.0)
                .put("type", "gunshoots")
                .put("direct", true)
                .put("limb", "flanges")
                .build();

        final Map<String, Object> data = ImmutableMap.of("data",
                ImmutableMap.of("type", "hits", "attributes", attributes, "relationships", relationships));

        final ValidatableResponse response = RestAssured.given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("/api/hits")
                .then()
                .log().everything()
                .statusCode(CREATED.value());
    }
}
