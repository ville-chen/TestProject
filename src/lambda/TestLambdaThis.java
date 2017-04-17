package lambda;

/**
 * Created by admin on 2017/3/31.
 */
public class TestLambdaThis {

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());
    Runnable r3 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }

        @Override
        public String toString() {
            return "hw"; //匿名内部类会调用内部类的toString();
            // 内部类中通过继承得到的成员（包括来自 Object 的方法）可能会把外部类的成员掩盖（shadow）
            //whereas:lambda 表达式函数体里面的变量和它外部环境的变量具有相同的语义（也包括 lambda 表达式的形式参数）
            //基于词法作用域的理念，lambda 表达式不可以掩盖任何其所在上下文中的局部变量，它的行为和那些拥有参数的控制流结构（例如 for 循环和 catch 从句）一致
        }
    };

    public String toString() {
        return "Hello, world";
    }

    public static void main(String... args) {
        new TestLambdaThis().r1.run();
        new TestLambdaThis().r2.run();
        new TestLambdaThis().r3.run();
    }

}
