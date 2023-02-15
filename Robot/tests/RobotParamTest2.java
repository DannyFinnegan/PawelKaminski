import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RobotParamTest2 {
    private String expected;
    private double price;

    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile2.csv", numLinesToSkip = 1)
    void testcheckageAll( int age, double price) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(price, buddy.checkCost() );
    }

}