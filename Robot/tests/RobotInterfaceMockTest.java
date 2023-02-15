import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RobotInterfaceMockTest {

    /* create Mock to create a mock of the RobotFee class */
    @Mock
    RobotFees mockRobotFees;

    /* Create an instance of the class that will call the mock */

    @InjectMocks
    Robot instance = new Robot("robbie", 5);

    @Test
    public void InterfaceTest() {
        System.out.println("getTotalCost");

        /* Set up the expected values and return values. */
        Mockito.when(mockRobotFees.getCost(5)).thenReturn(100.00);
        double expResult = 10100.00;
        double result = instance.getTotalCost(mockRobotFees);

        System.out.println("the result is " + result);

        assertEquals(expResult, result, 0.005); /* verify that the mock was used correctly */
        Mockito.verify(mockRobotFees).getCost(5);
    }
}