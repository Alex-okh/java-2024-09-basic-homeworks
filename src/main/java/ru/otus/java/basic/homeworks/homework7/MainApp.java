package ru.otus.java.basic.homeworks.homework7;

public class MainApp {
    public static void main(String[] args) {
        Human human = new Human("Вениамин");
        Car car = new Car("Маленький пежо", 50, 0.08);
        Rover rover = new Rover("УАЗИК", 60, 0.15);
        Horse horse = new Horse("Зорька");
        Bike bike = new Bike("Орленок");

        Drivable[] transport = {car, rover, horse, bike};

        System.out.println();
        System.out.println("Состояние транспортных средств:");
        for (Drivable item : transport) {
            System.out.println(item);
        }

        human.move(10, TerrainType.PLANE);
        human.takeTransport(car);
        human.move(20, TerrainType.PLANE);
        human.leaveTransport();
        System.out.println();

        human.takeTransport(horse);
        human.move(30, TerrainType.FOREST);
        human.leaveTransport();
        System.out.println();

        human.takeTransport(rover);
        human.move(40, TerrainType.SWAMP);
        human.leaveTransport();
        System.out.println();

        human.takeTransport(horse);
        human.move(100, TerrainType.SWAMP);
        human.leaveTransport();
        System.out.println();

        human.takeTransport(bike);
        human.move(100, TerrainType.PLANE);
        human.leaveTransport();

        System.out.println();
        System.out.println("Состояние транспортных средств:");
        for (Drivable item : transport) {
            System.out.println(item);
        }

    }


}


