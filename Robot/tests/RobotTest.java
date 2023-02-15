import org.junit.jupiter.api.*;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RobotTest {
    Robot buddy;

    @BeforeAll
    public void setup() {
        buddy = new Robot("buddy",19);
        System.out.println("in setup");
    }

    @BeforeEach
    void init() throws NoSuchFieldException, IllegalAccessException{
        buddy.turnoffRobot();
        System.out.println("in Before each");
    }


    @Test
    @Order(1)
    public void getNameTest(){
        assertEquals("buddy",buddy.getName());
    }

    @Test
    @Order(2)
    public void isNotWorkingTest(){
        assertFalse(buddy.isWorking());
    }

    @Test
    @Order(3)
    public void isWorkingTest(){
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    @Order(4)
    public void getWorkingMsgTest(){
        buddy.talkToRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }

    @Test
    @Order(5)
    @DisplayName("getWorkingMsgFail catch the exception")
    public void getWorkingMsgFail(){
        assertThrows(IllegalStateException.class, () -> {
            buddy.getWorkingMsg();
        });
    }

    @Test()
    @Order(6)
    public void testName_Fail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Robot chuck = new Robot("",19);
        });
    }

    @Test
    @Order(7)
    void timeoutExceeded(){
        assertTimeout(ofMillis(2000), () -> {
            buddy.waitTillWorking();
        });
    }

    @Test
    @Order(8)
    public void testAge_Fail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Robot bob = new Robot("bob",31);
        });
    }

    @AfterAll
    public static void cleanUp(){
        System.out.println("The Clean up has been complete");
    }

    @AfterEach
    public void cleanUpEach(){
        System.out.println("Test Completed");
    }

}