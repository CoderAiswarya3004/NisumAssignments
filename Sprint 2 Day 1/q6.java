import java.util.function.Function;
import java.util.function.BiFunction;

public class FunctionVsBiFunction {
    public static void main(String[] args) {
        Function<Integer, String> func = num -> "Number: " + num;
        System.out.println(func.apply(10)); 

        BiFunction<Integer, Integer, Integer> biFunc = (a, b) -> a + b;
        System.out.println(biFunc.apply(5, 7));
    }
}
