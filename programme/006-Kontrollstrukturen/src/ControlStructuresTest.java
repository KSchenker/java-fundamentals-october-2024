import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControlStructuresTest {
    @Test
    void isLeapYear() {
        Assertions.assertTrue(ControlStructures.isLeapYear(2000));
        Assertions.assertFalse(ControlStructures.isLeapYear(2001));
        Assertions.assertTrue(ControlStructures.isLeapYear(1600));
        Assertions.assertFalse(ControlStructures.isLeapYear(1700));
    }
}