package ru.otus.java.basic.homeworks.homework10;

import java.util.*;

/**
 * Класс реализует хранение номеров и имен в телефонной книге.
 */
public class PhoneBook {
    private Map<Long, String> phoneBookContents;

    public PhoneBook() {
        phoneBookContents = new HashMap<>();
    }

    /**
     * Добавляет номер в телефонную книгу.
     *
     * @param phone Номер в цифровом виде, тип long, 11 разрядов
     * @param name  Имя абонента, тип String
     * @return true если номер прошел проверку и добавлен, false если номер не подходит
     */
    public boolean add(long phone, String name) {
        if (phone >= 100_000_000_000L || phone < 10_000_000_000L) {
            System.out.println("Некорректный номер телефона");
            return false;
        }
        phoneBookContents.put(phone, name);
        return true;
    }

    /**
     * Добавляет номер в телефонную книгу.
     *
     * @param phone Номер в формате String, все нечисловые символы будут удалены.
     * @param name  Имя абонента, тип String
     * @return true если номер прошел проверку и добавлен, false если номер не подходит
     */
    public boolean add(String phone, String name) {
        long number = Long.parseLong(phone.replaceAll("[^0-9]", ""));
        return add(number, name);
    }

    /**
     * Ищет номера по имени абонента.
     *
     * @param name Имя абонента для поиска, тип String
     * @return Массив найденных номеров. Если абонент не найден, то пустой массив.
     */
    public List<Long> find(String name) {
        List<Long> result = new ArrayList<>();
        for (Map.Entry<Long, String> entry : phoneBookContents.entrySet()) {
            if (entry.getValue().equals(name)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    /**
     * Проверяет наличие номера.
     *
     * @param phone Номер для поиска, тип Long
     * @return true если такой номр есть, false если не найден.
     */
    public boolean containsPhoneNumber(long phone) {
        return phoneBookContents.containsKey(phone);
    }

    /**
     * Выводит в консоль все содержимое справочника.
     */
    public void printAll() {
        System.out.println("Содержимое телефонной книги:");
        for (Map.Entry<Long, String> entry : phoneBookContents.entrySet()) {
            System.out.println(String.valueOf(entry.getKey()).replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "+$1($2)$3-$4  ") + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
            "phoneBookContents=" + phoneBookContents +
            '}';
    }
}
