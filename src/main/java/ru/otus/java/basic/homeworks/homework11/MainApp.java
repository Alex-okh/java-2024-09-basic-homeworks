package ru.otus.java.basic.homeworks.homework11;

import ru.otus.java.basic.homeworks.homework11.persondb.Person;
import ru.otus.java.basic.homeworks.homework11.persondb.PersonDataBase;
import ru.otus.java.basic.homeworks.homework11.persondb.Position;
import ru.otus.java.basic.homeworks.homework11.searchtree.SearchTreeImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
// Задание 1 - создание базы данных сотрудников
        System.out.println("--------------------Задание 1. База данных сотрудников.-----------------------");
        PersonDataBase dataBase = new PersonDataBase();
        dataBase.add(new Person("Аркадий Петрович", Position.random()));
        dataBase.add(new Person("Сергей Леонидович", Position.random()));
        dataBase.add(new Person("Вениамин Семенович", Position.random()));
        dataBase.add(new Person("Алексей Владимирович", Position.random()));
        dataBase.add(new Person("Кирилл Алексеевич", Position.random()));
        dataBase.add(new Person("Абдурахман Хоттабович", Position.random()));
        dataBase.add(new Person("Леонид Вячеславович", Position.random()));
        dataBase.add(new Person("Пётр Александрович", Position.random()));

        System.out.println("Поиск по ID 2: " + dataBase.findById(2L).toString());
        System.out.println("Проверим работник ли по ID 3: " + dataBase.isEmployee(3L));

// Задание 2 - Методы сортировки массивов:
        System.out.println("--------------------Задание 2. Сортировка разными методами--------------------");
        int[] testarray = SortUtils.generateRandomArray(15000, -1000, 1000);

        int[] testTreeArray = SortUtils.generateRandomArray(50, 0, 50);
        SortUtils.quickSort(testTreeArray, 0, testTreeArray.length - 1);
        List<Comparable> testTree = new ArrayList<>(testTreeArray.length);
        for (int j : testTreeArray) {
            testTree.add(j);
        }

        int[] sorted1 = Arrays.copyOf(testarray, testarray.length);
        int[] sorted2 = Arrays.copyOf(testarray, testarray.length);

        System.out.println("Засечем время работы по случайному массиву....");
        Timer.stamp();
        SortUtils.bubbleSort(sorted1);
        System.out.println("Bubble time: " + Timer.stop() + " ms");
        Timer.stamp();
        SortUtils.quickSort(sorted2, 0, sorted2.length - 1);
        System.out.println("Quicksort time: " + Timer.stop() + " ms");
        System.out.println();
        System.out.println("Засечем время работы по сортированному массиву....");
        Timer.stamp();
        SortUtils.bubbleSort(sorted1);
        System.out.println("Bubble time: " + Timer.stop() + " ms");
        Timer.stamp();
        SortUtils.quickSort(sorted2, 0, sorted2.length - 1);
        System.out.println("Quicksort time: " + Timer.stop() + " ms");


// Задание 3
        System.out.println("--------------------Задание 3. Построение дерева.-----------------------------");
        System.out.println("--------------------проверим работу на прямой вставке-------------------------");

        SearchTreeImpl tree1 = new SearchTreeImpl();
        tree1.insert(31);
        tree1.insert(20);
        tree1.insert(30);
        tree1.insert(35);
        tree1.insert(45);

        System.out.println(tree1.find(30));
        System.out.println(tree1.find(32));

        System.out.println("--------------------проверим работу на массиве чисел--------------------------");
        SearchTreeImpl tree2 = new SearchTreeImpl();
        tree2.insertAll(testTree);

        System.out.println("Исходный массив:" + Arrays.toString(testTreeArray));
        System.out.println("Возвращенный массив: " + tree2.getSortedList().toString());

        System.out.println("--------------------проверим работу на строках--------------------------------");
        SearchTreeImpl tree3 = new SearchTreeImpl();
        String[] strarray = {"Барсик", "Васька", "Мурзик", "Леопольд", "Лиза", "Шуша", "Симба", "Тайгер", "Томас", "Снежок", "Белка", "Пушок", "Мишка", "Черныш", "Барс", "Багира", "Карамель", "Рыжик", "Маркиз", "Дуся", "Вава", "Зевс", "Матильда", "Муся", "Даша", "Кузя", "Арчи", "Юлия", "Коко", "Марсик", "Бельчонок", "Феликс", "Джек", "Каспер", "Граф", "Пыжик", "Анфиса", "Жорик", "Вилли", "Бельченок", "Слава", "Ришард", "Забияка", "Марго", "Мэй", "Йорик", "Хари", "Базилио", "Миранда", "Бублик", "Кира", "Финик", "Шпунтик", "Мими", "Лея", "Абрикос", "Байрон", "Агата", "Хлоя", "Рокки", "Люк"};

        List<Comparable> testTree3 = Arrays.asList(strarray);
        testTree3.sort(Comparator.naturalOrder());
        tree3.insertAll(testTree3);

        System.out.println("Возвращенный массив: " + tree3.getSortedList().toString());
    }

}

