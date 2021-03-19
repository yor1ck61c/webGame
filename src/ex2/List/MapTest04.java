/*
package ex2.List;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cc.contruct05.model.Dog;

public class MapTest04 {
    public static void main(String[] args) {
        Map countries = new HashMap();
        //1.添加
        countries.put("CN", "中华人民共和国");
        countries.put("RU", "俄罗斯联邦");
        countries.put("FR", "法兰西共和国");
        countries.put("US", "美利坚合众国");
        
        countries.put("1", new Dog("旺财",11));
        countries.put(new Dog("二狗子",2), "狗中的战斗机");
        //2.集合大小
        System.out.println("map集合大小："+countries.size());
        //3.是否包含  键或者值  注意：自己定义的类需要重写hashcode和equals方法
        System.out.println(countries.containsKey(new Dog("二狗子",2) ));
        System.out.println(countries.containsValue(new Dog("旺财",11)));
        //4.删除  根据键删除值    注意：自己定义的类需要重写hashcode和equals方法
      // countries.clear();//清空集合
       //countries.isEmpty()//判断集合是否非空
        //countries.remove(new Dog("二狗子",2) );
        //5.替换  根据键 替换值
        countries.replace(new Dog("二狗子",2) , "战斗机中的狗");
        
       
        //查询
        */
/*
         * 1.先查键
         * keySet();取出map中所有的键，放到set集合中，然后返回这个集合
         * get()      根据key，来获取该key所对应的值
         *//*

        System.out.println("=======map第1中查询方式：1.先查键=============");
        Set set  = countries.keySet();
        for(Object key :set) {
            System.out.println(key+"------->"+countries.get(key));
        }
        System.out.println("=======map第2中查询方式：只查值=============");
        Collection collection = countries.values();
        for(Object obj :collection) {
            System.out.println(obj);
        }
        //key和entry---->entry
        System.out.println("=======map第3中查询方式：1.查entry=============");
        Set enSet = countries.entrySet();
        for (Object obj : enSet) {
            //System.out.println(obj);
            
            Entry entry  =( Entry)obj;
            System.out.println(entry.getKey()+"："+entry.getValue());
        }
        
        
        
        
        
        
        
      
    }
}
*/
