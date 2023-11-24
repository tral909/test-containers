package indorm1992.testcontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
@SpringBootTest
class PostgresTests {

}
