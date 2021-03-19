package ex2.List;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PetMap {

    public static void main(String[] args) {

        Map map = new HashMap();
        Pet pet = new Pet("欧欧", "雪纳瑞");
        map.put(pet.getName(),pet.getSpecies());

        if(map.containsKey(pet.getName()) && map.containsValue(pet.getSpecies())){
            System.out.println("Map中存在指定对象，对象信息如下：");
            Set set = map.keySet();
            for (Object key: set) {
                System.out.println(map.get(key));
            }

            Collection collection = map.values();
            for (Object obj:collection) {
                System.out.println(obj);
            }

            Set entrySet = map.entrySet();
            for (Object o :
                    entrySet) {
                Map.Entry entry = (Map.Entry)o;
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }else {
            System.out.println("Map中不存在指定对象");
        }
    }
}
