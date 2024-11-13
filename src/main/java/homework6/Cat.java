package homework6;

import java.util.Objects;

//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
public class Cat {
    private String name;
    private String color;
    private int appetite;
    private boolean isHungry;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public Cat(String name, String color, int appetite) {
        this.name = name;
        this.color = color;
        this.appetite = appetite;
        isHungry = true;
    }

    public boolean eat(Plate plate) {
        if (isHungry) {
            if (plate.consumeFood(appetite)) {
                isHungry = false;
                System.out.printf("Котик %s успешно покушал.%n", name);
            } else {
                System.out.printf("Котику %s не хватило еды.%n", name);
            }
        }

        return !isHungry;
    }

    public void printInfo() {
        System.out.printf("Меня зовут %s. Мой цвет %s. Мой аппетит %d. Я %s.%n", name, color, appetite, isHungry ? "голоден" : "сыт");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return appetite == cat.appetite && Objects.equals(name, cat.name) && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, appetite);
    }
}
