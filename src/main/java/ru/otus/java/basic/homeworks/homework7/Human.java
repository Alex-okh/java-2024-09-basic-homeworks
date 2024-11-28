package ru.otus.java.basic.homeworks.homework7;


public class Human {
    private String name;
    private Drivable currentTranspot;

    public Human(String name) {
        this.name = name;
        currentTranspot = null;
    }

    public void takeTransport(Drivable drivable) {
        if (currentTranspot != null) {
            System.out.println("Не могу сесть на два стула сразу.");
            return;
        }
        if (drivable.isOccupied()) {
            System.out.println("Занято");
            return;
        }
        drivable.occupy();
        currentTranspot = drivable;
        System.out.printf("%s сел в %s%n", name, currentTranspot.getVehicleName());
    }

    public void leaveTransport() {
        if (currentTranspot != null) {
            currentTranspot.leave();
            System.out.printf("%s покинул транспорт %s%n", name, currentTranspot.getVehicleName());
            currentTranspot = null;
        }
    }

    public boolean move(int distance, TerrainType terrain) {
        System.out.println();
        if (currentTranspot == null) {
            return walk(distance);

        }
        return drive(distance, terrain);

    }

    private boolean walk(int distance) {
        System.out.printf("%s прошел пешком %d километров.%n", name, distance);
        System.out.println();
        return true;
    }

    private boolean drive(int distance, TerrainType terrain) {
        System.out.printf("%s пробует перевигаться на %s%n", name, currentTranspot.getVehicleName());
        if (currentTranspot.drive(distance, terrain)) {
            System.out.println("Успешно");
            return true;
        }
        System.out.printf("Поездка на %s оказалась неудачной.%n", currentTranspot.getVehicleName());

        return false;
    }
}


