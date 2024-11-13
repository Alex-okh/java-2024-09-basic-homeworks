package homework6;

//Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит). Количество еды измеряем в условных единицах.
//При создании тарелки указывается ее объем и она полностью заполняется едой
//В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
//В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения, в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).
//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.


import java.util.Random;
import java.util.Scanner;


public class MainApp {
    static Random rand = new Random();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько котиков создаем?");
        int choice = scanner.nextInt();

        Cat[] cats = new Cat[choice];


        //создаем котов со случайными именами, цветом и аппетитом от 7 до 13
        for (int i = 0; i < choice; i++) {
            cats[i] = new Cat(getRandomName(), getRandomColor(), rand.nextInt(7) + 7);
        }

        System.out.println("Сколько тарелок подаем?");
        choice = scanner.nextInt();

        // создаем тарелки размером от 50 до 100 вкусняшек
        Plate[] plates = new Plate[choice];
        for (int i = 0; i < choice; i++) {
            plates[i] = new Plate(rand.nextInt(51) + 50);
        }

        System.out.println("\nА теперь попробуем накормить эту ораву\n");

        // Каждый кот пробует поесть из случайной тарелки. Наедается если там осталось достаточно еды.
        for (Cat cat : cats) {
            cat.eat(plates[rand.nextInt(plates.length)]);
        }
        System.out.println("\n А теперь спросим котиков про их состояние \n");
        for (Cat cat : cats) {
            cat.printInfo();
        }
        System.out.println("\nПосмотрим что осталось в тарелках:\n");
        for (int i = 0; i < plates.length; i++) {
            System.out.printf("В тарелке №%d осталось %d вкусняшек.%n", i + 1, plates[i].getCurrentFood());
        }

        // И напоследок проверим, были ли у нас клонированные котики :-)
        // сытость не учитывается, только имя, цвет и аппетит
        System.out.println();
        int clones = 0;
        for (int i = 0; i < cats.length; i++) {
            for (int j = i + 1; j < cats.length; j++) {
                if (cats[i].equals(cats[j])) {
                    clones++;
                    System.out.printf("Найдены клоны: №%d и №%d%n ", i, j);
                }
            }
        }
        System.out.println("Клонов найдено: " + clones);

    }


    public static String getRandomName() {
        String[] names = {"Барсик", "Васька", "Мурзик", "Леопольд", "Лиза", "Шуша", "Симба", "Тайгер", "Томас", "Снежок", "Белка", "Пушок", "Мишка", "Черныш", "Барс", "Багира", "Карамель", "Рыжик", "Маркиз", "Дуся", "Вава", "Зевс", "Матильда", "Муся", "Даша", "Кузя", "Арчи", "Юлия", "Коко", "Марсик", "Бельчонок", "Феликс", "Джек", "Каспер", "Граф", "Пыжик", "Анфиса", "Жорик", "Вилли", "Бельченок", "Слава", "Ришард", "Забияка", "Марго", "Мэй", "Йорик", "Хари", "Базилио", "Миранда", "Бублик", "Кира", "Финик", "Шпунтик", "Мими", "Лея", "Абрикос", "Байрон", "Агата", "Хлоя", "Рокки", "Люк" };
        return names[rand.nextInt(names.length)];
    }

    public static String getRandomColor() {
        String[] colors = {"черный", "рыжий", "белый", "серый", "коричневый", "пепельный", "трехцветный", "мягко-кремовый", "голубоглазый", "черепаховый", "светло-коричневый", "пятнистый", "бежевый", "черно-белый", "рыже-полосатый" };
        return colors[rand.nextInt(colors.length)];
    }


}
