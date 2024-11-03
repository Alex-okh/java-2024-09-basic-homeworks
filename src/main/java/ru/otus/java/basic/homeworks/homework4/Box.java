package ru.otus.java.basic.homeworks.homework4;

public class Box {

    private int size;
    private String color;
    private boolean isOpen;
    private String contains;

    public Box(int size, String color) {
        this.size = size;
        this.color = color;
        isOpen = false;
        contains = "";
    }

    public void open() {
        isOpen = true;
        System.out.println("Открыли коробку.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Закрыли коробку.");
    }

    public void repaint(String newcolor) {
        color = newcolor;
        System.out.println("Покрасили коробку в " + color + " цвет.");
    }

    public boolean isOpen() {
        return isOpen;
    }

    public int getSize() {
        return size;
    }

    public void printinfo() {
        System.out.println("-----------------------------");
        System.out.println("Размер коробки: " + size + "\nЦвет коробки: " + color + "\nСостояние: " + (isOpen ? "Открыта" : "Закрыта"));
        System.out.println("Внутри " + (contains.isEmpty() ? "пусто." : "лежит " + contains));
        System.out.println("-----------------------------\n");
    }

    public String getContains() {
        if (isOpen) {
            if (!contains.isEmpty()) {
                System.out.println("Достали " + contains);
                String result = contains;
                contains = "";
                return result;
            } else {
                System.out.println("В коробке пусто, нечего доставать");
                return "";
            }
        }
        System.out.println("Не можем ничего достать из закрытой коробки");
        return "";
    }

    public boolean putContains(String thing) {
        if (isOpen) {
            if (this.contains.isEmpty()) {
                this.contains = thing;
                System.out.println("Положили в коробку " + this.contains);
                return true;
            }
            System.out.println("Полна коробочка, положить не получилось.");
            return false;
        }
        System.out.println("Коробка закрыта, не можем ничего положить.");
        return false;
    }


}
