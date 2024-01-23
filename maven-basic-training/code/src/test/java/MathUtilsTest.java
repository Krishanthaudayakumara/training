import org.example.MathUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {
    @Test
    public void testSquare() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(25, mathUtils.square(5));
    }
}
