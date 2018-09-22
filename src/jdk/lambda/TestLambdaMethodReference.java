package jdk.lambda;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * Created by admin on 2017/3/31.
 */
public class TestLambdaMethodReference {

    public static void main(String... args) {

        //因为函数式接口的方法参数对应于隐式方法调用时的参数，
        // 所以被引用方法签名可以通过放宽类型，装箱以及组织到参数数组中的方式对其参数进行操作，就像在调用实际方法一样：

        //静态方法引用
        //通过方法引用简化，省去参数
        Consumer<Integer> b = System::exit;
        Consumer<String[]> arrs = Arrays::sort;    // void sort(Object[] a)
        Consumer<String> s = TestLambdaMethodReference::main;  // void main(String... args)
        Runnable r = TestLambdaMethodReference::main;        // void main(String... args)

        //原式
        Consumer<Integer> b1 = i -> System.exit(i);

        Consumer<String[]> arrs1 = arr -> Arrays.sort(arr);

        Consumer<String> s1 = arr -> TestLambdaMethodReference.main(arr);
        Consumer<String> s11 = arr -> TestLambdaMethodReference.main(new String[]{arr});

        Runnable r1 = () -> TestLambdaMethodReference.main();

        //实例方法：为参数时方法引用
        Set<String> knownNames = new TreeSet<>();
        Predicate<String> isKnown = input -> knownNames.contains(input);
        Predicate<String> isKnown2 = knownNames::contains;

        //实例方法: 为对象时方法引用：
        Function<String, String> upperfier = source -> source.toUpperCase();
        Function<String, String> upperfier2 = String::toUpperCase;

        //构造方法引用
        SocketImplFactory factory = MySocketImpl::new;

        //数组的构造方法引用
        IntFunction<int[]> arrayMaker = int[]::new;
        int[] array = arrayMaker.apply(10); // 创建数组 int[10]




    }
}

class MySocketImpl extends SocketImpl {

    @Override
    protected void create(boolean stream) throws IOException {

    }

    @Override
    protected void connect(String host, int port) throws IOException {

    }

    @Override
    protected void connect(InetAddress address, int port) throws IOException {

    }

    @Override
    protected void connect(SocketAddress address, int timeout) throws IOException {

    }

    @Override
    protected void bind(InetAddress host, int port) throws IOException {

    }

    @Override
    protected void listen(int backlog) throws IOException {

    }

    @Override
    protected void accept(SocketImpl s) throws IOException {

    }

    @Override
    protected InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    protected OutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    protected int available() throws IOException {
        return 0;
    }

    @Override
    protected void close() throws IOException {

    }

    @Override
    protected void sendUrgentData(int data) throws IOException {

    }

    @Override
    public void setOption(int optID, Object value) throws SocketException {

    }

    @Override
    public Object getOption(int optID) throws SocketException {
        return null;
    }
}
