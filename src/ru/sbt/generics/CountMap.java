package ru.sbt.generics;

import java.util.List;
import java.util.Map;

public interface CountMap<T> {
    void add(T o);

    int getCount(T o);

    //current count
    int remove(T o);

    int size();

    void addAll(CountMap source);

    Map toMap();

    void toMap(Map destination);

    public static void main(String[] args) {
        CountMap map = null;

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
/*
        int count = map.getCount(5); // 2
        int count = map.getCount(6); // 1
        int count = map.getCount(10); // 3*/
    }
}
