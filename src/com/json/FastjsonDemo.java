package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.*;
import java.util.Map.Entry;

/**
 * fastjson解析json案例
 * @author Coder
 * 2016年9月1日下午12:19:29
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        SerializeConfig cfg=new SerializeConfig();
        cfg.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        //1.Bean
        /*User user1 = new User(1000, "张三", new Date());
		bean_json(user1, cfg);*/

        //2.List
        List<User> list = new ArrayList<User>();
        User user1 = new User(1000, "张三", new Date());
        User user2 = new User(1001, "李四", new Date());
        User user3 = new User(1002, "王五", new Date());
        list.add(user1);
        list.add(user2);
        list.add(user3);
		list_json(list, cfg);

        //3.Map
        /*Map map = new HashMap();
        map.put("id", 1001);
        map.put("name", "张三");
        map.put("date", new Date());
        map_json(map, cfg);*/

        //4.Map<String, User>
        /*Map<String, User> map2 = new HashMap<>();
        map2.put("user1", user1);
        map2.put("user2", user2);
        map2.put("user3", user3);
        map2_json(map2, cfg);*/

    }

    /**
     * fastjson解析存放多个bean的map
     * @param map
     * @param cfg
     */
    private static void map2_json(Map<String, User> map, SerializeConfig cfg) {
        //存放多个javabean的map ——> json字符串
        String jsonstr = JSON.toJSONString(map, cfg);
        System.out.println(jsonstr);

        // json字符串 ——> map对象
        //方法一：JSON.parseObject(jsonstr, new TypeReference<Map<String, User>>() {});
        Map<String, User> map2 = JSON.parseObject(jsonstr, new TypeReference<Map<String, User>>() {});
        Set<Entry<String, User>> set = map2.entrySet();
        for (Entry<String, User> entry : set) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue().getName());
        }

        //方式二：JSON.parseObject(jsonstr, Map.class);
		/*Map map3 = JSON.parseObject(jsonstr, Map.class);
		Set<Entry> set3 = map3.entrySet();
		for (Entry entry : set3) {
			System.out.print(entry.getKey() + " ");
			System.out.println(JSON.toJavaObject((JSON)entry.getValue(), User.class));
		}*/

    }

    /**
     * fastjson解析存放一个bean的map(来自request.getParameterMap())
     * @param map
     * @param cfg
     */
    private static void map_json(Map map, SerializeConfig cfg) {
        //存放一整个javabean信息的map ——> json字符串
        String jsonstr = JSON.toJSONString(map, cfg);
        System.out.println(jsonstr);

        //json字符串    ——> map对象
        Map map2 = JSON.parseObject(jsonstr);
        Set<Map.Entry> set = map2.entrySet();
        for (Entry entry : set) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    /**
     * fastjson解析存放javabean的list
     * @param list
     * @param cfg
     */
    private static void list_json(List<User> list, SerializeConfig cfg) {
        //存放javabean的list ——> json字符串
        String jsonstr = JSON.toJSONString(list, cfg);
        System.out.println(jsonstr);

        //json字符串  ——> 存放javabean的list
        jsonstr = null;
        List<User> list2 = JSON.parseArray(jsonstr, User.class);
        for (User user : list2) {
            System.out.println(user.getName());
        }
    }

    /**
     * fastjson解析普通javabean
     * @param user
     * @param cfg
     */
    private static void bean_json(User user, SerializeConfig cfg) {
        //javabean ——> json字符串
        //不能控制时间格式，控制的是json格式，估计用来写进文本
        //String jsonstr = JSON.toJSONString(user, true);
        //传入一个cfg参数来控制
        String jsonstr = JSON.toJSONString(user, cfg);
        System.out.println(jsonstr);

        //json字符串 ——> javabean
        User user2 = JSON.parseObject(jsonstr, User.class);
        System.out.println(user2);
    }
}
