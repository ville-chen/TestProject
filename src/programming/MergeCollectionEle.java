package programming;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by admin on 2017/9/1.
 * 合并集合中满足条件元素的某个属性
 */
public class MergeCollectionEle {

    public static void main(String[] args) {
        List<Employee> purchaseSkuDtoList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            purchaseSkuDtoList.add(new Employee("张三" + i, 100));
            purchaseSkuDtoList.add(new Employee("张三" + i, 80));
            purchaseSkuDtoList.add(new Employee("张三" + i, 50));
            purchaseSkuDtoList.add(new Employee("李四" + i, 70));
            purchaseSkuDtoList.add(new Employee("李四" + i, 60));
            purchaseSkuDtoList.add(new Employee("王五" + i, 77));
            purchaseSkuDtoList.add(new Employee("赵柳" + i, 99));
        }
        Set<Employee> purchaseSkuDtoSet = new TreeSet<>(Comparator.comparing(Employee::getName));
        purchaseSkuDtoSet.addAll(purchaseSkuDtoList);
        for(Employee employee : purchaseSkuDtoList) {
            if (purchaseSkuDtoSet.stream().noneMatch(e -> e == employee)) {
                purchaseSkuDtoSet.stream().filter(e -> e.getName().equals(employee.getName())).forEach(e -> {
                    e.setSalaryOfMonth(e.getSalaryOfMonth() + employee.getSalaryOfMonth());
                });
            }
        }
        purchaseSkuDtoList = new ArrayList<>(purchaseSkuDtoSet);
    }
}

@Data
class Employee {
    String name;
    double salaryOfMonth;

    public Employee() {
    }

    public Employee(String name, double salaryOfMonth) {
        this.name = name;
        this.salaryOfMonth = salaryOfMonth;
    }
}
