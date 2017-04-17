package lambda;

import java.util.function.Supplier;

public class TestLambdaInLambda {

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hi");
        Supplier<Runnable> c = () -> r;

        Supplier<Runnable> c2 = () -> () -> System.out.println("hi");
    }
}
