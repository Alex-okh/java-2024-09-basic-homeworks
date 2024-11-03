package ru.otus.java.basic.homeworks.homework4;

public class Application {
    public static void main(String[] args) {
        User[] users = new User[10];
        users[1] = new User("Алексей", "Иванов", "Петрович", 1968, "example1@example.com");
        users[2] = new User("Сергей", "Петров", "Феофанович", 1978, "example2@example.com");
        users[3] = new User("Петр", "Сидоров", "Семенович", 1989, "example3@example.com");
        users[4] = new User("Афанасий", "Фет", "Никодимович", 1954, "example4@example.com");
        users[5] = new User("Леонид", "Куравлев", "Алексеевич", 1956, "example5@example.com");
        users[6] = new User("Артем", "Егоров", "Фаридович", 1981, "example6@example.com");
        users[7] = new User("Феофан", "Кузнецов", "Никанорович", 1979, "example7@example.com");
        users[8] = new User("Абдулла", "Ибн Хаттаб", "Олегович", 2004, "example8@example.com");
        users[9] = new User("Владимир", "Путин", "Владимирович", 1901, "example9@example.com");
        users[0] = new User("Семен", "Суходрищев", "Семенович", 1995, "example0@example.com");


        System.out.println("Задание 1. Выбираем и выводим всех пользователей, чей возраст > 40 лет.");
        for (User user : users) {
            if (user != null && user.getBirthYear() < 1984) {
                user.printInfo();
            }

        }

        System.out.println();
        System.out.println("Задание 2. Создаем коробку размера 3, цвет зеленый. ");
        Box box = new Box(3, "зеленый");
        box.printinfo();

        box.repaint("красный");
        box.putContains("Вотка");
        box.printinfo();

        box.open();
        box.putContains("Вотка");
        box.close();
        box.printinfo();

        String hands = box.getContains();
        System.out.println("В руках " + hands);

        box.open();
        hands = box.getContains();
        System.out.println("В руках " + hands);
        box.printinfo();


    }
}
