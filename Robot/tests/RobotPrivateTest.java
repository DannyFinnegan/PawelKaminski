import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RobotPrivateTest { /** * Accessing a private member * Test of age member, of class Robot. */

    @Test public void testageMember() throws Exception {
    System.out.println("testageMember");
    Robot target = new Robot("robbie", 5);

    Class secretClass = target.getClass(); /*Retrieve the field age */ Field f = secretClass.getDeclaredField("age");

    /* make sure the field is accessible. */ f.setAccessible(true);

    /* get the value of the field */ System.out.println("The value in f (age) is " + f.get(target));

    int result = f.getInt(target);

    /* the string is printed if the test fails */ assertEquals( 5, result); }
    /** * Accessing a private member * Test of setAge method, of class robot. */

    @Test public void testsetAgeMethod() throws Exception { System.out.println("setAgeMethod"); /* Set up a new Robot */ Robot target = new Robot("robbie", 3); /* get the setAge method details */ Method method = Robot.class.getDeclaredMethod("setAge", int.class); /* make the method assessible */ method.setAccessible(true); /* invoke the method setAge with the value 7 */ method.invoke(target, 7); /*access the field age and check its value is set to 7*/ Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("age");

        f.setAccessible(true);

        int result = f.getInt(target);

        System.out.println("The value in f (age) is " + f.get(target));

        assertEquals( 7, result); }
}