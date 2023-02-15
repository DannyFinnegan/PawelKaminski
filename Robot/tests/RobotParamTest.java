import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RobotParamTest {
    private String expected;
    private int age;

    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile.csv", numLinesToSkip = 1)
    void testcheckageAll( int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }

}