package homework_3;

import java.util.*;

public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static List limit(List source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<?> c1, List<?> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T val : c1) {
            if(c2.contains(val))
                return true;
        }
        return false;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> res = new ArrayList<>();
        for(T val : list){
            if( val.compareTo(min) >= 0 && val.compareTo(max) <= 0 ) {
                res.add(val);
            }
        }
        Collections.sort(res);
        return res;
    }

    //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
    // Элементы сравнивать через Comparable.
    // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        List<T> res = new ArrayList<>();
        for(T val : list){
            if( val.compareTo(min) >= 0 && val.compareTo(max) <= 0 ) {
                res.add(val);
            }
        }
        res.sort(comparator);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list  = CollectionUtils.newArrayList();
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        System.out.println(list.size() + " " + CollectionUtils.indexOf(list, 14));

        List<Integer> listint  = CollectionUtils.newArrayList();
        listint.add(102);
        listint.add(103);
        listint.add(104);
        listint.add(105);
        CollectionUtils.addAll(list, listint);
        for (Integer val: listint ) {
            System.out.println("listint " + val);
        }

        List<String> list2  = CollectionUtils.newArrayList();
        list2.add("a");
        list2.add("bb");
        list2.add("ccc");
        list2.add("dddd");
        System.out.println(list2.size() + " " + CollectionUtils.indexOf(list2, "dddd"));
        CollectionUtils.add(list2, "ee");
        System.out.println(list2.size());

        List<String> list3  = CollectionUtils.newArrayList();
        list3.add("1a");
        list3.add("bb");
        list3.add("1ccc");
        list3.add("1dddd");
        CollectionUtils.removeAll(list3, list2);
        System.out.println(CollectionUtils.containsAny(list2, list3));

        //list3 = CollectionUtils.range(list2, "c", "ffff");
        //System.out.println(list3);

        list3 = CollectionUtils.range(list2, "c", "ffff", new ComparatorMy<>());
        System.out.println(list3);

        list = CollectionUtils.range(list, 1, 13, new ComparatorMy<>());
        System.out.println(list);

        list3 = CollectionUtils.range(list2, "c", "ffff", new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }});
        System.out.println(list3);

        List<Integer> lis = CollectionUtils.newArrayList();
        lis.add(12);
        lis.add(13);
        lis.add(19);
        System.out.println(CollectionUtils.containsAll(list, lis));

        //System.out.println(lis);
        System.out.println(CollectionUtils.limit(lis, 2));
    }
}

