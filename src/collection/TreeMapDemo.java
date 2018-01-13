package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/***
 * Map接口: 通过提供一种映射关系,让其中的元素能够以键值对(key,value)的方式进行存储;
 * 在这种情况下,元素都能够通过键key快速的查找到对应的值value;
 * Map中的键值对以Entry类型的对象实例存在;
 * Map中Key不会重复,value可以重复,key和value都可以是任意类型;
 *
 */
public class TreeMapDemo {
	public static void main(String[] args) {
		/*
		 * Map实现类:
		 *     HashMap: 是基于哈希表的Map接口的非同步实现,允许使用null键null值,该集合是线程不同步的,效率高
		 *     TreeMap: 底层是红黑二叉树数据结构,不允许使用null键null值,该集合是线程不同步的,可以用于给map集合中的键进行排序
		 */
//		HashMap对象判断键是否重复: HashMap底层是哈希表(HashTable),而哈希表是通过hashCode()方法和equals()来判断键是否重复的
		TreeMap<Person, Integer> map = new TreeMap<>();
		HashMap<Person, Integer> map2 = new HashMap<>();

		map.put(new Person("zhangsan", 16), 6000);
		map.put(new Person("zhaoliu", 17), 9000);
		map.put(new Person("lisi", 17), 10000);
		map.put(new Person("sunqi", 26), 7500);
		map.put(new Person("wangwu", 19), 9000);
		
		Collection<Integer> list = map.values();
		/*for (Integer i : list) {
			System.out.println(i);
		}*/
		
		Person p = new Person();
		map2.put(p, null);
		map2.put(p, 9000);
		

		// 获取指定键值对的值，如果不存在，则返回null
		// System.out.println(map2.get(p));

		// Map对象的遍历方式一：
		for (Map.Entry<Person, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "," + entry.getValue());
		}
		
		
		// Map对象的遍历方式二：
		/*for (Person p: map.keySet()) {
			System.out.println(p + "," + map.get(p));
		}*/
	}
}
