import org.example.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.stream.Stream;

public class CalculatorTest {
    public Calculator calc = Calculator.instance.get();

    @ParameterizedTest
    @MethodSource("methodSourcePlus")

    public void parametrizedPlusTest(int a, int b, int executed) {
        var result = calc.plus.apply(a, b);
        Assertions.assertEquals(result, executed);
    }

    public static Stream<Arguments> methodSourcePlus() {
        return Stream.of(Arguments.of(2, 3, 5), Arguments.of(4, 5, 9), Arguments.of(-2, 3, 1));
    }

    @ParameterizedTest
    @MethodSource("methodSourcePow")
    public void parametrizedPowTest(int a, int executed) {
        var result = calc.pow.apply(a);
        Assertions.assertEquals(result, executed);
    }

    public static Stream<Arguments> methodSourcePow() {
        return Stream.of(Arguments.of(2, 4),
                Arguments.of(3, 9),
                Arguments.of(5, 25));
    }

    @Test
    public void multiplyTest() {
        int a = 3;
        int b = 4;
        int executed = 12;
        var result = calc.multiply.apply(a, b);
        Assertions.assertEquals(result, executed);
    }

    @Test
    public void whenNotNullCorrect() {
        String str = calc.name;
        assertThat(str, notNullValue());
    }

    @Test
    public void stringEquals() {
        String string = calc.name;
        assertThat(string, equalTo("Darya"));
    }
}