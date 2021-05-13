package first;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests for MyMath.cos")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyMathTest {

    private static final double accuracy = 0.001;

    @Test
    @DisplayName("тест для обычных чисел")
    public void testRandomCos() {
        assertAll(
                () -> assertEquals(0.99995, MyMath.cos(0.01), MyMathTest.accuracy),
                () -> assertEquals(0.825336, MyMath.cos(0.6), MyMathTest.accuracy)
        );
    }

    @Test
    @DisplayName("тест для первой четверти тригонометрической окружности")
    public void testFirstCircleCos() {
        assertAll(
                () -> assertEquals(0.5, MyMath.cos(Math.PI / 3), MyMathTest.accuracy),
                () -> assertEquals(Math.sqrt(2)/2, MyMath.cos(Math.PI / 4), MyMathTest.accuracy),
                () -> assertEquals(Math.sqrt(3)/2, MyMath.cos(Math.PI / 6), MyMathTest.accuracy)
        );
    }

    @Test
    @DisplayName("тест для второй четверти тригонометрической окружности")
    public void testSecCircleCos() {
        assertAll(
                () -> assertEquals(0.5, MyMath.cos(5 * Math.PI / 3), MyMathTest.accuracy),
                () -> assertEquals(Math.sqrt(2)/2, MyMath.cos(7 * Math.PI / 4), MyMathTest.accuracy),
                () -> assertEquals(Math.sqrt(3)/2, MyMath.cos(11 * Math.PI / 6), MyMathTest.accuracy)
        );
    }

    @Test
    @DisplayName("тест для третьей четверти тригонометрической окружности")
    public void testThirdCircleCos() {
        assertAll(
                () -> assertEquals(-0.5, MyMath.cos(4 * Math.PI / 3), MyMathTest.accuracy),
                () -> assertEquals(-Math.sqrt(2)/2, MyMath.cos(5 * Math.PI / 4), MyMathTest.accuracy),
                () -> assertEquals(-Math.sqrt(3)/2, MyMath.cos( 7 * Math.PI / 6), MyMathTest.accuracy)
        );
    }

    @Test
    @DisplayName("тест для четвертой четверти тригонометрической окружности")
    public void testFourthCircleCos() {
        assertAll(
                () -> assertEquals(-0.5, MyMath.cos(2 * Math.PI / 3), MyMathTest.accuracy),
                () -> assertEquals(-Math.sqrt(2)/2, MyMath.cos(3 * Math.PI / 4), MyMathTest.accuracy),
                () -> assertEquals(-Math.sqrt(3)/2, MyMath.cos( 5 * Math.PI / 6), MyMathTest.accuracy)
        );
    }
}
