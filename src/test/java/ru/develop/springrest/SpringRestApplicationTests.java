package ru.develop.springrest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.develop.springrest.initialize.Postgres;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringRestApplication.class)
@AutoConfigureMockMvc
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
public abstract class SpringRestApplicationTests {

}
