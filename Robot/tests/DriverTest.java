import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    Driver person = new Driver("Pawel Kaminski", 551519225);

    @Test
    public void getDriverNameTest(){
        assertEquals("Pawel Kaminski",person.getDriverName());
    }

    @Test
    public void getDriverNumTest(){
        assertEquals(551519225, person.getDriverNum());
    }

    @Test
    public void testNum_Fail(){
        assertThrows(IllegalArgumentException.class,() -> {
            Driver person2 = new Driver("",99);
        });
    }

    @Test
    public void testName_Fail(){
        assertThrows(IllegalArgumentException.class,() -> {
            Driver person3 = new Driver("",101);
        });
    }

    @Test
    public void StatusCheck(){
        assertFalse(person.check_status());
    }

    @Test
    void timeoutExceeded(){
        assertTimeout(ofMillis(1000), () -> {
            person.waitTillbanned();
        });
    }

}