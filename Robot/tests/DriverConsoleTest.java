import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class DriverConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach /* for console output testing */ public void setUpStreams() {
        System.setOut(new PrintStream(outContent)); System.setErr(new PrintStream(errContent));
    }

    @Test public void testDriverOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); System.setOut(new PrintStream(baos));
        Driver bob = new Driver("Vin Diesel",4999);
        bob.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
        assertEquals("Driver number valid", linesOfOutput[0]);

    }   @Test public void testDriverNotOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Driver bob = new Driver("Vin Diesel",4999543);
        bob.checkNumberValid();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.getProperty("line.separator"));
        assertEquals("Error Driver number not valid", linesOfOutput[0]);
    }
    @AfterEach /* for console output testing */
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}