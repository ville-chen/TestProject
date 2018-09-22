package jdk.collection;

import java.util.HashMap;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<Person, Integer> map = new HashMap<>();

		map.put(new Person("zhangsan", 16), 6000);
		map.put(new Person("zhangsan", 16), 6000);
		map.put(new Person("lisi", 17), 10000);
		map.put(new Person("sunqi", 26), 7500);
		map.put(new Person("wangwu", 19), 9000);

		
		for (Person p : map.keySet()) {
			System.out.println(p + "," + map.get(p));
		}

        //System.out.println("s".compareTo("l"));

	}
}
