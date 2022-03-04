package com.app.demo.suite1;

import com.add.demo.UserRepository;
import com.add.demo.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    private static List<String> names;

    @BeforeAll
    public static void setup() {
        names = new ArrayList<>();
    }

    @AfterAll
    public static void tearDown() {
        names = null;
    }

    @BeforeEach
    public void init() {
        names.add("user1");
        names.add("user2");
    }

    @AfterEach
    public void close() {
        names.clear();
    }

    @Test
    @DisplayName("getUserByIdForGivenInputIsOne")
    @Order(1)
    void getUsers() {
       assertAll(()-> {
           assertEquals("user1", names.get(0));
           assertEquals("user2", names.get(1));
       });
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1})
    //@CsvSource({"apple,1","2","3"}) set the param accordingly
    void getUserByIdForGivenInputFromDataSet(int index) {
        assertTimeout(ofSeconds(10), ()-> assertEquals(true, names.get(index).contains("user")));
    }

    @Test
    @DisplayName("another valid input")
    @Disabled
    void getUserByIdForGivenInputIsValidOne() {
        assertTrue(names.contains("user"));
    }
}