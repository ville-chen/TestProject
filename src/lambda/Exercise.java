package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;
import static java.util.Comparator.comparing;

/**
 * Created by admin on 2017/3/31.
 * 匿名内部类简化练习
 */
public class Exercise {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        //匿名内部类
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person x, Person y) {
                return x.getLastName().compareTo(y.getLastName());
            }
        });
        //lambda表达式简化
        Collections.sort(people, (x, y) -> x.getLastName().compareTo(y.getLastName()));

        //使用lambda方法
        Collections.sort(people, Comparator.comparing(p -> p.getLastName()));
        //静态导包和类型推导
        sort(people, comparing(p -> p.getLastName()));
        //有一个Person类型的参数，调用了getLastName，返回了String
        sort(people, comparing(Person::getLastName));

        //使用List中的default方法sort
        people.sort(comparing(Person::getLastName));
        //降序
        people.sort(comparing(Person::getLastName).reversed());

    }
}

class Person {
    private String lastName;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
