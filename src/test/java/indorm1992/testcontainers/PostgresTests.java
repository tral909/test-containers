package indorm1992.testcontainers;

import indorm1992.testcontainers.repository.PostRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostgresTests {

    @LocalServerPort
    private Integer port;

    @Container
    @ServiceConnection
    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15.1-alpine"
    );

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost:" + port;
        postRepository.deleteAll();
    }

    @Test
    public void test() {

    }

}
