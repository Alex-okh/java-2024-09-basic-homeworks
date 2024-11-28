package ru.otus.java.basic.homeworks.homework7;

public class Rover extends Vehicle {
    public Rover(String name, double maxFuel, double fuelPerKm) {
        super(name, new TerrainType[]{}, maxFuel, fuelPerKm);
    }
}
