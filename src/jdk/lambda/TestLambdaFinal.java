package jdk.lambda;

import java.util.ArrayList;

/**
 * Created by admin on 2017/3/31.
 */
public class TestLambdaFinal {
    public static void main(String[] args) {
        ArrayList<BookShelf> list = new ArrayList<>();
        int sum = 0;
        //situation1:
        // list.forEach(shelf -> sum+=shelf.size());

        //situation2:
        //sum++;
        list.forEach(shelf -> System.out.println(sum+shelf.size()));

        //situation3:可以使用规定函数max,min,sum,reduce
        int sum2 = list.stream()
                .mapToInt(e -> e.size())
                .reduce(0, (x, y) -> x + y);

    }
}

class BookShelf {
    Integer size;

    Integer size() {
        return this.size;
    }
}
