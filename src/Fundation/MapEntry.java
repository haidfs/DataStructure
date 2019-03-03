package Fundation;

import java.util.*;

public class MapEntry {
    public static void main(String[] args) {
        //create an hash map
        HashMap hm = new HashMap();
        hm.put("Zara", new Double(3434.34));
        hm.put("Mahnaz", new Double(123.22));
        hm.put("Ayan", new Double(1378.00));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));


        //由Map接口中声明的entrySet()方法返回一个包含映射条目的集。每个组元素都是一个Map.Entry对象
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        //展示元素
        while (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey()+": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        //往Zara的账户里面增加1000
        //double balance = ((Double)hm.get("Zara")).doubleValue();
        double balance = ((Double)hm.get("Zara"));
        hm.put("Zara", new Double(balance+1000));
        System.out.println("Zara's new balance is : "+hm.get("Zara"));
    }
}