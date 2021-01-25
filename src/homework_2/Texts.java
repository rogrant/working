package homework_2;

import homework_2.doppak.ComparatorString;

import java.util.*;

class ArrStrIteratorRev implements Iterator<String> {
    private String[] strings;
    private int index;
    public ArrStrIteratorRev(String[] arr)
    {
        strings = arr;
        index = strings.length-1;
    }

    @Override
    public boolean hasNext(){
        return index>-1;
    }

    @Override
    public String next(){
        index -=1;
        return strings[index+1];
    }
}

public class Texts
{
    static String[] texts = {"прочитать https://habrahabr.ru/post/162017/Java собеседование. Коллекции https://habrahabr.ru/post/267389/",
                     "Коллекции в Java: о чём: многие забывают задача Имеется список парка машин Car(String model, String type).",
                     "Необходимо разбить его на списки сгруппированные по type. Пример исходного списка: Лада седан, Лада",
                     "хэтчбек, Мерседес седан, Бмв кроссовер,  Форд хэтчбек, Пежо кроссовер, Тойота седан и т.п. Плюс задачи из",
                     "презентации: Исходные данные: текстовый файл со средней длиной строки равной 10 символам (файл или",
                     "прошить текст в коде). В реализациях используйте наиболее подходящие имплементации коллекций!",
                     "Задание 1: Подсчитайте количество различных слов в файле. Задание 2: Выведите на экран список различных",
                     "слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).",
                     "Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле. Задание 4:",
                     "Выведите на экран все строки файла в обратном порядке. Задание 5: Реализуйте свой Iterator для обхода",
                     "списка в обратном порядке. Задание 6: Выведите на экран строки, номера которых задаются",
                     "пользователем в произвольном порядке. Убедится что вы знаете основные интерфейсы, реализации коллекций,",
                     "оценку сложности основных методов, контракт equals&hascode, интерфейс Comparable"};

    public static void main(String[] args) {
        // Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        for(String val : args) {
            int i = Integer.parseInt(val);
            System.out.println(texts[i-1]);
        }

        // Задание 1: Подсчитайте количество различных слов в файле.
        Map<String, Integer> words = new HashMap<>();
        for(String lines : texts) {
            String[] lines2 = lines.split(" ");
            for (String wr : lines2) {
                if(!wr.equals("")) {
                    if(words.containsKey(wr)) {
                        words.put(wr, words.get(wr)+1);
                    }else{
                        words.put(wr, 1);
                    }
                }
            }
        }
        System.out.println("количество различных слов = " + words.size());

        // Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины
        // (компаратор сначала по длине слова, потом по тексту).
        List<String> list = new ArrayList<>(words.keySet());
        Comparator cmp = new ComparatorString();
        Collections.sort(list, cmp);
        for(String val : list) {
            System.out.println(val);
        }

        // Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        for(Map.Entry<String, Integer> val : words.entrySet()) {
            System.out.println("слово \"" +val.getKey() + "\" встречается " + val.getValue() + " раз.");
        }

        // Задание 4: Выведите на экран все строки файла в обратном порядке.
        List<String> slist = List.of(texts);
        ListIterator<String> iterator = slist.listIterator(slist.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        // Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
        ArrStrIteratorRev myrr = new ArrStrIteratorRev(texts);
        while(myrr.hasNext())
        {
            System.out.println(myrr.next());
        }
    }
}
