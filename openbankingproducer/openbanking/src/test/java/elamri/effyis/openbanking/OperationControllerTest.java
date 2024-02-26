package elamri.effyis.openbanking;

import elamri.effyis.openbanking.entity.Client;
//import io.restassured.http.ContentType;
import elamri.effyis.openbanking.entity.Compte;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
@SpringBootTest(
        classes = OpenbankingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:tc:postgresql:11-alpine:///ms1" }
)public class OperationControllerTest {

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


    @Test
    void shouldGetAllCustomers() {
        List<Client> customers = List.of(
                new Client(0, "John", "john@mail.com"),
                new Client(0, "Dennis", "dennis@mail.com")
        );
     //   compte.saveAll(customers);
//
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("/api/customers")
//                .then()
//                .statusCode(200)
//                .body(".", hasSize(2));
    }



}
