package elamri.effyis.openbanking;

import elamri.effyis.openbanking.entity.Client;
//import io.restassured.http.ContentType;
import elamri.effyis.openbanking.entity.Compte;
import elamri.effyis.openbanking.repository.CompteRepository;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
@SpringBootTest(
        classes = OpenbankingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:tc:postgresql:11-alpine:///ms1" }
)public class OperationControllerTest {

    @Autowired
    CompteRepository compteRepository;
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }


//    @Test
//    void shouldGetAllCustomers() {
//
//                //donner deux compte
//        Compte c1 = new Compte("123456", 1000.00, null, null); // Replace nulls with appropriate Agence and Client objects
//        Compte c2 = new Compte("789012", 2000.00, null, null); // Replace nulls with appropriate Agence and Client objects
//
//
//        compteRepository.save(c1);
//        compteRepository.save(c2);
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/operation/allcompte")
//                .then()
//                .statusCode(200)
//                .body(".", hasSize(2));
//    }



}
