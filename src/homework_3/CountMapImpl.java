package homework_3;

import ru.sbt.generics.CountMap;

import java.util.*;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> arr;
    public CountMapImpl() {
        arr = new HashMap<>();
    }

    public void add(T o){
        arr.put(o, arr.getOrDefault(o, 0) + 1);
    }

    public int getCount(T o){
        return arr.getOrDefault(o, 0);
    }

    public int remove(T o){
        int res = arr.get(o);
        arr.remove(o);
        return res;
    }

    public int size(){
        return arr.size();
    }

    public void addAll(CountMap source){
        Map<T, Integer> tmp = source.toMap();
        for (Map.Entry<T,Integer> val : tmp.entrySet()) {
            arr.put(val.getKey(), arr.getOrDefault(val.getKey(),0) + val.getValue());
        }
    }

    public Map toMap(){
        return arr;
    }

    public void toMap(Map destination){
        destination.putAll(arr);
    }

    public static void main(String[] args) {
        CountMapImpl<Integer> cm = new CountMapImpl<>();
        cm.add(10);
        cm.add(10);
        cm.add(10);
        cm.add(5);
        cm.add(6);
        cm.add(5);
        cm.add(10);

        System.out.println("size " + cm.size());
        System.out.println(cm.getCount(10));
        System.out.println(cm.getCount(5));
        System.out.println(cm.getCount(6));
        System.out.println(cm.remove(10));
        System.out.println("size " + cm.size());

        CountMapImpl<Integer> cm2 = new CountMapImpl<>();
        cm.toMap(cm2.toMap());

        System.out.println("cm size= " + cm.size() + "    " + "cm2 size= " + cm2.size());
        System.out.println(cm.remove(5));
        System.out.println("cm size= " + cm.size() + "    " + "cm2 size= " + cm2.size());
    }
}
